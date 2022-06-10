package com.bkh.exam.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bkh.demo.reporsitory.ArticleRepository;

import vo.Article;

@Service
public class ArticleService {
	private ArticleRepository articleRepository;

	public ArticleService() {
		this.articleRepository = new ArticleRepository();
		articleRepository.makeTestData();
	}

	public List<Article> getArticles() {
		return articleRepository.getarticles();
	}

	public Article writeArticle(String title, String body) {
		return articleRepository.writeArticle(title, body);
	}

	public Article getArticleByID(int id) {
		return articleRepository.getArticleByID(id);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}
	public Article modifyArticle(int id, String title, String body) {
		return articleRepository.modifyArticle(id,title,body);
	}

	public Object articleDetail(int id) {
	
		return articleRepository.articleDetail(id);
	}
}
