package com.yangjun.cms.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: Slide 
 * @Description: 广告表
 * @author: Y
 * @date: 2020年3月3日 下午4:55:39
 */
public class Slide implements Serializable{
	private static final long serialVersionUID=1L;
	private Integer id;//主键
	private String title;//广告的文字说明
	private String picture;//广告的图片地址
	private String url;//点击广告进入的广告详情
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
