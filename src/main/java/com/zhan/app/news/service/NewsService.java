package com.zhan.app.news.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhan.app.common.News;
import com.zhan.app.common.NewsDetial;
import com.zhan.app.news.dao.NewsDao;

@Service
public class NewsService {
	@Resource
	private NewsDao newsDao;

	public String insert(News news) {
		return newsDao.save(news);
	}

	public long insert(NewsDetial news) {
		newsDao.save(news);
		return 0;
	}

	public boolean hasExist(News news) {
		long count = newsDao.getCount(news);
		return count > 0;
	}

	public List<?> list(String publish_time, int limit,int url_type) {
		return newsDao.list(publish_time, limit,url_type);
	}
	
	public NewsDetial find(String id){
		return newsDao.find(id);
	}
}
