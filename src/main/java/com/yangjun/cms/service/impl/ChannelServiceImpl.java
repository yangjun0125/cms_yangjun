package com.yangjun.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangjun.cms.dao.ChannelMapper;
import com.yangjun.cms.entity.Category;
import com.yangjun.cms.entity.Channel;
import com.yangjun.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService{

	@Resource
	ChannelMapper channelMapper;
	
	@Override
	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return channelMapper.selects();
	}

	/* (non Javadoc) 
	 * @Title: selectsByChannelId
	 * @Description: TODO
	 * @param channelid
	 * @return 
	 * @see com.yangjun.cms.service.ChannelService#selectsByChannelId(java.lang.Integer) 
	 */
	@Override
	public List<Category> selectsByChannelId(Integer channelid) {
		// TODO Auto-generated method stub
		return channelMapper.selectsByChannelId(channelid);
	}

}
