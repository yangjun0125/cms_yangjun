package com.yangjun.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangjun.cms.entity.Category;
import com.yangjun.cms.entity.Channel;
import com.yangjun.cms.service.ChannelService;

@RequestMapping("channel")
@Controller
public class ChannelController {
	
	@Resource
	ChannelService channelService;
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 返回所有的栏目
	 * @return
	 * @return: List<Channel>
	 */
	@ResponseBody
	@RequestMapping("channels")
	public List<Channel> selects() {
		List<Channel> channels = channelService.selects();
		
		return channels;
	}
	
	/**
	 * 
	 * @Title: selectsByChannelId 
	 * @Description: 获取栏目的子分类
	 * @param channelid
	 * @return
	 * @return: List<Category>
	 */
	@ResponseBody
	@RequestMapping("selectsByChannelId")
	public List<Category> selectsByChannelId(Integer channelid) {
		List<Category> categories = channelService.selectsByChannelId(channelid);
		System.out.println(1);
		return categories;
	}
	
	
}
