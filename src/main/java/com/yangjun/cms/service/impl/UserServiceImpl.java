/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: UserServiceImpl.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.service.impl 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月7日 上午9:54:26 
 * @version: V1.0   
 */
package com.yangjun.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangjun.cms.dao.UserMapper;
import com.yangjun.cms.entity.User;
import com.yangjun.cms.service.UserService;
import com.yangjun.cms.util.CMSException;
import com.yangjun.cms.util.Md5Util;
import com.yangjun.common.utils.StringUtil;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月7日 上午9:54:26
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserMapper userMapper;

	/*
	 * (non Javadoc)
	 * 
	 * @Title: selects
	 * 
	 * @Description: TODO
	 * 
	 * @param user
	 * 
	 * @param page
	 * 
	 * @param pageSize
	 * 
	 * @return
	 * 
	 * @see com.yangjun.cms.service.UserService#selects(com.yangjun.cms.entity.User,
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public PageInfo<User> selects(User user, Integer page, Integer pageSize) {
		// TODO Auto-generated method stu
		PageHelper.startPage(page, pageSize);
		List<User> users = userMapper.selects(user);
		return new PageInfo<User>(users);
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: userupdate
	 * 
	 * @Description: TODO
	 * 
	 * @param user
	 * 
	 * @return
	 * 
	 * @see
	 * com.yangjun.cms.service.UserService#userupdate(com.yangjun.cms.entity.User)
	 */
	@Override
	public int userupdate(User user) {
		// TODO Auto-generated method stub
		return userMapper.userupdate(user);
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: insert
	 * 
	 * @Description: TODO
	 * 
	 * @param user
	 * 
	 * @return
	 * 
	 * @see com.yangjun.cms.service.UserService#insert(com.yangjun.cms.entity.User)
	 */
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		if (!StringUtil.hasText(user.getUsername())) {
			throw new CMSException("用户名不能为空");
		}
		if (!(user.getUsername().length()>=2 && user.getUsername().length()<=10)) {
			throw new CMSException("用户名必须为2-10位");
		}
		User fineUser = this.selectByUsername(user);
		if (null!=fineUser) {
			throw new CMSException("用户名已被注册");
		}
		if (!StringUtil.hasText(user.getPassword())) {
			throw new CMSException("密码不能为空");
		}
		if (!(user.getPassword().length()>=6 && user.getPassword().length()<=10)) {
			throw new CMSException("密码长度必须为6-10位");
		}
		if (!StringUtil.hasText(user.getRepassword())) {
			throw new CMSException("确认密码不能为空");
		}
		if (!user.getRepassword().equals(user.getPassword())) {
			throw new CMSException("两次密码输入不一致");
		}
		user.setPassword(Md5Util.encode(user.getPassword()));
		user.setCreated(new Date());
		user.setNickname(user.getUsername());
		user.setLocked("0");
		return userMapper.insert(user);
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: selectByUsername
	 * 
	 * @Description: TODO
	 * 
	 * @param user
	 * 
	 * @return
	 * 
	 * @see
	 * com.yangjun.cms.service.UserService#selectByUsername(com.yangjun.cms.entity.
	 * User)
	 */
	@Override
	public User selectByUsername(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectByUsername(user);
	}

	/* (non Javadoc) 
	 * @Title: login
	 * @Description: TODO
	 * @param user
	 * @return 
	 * @see com.yangjun.cms.service.UserService#login(com.yangjun.cms.entity.User) 
	 */
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		if (!StringUtil.hasText(user.getUsername())) {
			throw new CMSException("用户名不能为空");
		}
		if (!StringUtil.hasText(user.getPassword())) {
			throw new CMSException("密码不能为空");
		}
		User u = this.selectByUsername(user);
		if (u==null) {
			throw new CMSException("用户名不存在");
		}
		if (!Md5Util.encode(user.getPassword()).equals(u.getPassword())) {
			throw new CMSException("密码错误");
		}
		if(u.getLocked().equals("1")) {
			throw new CMSException("当前账户被禁用，不能登录");
		}
		user.setPassword(Md5Util.encode(user.getPassword()));
		return userMapper.login(user);
	}

}
