/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: PassportController.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.controller 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月11日 上午10:36:19 
 * @version: V1.0   
 */
package com.yangjun.cms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangjun.cms.entity.User;
import com.yangjun.cms.service.UserService;
import com.yangjun.cms.util.CMSException;
import com.yangjun.cms.util.Result;

/** 
 * @ClassName: PassportController 
 * @Description: 系统的注册登录入口
 * @author: Y
 * @date: 2020年3月11日 上午10:36:19  
 */
@RequestMapping("passport")
@Controller
public class PassportController {

	@Resource
	private UserService userService;
	/**
	 * 
	 * @Title: reg 
	 * @Description: 去注册
	 * @return
	 * @return: String
	 */
	@GetMapping("reg")
	public String reg() {
		
		return "/passport/reg";
	}
	
	@ResponseBody
	@RequestMapping("reg")
	public Result<User> reg(User user,Model model,HttpSession session) {
		Result<User> result=new Result<User>();
		try {
			if (userService.insert(user)>0) {
				result.setCode(200);
				result.setMsg("注册成功");
				session.setAttribute("username", user.getUsername());
			}
		} catch (CMSException e) {
			// TODO: handle exception
			result.setCode(300);
			result.setMsg("注册失败"+e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMsg("注册失败,系统出现不可预知异常，请联系管理员");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("checkName")
	public boolean checkName(User user) {
		
		return userService.selectByUsername(user)==null;
	}
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	
	/**
	 * 
	 * @Title: reg 
	 * @Description: 登录
	 * @return
	 * @return: String
	 */
	@GetMapping("login")
	public String login() {
		
		return "/passport/login";
	}
	
	@ResponseBody
	@RequestMapping("login")
	public Result<User> login(User user,Model model,HttpSession session) {
		Result<User> result=new Result<User>();
		System.out.println(user);
		User user2 = userService.login(user);
		try {
			if (null!=user2) {
				result.setCode(200);
				result.setMsg("登录成功");
				if (user2.getRole()==0) {
					session.setAttribute("user", user2);
				}else {
					session.setAttribute("admin", user2);
				}
			}
		} catch (CMSException e) {
			// TODO: handle exception
			result.setCode(300);
			result.setMsg("登录失败"+e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMsg("登录失败,系统出现不可预知异常，请联系管理员");
		}
		return result;
	}
	
	@GetMapping("admin/login")
	public String adminLogin() {
		
		
		return "passport/adminlogin";
	}
}
