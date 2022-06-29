package com.bkh.demo.reporsitory;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import vo.Article;

@Mapper
public interface ArticleRepository {
	

	public int writeArticle(String title, String body);
	
	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticleByID(@Param("id") int id);
	@Delete("DELETE FROM article WHERE id = #{id}")
	public void deleteArticle(@Param("id") int id) ;

	public List<Article> getarticles();
	@Update("UPDATE article SET title = #{title}, `body` = #{body}, updateDate = NOW() WHERE id = #{id}")
	public Article modifyArticle(@Param("id") int id, @Param("title") String title,@Param("body") String body);
	
	public Object articleDetail(int id);
	@Select("SELECT * FROM article ORDER BY id DESC")
	public void makeTestData();
}
