package com.bkh.exam.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReactionPointRepository {

	@Select("""
			<script>
			SELECT IFNULL(SUM(RP.point),0) AS s
			FROM reactionPoint AS RP
			AND id = #{id}
			AND RP.memberId = #{memberId}
			</script>
			""")
	public int actorCanMakeReactionPoint(int id, String relTypeCode, int memberid);
}
