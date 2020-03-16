/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: IndexController.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.controller 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月9日 上午11:21:03 
 * @version: V1.0   
 */
package com.yangjun.cms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yangjun.cms.entity.Article;
import com.yangjun.cms.entity.Category;
import com.yangjun.cms.entity.Channel;
import com.yangjun.cms.entity.Collect;
import com.yangjun.cms.entity.Comment;
import com.yangjun.cms.entity.Slide;
import com.yangjun.cms.entity.User;
import com.yangjun.cms.service.ArticleService;
import com.yangjun.cms.service.ChannelService;
import com.yangjun.cms.service.CollectService;
import com.yangjun.cms.service.CommentService;
import com.yangjun.cms.service.SlideService;

/**
 * @ClassName: IndexController
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月9日 上午11:21:03
 */
@Controller
public class IndexController {

	@Resource
	private ChannelService channelservice;

	@Resource
	private ArticleService articleService;

	@Resource
	private SlideService slideService;

	@Resource
	private CommentService commentService;

	@Resource
	private CollectService collectService;

	@RequestMapping(value = { "", "/", "index" })
	public String index(Model model, Article article, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize) {
		article.setStatus(1);
		article.setDeleted(0);
		if (article.getChannelId() == null) {
			article.setHot(1);
			List<Slide> slides = slideService.selects();
			model.addAttribute("slides", slides);
		}
		model.addAttribute("article", article);
		List<Channel> channels = channelservice.selects();
		if (article.getChannelId() != null) {
			List<Category> categorys = channelservice.selectsByChannelId(article.getChannelId());
			model.addAttribute("categorys", categorys);
		}
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("channels", channels);
		model.addAttribute("info", info);
		Article article2 = new Article();
		article2.setStatus(1);
		article2.setDeleted(0);
		PageInfo<Article> lastarticles = articleService.selects(article2, page, 10);
		model.addAttribute("lastarticles", lastarticles);
		return "index/index";
	}

	/**
	 * 
	 * @Title: articleDetail
	 * @Description: 單個文章内容
	 * @return
	 * @return: Article
	 */
	@RequestMapping("articleDetail")
	public String articleDetail(HttpSession session, Model model, Integer id,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer pageSize) {
		Article article = articleService.articleDetail(id);
		model.addAttribute("article", article);
		PageInfo<Comment> info = commentService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		PageInfo<Article> info2 = commentService.selectsByCommentNum(page, pageSize);
		model.addAttribute("info2", info2);

		// 查询该文章是否被收藏过

		User user = (User) session.getAttribute("user");
		Collect collect = null;
		if (null != user) {// 如果用户已经登录，则查询是否没收藏过
			collect = collectService.selectByTitleAndUserId(article.getTitle(), user.getId());
		}
		model.addAttribute("collect", collect);
		return "index/articleDetail";
	}

	@ResponseBody
	@RequestMapping("addComment")
	public boolean addcomment(Comment comment, Integer articleId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		comment.setUserId(user.getId());
		comment.setArticleId(articleId);
		comment.setCreated(new Date());
		commentService.insert(comment);
		return commentService.articleUpate(articleId) > 0;
	}

	// 删除文章
	@ResponseBody
	@RequestMapping("deleteCollect")
	public boolean collect(Integer id) {
		return collectService.delete(id) > 0;
	}

	// 收藏文章
	@ResponseBody
	@RequestMapping("collect")
	public boolean collect(Collect collect, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (null == user)
			return false;// 没有登录的用户不能收藏
		collect.setUser(user);
		collect.setCreated(new Date());
		return collectService.insert(collect) > 0;
	}

}
