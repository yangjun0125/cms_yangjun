/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: SlideMapper.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.dao 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月11日 上午8:53:43 
 * @version: V1.0   
 */
package com.yangjun.cms.dao;

import java.util.List;

import com.yangjun.cms.entity.Slide;

/** 
 * @ClassName: SlideMapper 
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月11日 上午8:53:43  
 */
public interface SlideMapper {
	List<Slide> selects();
}
