package com.yangjun.cms.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: Category 
 * @Description: 栏目的子分类
 * @author: Y
 * @date: 2020年3月3日 上午11:23:21
 */
public class Category implements Serializable{
	private static final long serialVersionUID=1L;
	private Integer id;//主键
	private String name;
	private Integer channelId;//所属栏目的ID
	private Integer sorted;//排序
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Integer getSorted() {
		return sorted;
	}
	public void setSorted(Integer sorted) {
		this.sorted = sorted;
	}
	
}
