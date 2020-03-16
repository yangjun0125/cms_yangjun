package com.yangjun.cms.dao;
/**
 * 
 * @ClassName: ChannelMapper 
 * @Description: 栏目
 * @author: Y
 * @date: 2020年3月5日 上午10:06:31
 */

import java.util.List;

import com.yangjun.cms.entity.Category;
import com.yangjun.cms.entity.Channel;

public interface ChannelMapper {
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
