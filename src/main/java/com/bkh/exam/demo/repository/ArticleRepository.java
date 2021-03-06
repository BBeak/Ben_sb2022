package com.bkh.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bkh.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {
	public void writeArticle(@Param("memberId") int memberId, @Param("boardId") int boardId,
			@Param("title") String title, @Param("body") String body);

	@Select("""
			<script>
			SELECT A.*,
			FROM article AS A
			M.nickname As extra__writerName
			LEFT JOIN `member` AS M
			ON A.memberId = M.id
			LEFT JOIN reactionPoint AS RP
			ON RP.relTypeCode = 'article'
			AND A.id = RP.relId
			WHERE 1
			AND A.id = #{id}
			GROUP BY A.id
			</script>
			""")
	public Article getForPrintArticle(@Param("id") int id);

	public void deleteArticle(@Param("id") int id);

	public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);

	@Select("""
			<script>
			SELECT A.*,
			M.nickname AS extra__writerName
			FROM article AS A
			LEFT JOIN member AS M
			ON A.memberId = M.id
			WHERE 1
			<if test="boardId != 0">
				AND A.boardId = #{boardId}
			</if>
			<if test="searchKeyword != ''">
				<choose>
					<when test="searchKeywordTypeCode == 'title'">
						AND A.title LIKE CONCAT ('%',#{searchKeyword},'%')
					</when>
					<when test="searchKeywordTypeCode == 'body'">
						AND A.body LIKE CONCAT('%',#{searchKeyword},'%')
					</when>
					<otherwise>
						AND (
								A.title LIKE CONCAT('%',#{searchKeyword},'%'}
								OR
								A.body LIKE CONCAT('%',#{searchKeyword},'%'}
							)
					</otherwise>
					</choose>
			</if>
			ORDER BY A.id DESC
			<if test="limitTake != -1">
				LIMIT #{limitStart}, #{limitTake}
			</if>
			</script>
			""")

	public List<Article> getForPrintArticles(int boardId, String searchKeyword, String searchKeywordTypeCode,
			int limitStart, int limitTake);

	public int getLastInsertId();

	@Select("""
			<script>
			SELECT COUNT(*) AS cnt
			FROM article AS A
			WHERE 1
			<if test="boardId != 0">
				AND A.boardId = #{boardId}
			</if>
			<if test="searchKeyword != ''">
				<choose>
					<when test="searchKeywordTypeCode == 'title'">
						AND A.title LIKE CONCAT('%', #{searchKeyword}, '%')
					</when>
					<when test="searchKeywordTypeCode == 'body'">
						AND A.body LIKE CONCAT('%', #{searchKeyword}, '%')
					</when>
					<otherwise>
						AND (
							A.title LIKE CONCAT('%', #{searchKeyword}, '%')
							OR
							A.body LIKE CONCAT('%', #{searchKeyword}, '%')
						)
					</otherwise>
				</choose>
			</if>
			</script>
			""")

	public int getArticlesCount(int boardId, String searchKeywordTypeCode, String searchKeyword);

	@Update("""
			<script>
			UPDATE article
			SET hitCount = hitCount + 1
			WHERE id = #{id}
			</script>
			""")
	public int increaseHitCount(int id);

	@Select("""
				<script>
				SELECT hitCount
				FROM article
				WHERE id = #{id}
				</script>
			""")
	public int getArticleHitCount(int id);

	@Select("""
			<script>
			SELECT IFNULL(SUM(RP.point),0) AS s
			FROM reactionPoint AS RP
			AND id = #{id}
			AND RP.memberId = #{memberId}
			</script>
			""")
	public int actorCanMakeReactionPoint(int id, int memberid);
}