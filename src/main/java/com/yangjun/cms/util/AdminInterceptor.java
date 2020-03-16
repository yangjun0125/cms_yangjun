/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: MyInterceptor.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.util 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月13日 下午4:29:58 
 * @version: V1.0   
 */
package com.yangjun.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * @ClassName: MyInterceptor 
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月13日 下午4:29:58  
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Object obj = session.getAttribute("admin");
		if (null!=obj) {
			return true;
		}
		request.setAttribute("msg","请登录后重试");
		request.getRequestDispatcher("/WEB-INF/view/passport/adminlogin.jsp").forward(request, response);
		return false;
	}

	
}
