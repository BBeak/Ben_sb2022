<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시물 수정" />
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
	<div class="container mx-auto px-3">
		<div class="table-box-type-1">
			<form class="table-box-type-1" method="POST" action="../article/doModify">
				<input type="hidden" name="id" value="${article.id}" />
				<table>
					<colgroup>
						<col width="200" />
					</colgroup>
					<tbody>
						<tr>
							<th>번호</th>
							<td>
								<div class="badge badge-primary">${article.id}</div>
							</td>
						</tr>
						<tr>
							<th>작성날짜</th>
							<td>${article.forPrintType1RegDate}</td>
						</tr>
						<tr>
							<th>수정날짜</th>
							<td>${article.forPrintType1UpdateDate}</td>
						</tr>
						<tr>
							<th>조회</th>
							<td><span class="text-blue-700">${article.hitCount}</span></td>
						</tr>
						<tr>
							<th>추천수</th>
							<td>
								<span class="text-blue-700">${article.goodReactionPoint}</span>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${article.extra__writerName}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td><textarea class="w-full text-black" name="body" rows="1">${article.body}</textarea></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea class="w-full text-black" name="body" rows="10">${article.body}</textarea></td>
						</tr>
						<tr>
							<th>수정</th>
							<td><input type="submit" class="btn btn-primary" value="수정" />
								<button type="button" class="btn btn-outline btn-success" onclick="history.back();">뒤로가기</button></td>
						</tr>
					</tbody>
				</table>
		</div>
		<div class="button">
			<button type="button" onclick="history.back();">뒤로가기</button>
			<a class="btn-text-link" href="../article/Modify?id=${article.id}">게시물 수정</a>
			<c:if test="${article.extra__actorCanDelete}">
				<a class="btn-text-link" onclick="if (confirm('정말 삭제하시겠습니까?') == false) return false;" href="../article/delete/delete?id=${article.id}"> 게시물 삭제</a>
			</c:if>
		</div>

	</div>
</section>

<%@ include file="../common/foot.jspf"%>