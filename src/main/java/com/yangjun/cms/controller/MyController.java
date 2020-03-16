package com.yangjun.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.yangjun.cms.entity.Article;
import com.yangjun.cms.entity.Collect;
import com.yangjun.cms.entity.User;
import com.yangjun.cms.service.ArticleService;
import com.yangjun.cms.service.CollectService;

/**
 * 
 * @ClassName: MyController
 * @Description: 个人中心
 * @author: Y
 * @date: 2020年3月4日 上午10:51:07
 */
@RequestMapping("my")
@Controller
public class MyController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private CollectService collectService;

	/**
	 * 
	 * @Title: index
	 * @Description: 进入个人中心的首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","my"})
	public String index() {

		return "my/index";
	}

	/**
	 * 
	 * @Title: articlies
	 * @Description: 我的文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articlies(Model model,@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3")Integer pageSize,HttpSession session) {
		User user = (User)session.getAttribute("user");
		Article article = new Article();
		article.setUserId(user.getId());
		
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		
		model.addAttribute("info", info);
		return "my/articles";
	}
	
	/**
	 * 
	 * @Title: publish
	 * @Description: 去发布文章
	 * @return
	 * @return: String
	 */
	@GetMapping("publish")
	public String publish() {

		return "my/publish";
	}

	/**
	 * 
	 * @Title: publish
	 * @Description: 发布文章
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("publish")
	public boolean publish(MultipartFile file, Article article,HttpSession session) {

		if (null != file && !file.isEmpty()) {
			String path = "e:/tools/pic/";
			String filename = file.getOriginalFilename();
			String newFilename = UUID.randomUUID() + filename.substring(filename.indexOf("."));
			File f = new File(path, newFilename);

			try {
				file.transferTo(f);
				article.setPicture(newFilename);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		User user = (User)session.getAttribute("user");
		article.setUserId(user.getId());
		article.setCreated(new Date());
		article.setHits(0);
		article.setDeleted(0);
		article.setHot(0);
		article.setStatus(0);
		return articleService.publish(article);
	}

	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 單個文章内容
	 * @return
	 * @return: Article
	 */
	@ResponseBody
	@RequestMapping("articleDetail")
	public Article articleDetail(Integer id) {
		
		return articleService.articleDetail(id);
	}

	
	@GetMapping("collectarticles")
	public String collectarticles(Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		List<Collect> collects=collectService.selectByUserId(user.getId());
		model.addAttribute("collects",collects);
		return "my/collectarticles";
	}
}
