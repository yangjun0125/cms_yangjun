/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: UserService.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.service 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月7日 上午9:54:09 
 * @version: V1.0   
 */
package com.yangjun.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yangjun.cms.entity.User;

/** 
 * @ClassName: UserService 
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月7日 上午9:54:09  
 */
public interface UserService {

	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询所有用户
	 * @param user
	 * @return
	 * @return: List<User>
	 */
	PageInfo<User> selects(User user,Integer page,Integer pageSize);

	/** 
	 * @Title: userupdate 
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: int
	 */
	int userupdate(User user);
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 注册用户
	 * @param user
	 * @return
	 * @return: int
	 */
	int insert(User user);
	/**
	 * 
	 * @Title: selectByUsername 
	 * @Description: 查询用户
	 * @param user
	 * @return
	 * @return: User
	 */
	User selectByUsername(User user);
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 登录
	 * @param user
	 * @return
	 * @return: User
	 */
	User login(User user);
}
