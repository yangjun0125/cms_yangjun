package com.yangjun.cms.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName: User 
 * @Description:用户表
 * @author: Y
 * @date: 2020年3月3日 下午4:55:51
 */
public class User implements Serializable{
	private static final long serialVersionUID=1L;
	private Integer id;//主键
	private String username;
	private String password;
	private String repassword;
	private String nickname;//昵称
	private Date birthday;
	private String gender;
	private String locked;//0:正常 ，1:禁用 
	private Date created;//注册时间
	private Date updated;//修改时间
	private Integer role;
	
	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}
	
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", repassword=" + repassword
				+ ", nickname=" + nickname + ", birthday=" + birthday + ", gender=" + gender + ", locked=" + locked
				+ ", created=" + created + ", updated=" + updated + ", role=" + role + "]";
	}
	
	
	
}
