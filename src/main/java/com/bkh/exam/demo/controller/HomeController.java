package com.bkh.exam.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.Article;

@Controller
public class HomeController {
	@RequestMapping("/usr/home/getString")
	@ResponseBody
	public String getString() {
		return "Hi";
	}
	@RequestMapping("/usr/home/getMap")
	@ResponseBody
	public Map<String, Object> getMap() {
		Map<String, Object>map = new HashMap<>();
		map.put("hi",22);
		map.put("hello", 33);
		
		return map;
	}
	

	@RequestMapping("/usr/home/getInt")
	@ResponseBody
	public int getInt() {
		return 1;
	}

	@RequestMapping("/usr/home/getFloat")
	@ResponseBody
	public float getFloat() {
		return 10;
	}

	@RequestMapping("/usr/home/getDouble")
	@ResponseBody
	public double getDouble() {
		return 10.5;
	}

	@RequestMapping("/usr/home/getBoolean")
	@ResponseBody
	public boolean getBoolean() {
		return false;
	}

	@RequestMapping("/usr/home/getArticle")
	@ResponseBody
	public Article getArticle() {

		Article article = new Article(1, "title", "body");

		return article;
	}

	@RequestMapping("/usr/home/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		
		Article article1 = new Article(1, "title", "body1");
		Article article2 = new Article(2, "title", "body2");
		
		List<Article> list = new ArrayList<>();
		list.add(article1);
		list.add(article2)    ;

		return list;
	}
}

