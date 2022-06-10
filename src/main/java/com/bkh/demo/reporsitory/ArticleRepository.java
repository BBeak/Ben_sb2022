package com.bkh.demo.reporsitory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vo.Article;

@Component
public class ArticleRepository {
	private int articlesLastId;
	private List<Article> articles;

	public ArticleRepository() {
		articlesLastId = 0;
		articles = new ArrayList<>();

	}

	public void makeTestData() {
		for (int i = 1; i <= 10; i++) {
			int id = articlesLastId + 1;
			String title = "title" + i;
			String body = "body" + i;
			Article article = new Article(id, title, body);

			articles.add(article);
			articlesLastId = id;
		}
	}

	public Article writeArticle(String title, String body) {
		int id = articlesLastId + 1;
		Article article = new Article(id, title, body);
		articles.add(article);
		articlesLastId = id;
		return article;

	}

	public Article getArticleByID(int id) {
		for (Article article : articles) {
			if (id == article.id) {
				return article;
			}
		}
		return null;

	}

	public void deleteArticle(int id) {
		Article article = getArticleByID(id);

		articles.remove(article);
	}

	public List<Article> getarticles() {

		return articles;
	}

	public Article modifyArticle(int id, String title, String body) {
		Article article = getArticleByID(id);
		
		article.setTitle(title);
		article.setBody(body);
		
		
		return article;
	}

	public Object articleDetail(int id) {
		Article fdarticle = getArticleByID(id);
		
		if(fdarticle == null ) {
			return id+"번 게시물은 존재하지 않습니다.";
		}
		
		return fdarticle;
	}

}
