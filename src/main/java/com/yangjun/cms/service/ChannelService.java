package com.yangjun.cms.service;

import java.util.List;

import com.yangjun.cms.entity.Category;
import com.yangjun.cms.entity.Channel;

public interface ChannelService {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询所有栏目
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();

	/** 
	 * @Title: selectsByChannelId 
	 * @Description: TODO
	 * @param channelid
	 * @return
	 * @return: List<Category>
	 */
	List<Category> selectsByChannelId(Integer channelid);
}
