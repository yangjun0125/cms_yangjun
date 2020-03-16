/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: UserMapper.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.dao 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月7日 上午9:48:33 
 * @version: V1.0   
 */
package com.yangjun.cms.dao;

import java.util.List;

import com.yangjun.cms.entity.User;

/** 
 * @ClassName: UserMapper 
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月7日 上午9:48:33  
 */
public interface UserMapper {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询所有用户
	 * @param user
	 * @return
	 * @return: List<User>
	 */
	List<User> selects(User user);

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
