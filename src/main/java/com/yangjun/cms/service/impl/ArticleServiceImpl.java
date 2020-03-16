package com.yangjun.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangjun.cms.dao.ArticleMapper;
import com.yangjun.cms.entity.Article;
import com.yangjun.cms.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articlemapper;
	
	@Override
	public int insert(Article article) {
		// TODO Auto-generated method stub
		return articlemapper.insert(article);
	}

	@Override
	public PageInfo<Article> selects(Article article,Integer page,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		List<Article> articles = articlemapper.selects(article);
 		return new PageInfo<Article>(articles);
	}

	/* (non Javadoc) 
	 * @Title: publish
	 * @Description: 增加的方法
	 * @param article
	 * @return 
	 * @see com.yangjun.cms.service.ArticleService#publish(com.yangjun.cms.entity.Article) 
	 */
	@Override
	public boolean publish(Article article) {
		// TODO Auto-generated method stub
		return articlemapper.insert(article)>0;
	}

	/* (non Javadoc) 
	 * @Title: articleDetail
	 * @Description: TODO
	 * @param id
	 * @return 
	 * @see com.yangjun.cms.service.ArticleService#articleDetail(java.lang.Integer) 
	 */
	@Override
	public Article articleDetail(Integer id) {
		// TODO Auto-generated method stub
		return articlemapper.articleDetail(id);
	}

	/* (non Javadoc) 
	 * @Title: update
	 * @Description: TODO
	 * @param article
	 * @return 
	 * @see com.yangjun.cms.service.ArticleService#update(com.yangjun.cms.entity.Article) 
	 */
	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articlemapper.update(article);
	}


}
