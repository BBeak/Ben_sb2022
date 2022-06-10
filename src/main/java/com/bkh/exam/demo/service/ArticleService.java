package com.bkh.exam.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vo.Article;

@Service
public class ArticleService {
	private int articleLastId;
	private static List<Article> articles;
	public ArticleService() {
		articleLastId = 0;
		articles = new ArrayList<>();
		
		makeTestData();
	}
	private void makeTestData() {
		for (int i =1; i <= 10; i++) {
			int id = articleLastId +1;
			String title = "title"+i;
			String body = "body"+i;
			Article article = new Article (id, title, body);
			
			articles.add(article);
			articleLastId = id;
		}
	}
	public List<Article> getArticles(){
		return articles;
	}
	public Article writeArticle( String title, String body) {
		int id = articleLastId+1;
		Article article = new Article(id, title, body);
		articles.add(article);
		articleLastId = id;
		return article;
		
	}
	public static Article getArticleByID(int id) {
		for (Article article : articles) {
			if(id == article.id) {
				return article;
			}
		}
			return null;
		
	}

	public void deleteArticle(int id) {
		Article article = getArticleByID(id);
		
		articles.remove(article);
	}
}
