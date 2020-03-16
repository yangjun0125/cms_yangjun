/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: CMSExcetion.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.util 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月12日 上午9:02:01 
 * @version: V1.0   
 */
package com.yangjun.cms.util;

/** 
 * @ClassName: CMSExcetion 
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月12日 上午9:02:01  
 */
public class CMSException extends RuntimeException{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CMSException(String message) {
		super();
		this.message = message;
	}
	

}
