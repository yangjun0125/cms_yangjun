/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: SlideServiceImpl.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.service.impl 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月11日 上午8:56:56 
 * @version: V1.0   
 */
package com.yangjun.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangjun.cms.dao.SlideMapper;
import com.yangjun.cms.entity.Slide;
import com.yangjun.cms.service.SlideService;

/** 
 * @ClassName: SlideServiceImpl 
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月11日 上午8:56:56  
 */
@Service
public class SlideServiceImpl implements SlideService {

	@Resource
	private SlideMapper slideMappper;
	
	/* (non Javadoc) 
	 * @Title: selects
	 * @Description: TODO
	 * @return 
	 * @see com.yangjun.cms.service.SlideService#selects() 
	 */
	@Override
	public List<Slide> selects() {
		// TODO Auto-generated method stub
		return slideMappper.selects();
	}

}
