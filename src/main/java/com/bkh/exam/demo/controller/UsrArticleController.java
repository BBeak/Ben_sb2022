package com.bkh.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bkh.exam.demo.service.ArticleService;

import vo.Article;

@Controller
public class UsrArticleController {
	// 인스턴스 변수 시작
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		
		Article article = articleService.writeArticle(title,body);
		
		return article;
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article>getArticles(){
		return articleService.getArticles();
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id){
		
		Article article = articleService.getArticleByID(id);
		
		if(article == null) {
			return id+"번 게시물은 존재하지 않습니다.";
		}
		articleService.deleteArticle(id);
		return id+"번 게시물을 삭제하였습니다.";
		
	}
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public Article doModify(int id, String title, String body){
		
		return articleService.modifyArticle(id, title, body);
	}
	@RequestMapping("/usr/article/showDetail")
	@ResponseBody
	public Object showDetail(int id) {
		
	
		
		return articleService.articleDetail(id);
	}
	
	
}
	
