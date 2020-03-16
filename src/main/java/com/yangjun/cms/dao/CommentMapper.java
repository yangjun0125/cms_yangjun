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
package com.yangjun.cms.dao;

import java.util.List;

import com.yangjun.cms.entity.Article;
import com.yangjun.cms.entity.Comment;

/** 
 * @ClassName: CommentMapper 
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月15日 上午10:09:12  
 */
public interface CommentMapper {
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
	List<Comment> selects(Article article);
	
	int articleUpate(Integer articleId);
	
	List<Article> selectsByCommentNum();
}
