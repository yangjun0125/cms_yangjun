/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: AdminController.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.controller 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月6日 上午10:00:22 
 * @version: V1.0   
 */
package com.yangjun.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yangjun.cms.dao.UserMapper;
import com.yangjun.cms.entity.Article;
import com.yangjun.cms.entity.User;
import com.yangjun.cms.service.ArticleService;
import com.yangjun.cms.service.UserService;

/** 
 * @ClassName: AdminController 
 * @Description: 管理员中心
 * @author: Y
 * @date: 2020年3月6日 上午10:00:22  
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

	@Resource
	ArticleService articleService;
	
	@Resource
	UserService userService;
	
	@RequestMapping("users")
	public String users(Model model,User user,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		PageInfo<User> info = userService.selects(user, page, pageSize);
		model.addAttribute("info", info);
		return "admin/users";
	}
	
	/**
	 * 
	 * @Title: index 
	 * @Description: 管理员首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index() {
		
		return "admin/index";
	}
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询条件
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(Model model,Article article,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		if (article.getStatus()==null) {
			article.setStatus(0);
		}
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info",info);
		return "admin/articles";
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改文章的方法
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("update")
	public boolean update(Article article) {
		return articleService.update(article)>0;
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改文章的方法
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("userupdate")
	public boolean Userupdate(User user) {
		
		return userService.userupdate(user)>0;
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
}
