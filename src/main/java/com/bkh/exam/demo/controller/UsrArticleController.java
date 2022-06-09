package com.bkh.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.Article;

@Controller
public class UsrArticleController {
	private List<Article>articles;
	private int articleLastId = 0;
	
	public UsrArticleController() {
		articles = new ArrayList<>();
	}
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		int id = articleLastId + 1 ;
		Article article = new Article(id,title,body);
		
		articles.add(article);
		articleLastId = id;
		
		return article;
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article>getArticles(){
		return articles;
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id){
		Article fdarticle = getArticleByID(id);
		
		if (fdarticle==null) {
			return id+"번 게시물은 존재하지 않습니다.";
		}
		articles.remove(fdarticle);
		
		return id+"번 게시물을 삭제하였습니다.";
		
	}
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public Article doModify(int id, String title, String body){
		Article fdarticle = getArticleByID(id);
		
		if (fdarticle == null) {
			return null;
		}
		
		fdarticle.id = id;
		fdarticle.title = title;
		fdarticle.body = body;
		
		return fdarticle;
		
	}
	private Article getArticleByID(int id) {
		for (Article article : articles) {
			if(id == article.id) {
				return article;
			}
		}
			return null;
		
	}
	
}
	
