package com.zhan.app.news.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhan.app.common.News;
import com.zhan.app.common.NewsDetial;
import com.zhan.app.news.service.NewsService;
import com.zhan.app.news.util.ResultUtil;

@RestController
@RequestMapping("/hot")
public class NewsController {
	private static Logger log = Logger.getLogger(NewsController.class);

	@Resource
	private NewsService newsService;

	@RequestMapping("list")
	public ModelMap list(HttpServletRequest request, String publish_time, int count, String aid, Integer url_type) {
		if (count > 100) {
			count = 20;
		}
		if (count <= 0) {
			return ResultUtil.getResultOKMap();
		}

		if ("1226437040".equals(aid)) {
			url_type = 0;
		}
		if ("1249198078".equals(aid)) {
			url_type = 0;
		}
		if ("1236362107".equals(aid)) {
			url_type = 0;
		}
		if (url_type == null) {
			url_type = -1;
		}

		List<?> news = newsService.list(publish_time, count, url_type);
		ModelMap result = ResultUtil.getResultOKMap();
		result.put("news", news);
		return result;
	}

	@RequestMapping("detial")
	public ModelMap detial(HttpServletRequest request, String id) {
		NewsDetial news = newsService.find(id);
		ModelMap result = ResultUtil.getResultOKMap();
		result.put("news", news);
		return result;
	}

}