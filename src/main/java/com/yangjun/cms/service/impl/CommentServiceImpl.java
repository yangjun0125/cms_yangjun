/**   
 * Copyright © 2020 公司名. All rights reserved.
 * 
 * @Title: CommentServiceImpl.java 
 * @Prject: Yangjun-Cms
 * @Package: com.yangjun.cms.service.impl 
 * @Description: TODO
 * @author: Y   
 * @date: 2020年3月15日 上午10:13:05 
 * @version: V1.0   
 */
package com.yangjun.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangjun.cms.dao.CommentMapper;
import com.yangjun.cms.entity.Article;
import com.yangjun.cms.entity.Comment;
import com.yangjun.cms.service.CommentService;

import net.sf.jsqlparser.statement.update.Update;

/** 
 * @ClassName: CommentServiceImpl 
 * @Description: TODO
 * @author: Y
 * @date: 2020年3月15日 上午10:13:05  
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Resource
	CommentMapper commentMapper;
	
	/* (non Javadoc) 
	 * @Title: insert
	 * @Description: TODO
	 * @param comment
	 * @return 
	 * @see com.yangjun.cms.service.CommentService#insert(com.yangjun.cms.entity.Comment) 
	 */
	@Override
	public int insert(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.insert(comment);
	}

	/* (non Javadoc) 
	 * @Title: selects
	 * @Description: TODO
	 * @param article
	 * @return 
	 * @see com.yangjun.cms.service.CommentService#selects(com.yangjun.cms.entity.Article) 
	 */
	@Override
	public PageInfo<Comment> selects(Article article,Integer page,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		List<Comment> list = commentMapper.selects(article);
		return new PageInfo<Comment>(list);
	}

	/* (non Javadoc) 
	 * @Title: articleUpate
	 * @Description: TODO
	 * @param articleId
	 * @return 
	 * @see com.yangjun.cms.service.CommentService#articleUpate(java.lang.Integer) 
	 */
	@Override
	public int articleUpate(Integer articleId) {
		// TODO Auto-generated method stub
		return commentMapper.articleUpate(articleId);
	}

	/* (non Javadoc) 
	 * @Title: selectsByCommentNum
	 * @Description: TODO
	 * @return 
	 * @see com.yangjun.cms.service.CommentService#selectsByCommentNum() 
	 */
	@Override
	public PageInfo<Article> selectsByCommentNum(Integer page,Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Article> list = commentMapper.selectsByCommentNum();
		return new PageInfo<Article>(list);
	}

}
