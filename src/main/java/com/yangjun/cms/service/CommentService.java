/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: CommentMapper.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.dao 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月15日 上午10:09:12 
 * @version: V1.0   
 */
package com.yangjun.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yangjun.cms.entity.Article;
import com.yangjun.cms.entity.Comment;

import net.sf.jsqlparser.statement.update.Update;

/** 
 * @ClassName: CommentMapper 
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月15日 上午10:09:12  
 */
public interface CommentService {
	/**
	 * 
	 * @Title: insert 
	 * @Description: TODO
	 * @param comment
	 * @return
	 * @return: int
	 */
	int insert (Comment comment);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @return
	 * @return: List<Comment>
	 */
	PageInfo<Comment> selects(Article article,Integer page,Integer pageSize);
	
	int articleUpate(Integer articleId);
	
	PageInfo<Article> selectsByCommentNum(Integer page,Integer pageSize);
}
