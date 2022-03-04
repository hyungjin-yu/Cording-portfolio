<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 900px;
	height: 500px;
	background-color: orange;
}
.currentPaging {color: red; text-decoration: underline;}
.paging {color: blue; text-decoration: none;}
</style>
</head>
<body>
	<table>
		<tr>
		 <tr bgcolor="#ffff00">
         <th width="20">번호</th> 
         <th width="50">제목</th>
         <th width="30">작성자</th>
         <th width="100">날짜</th>
         <th width="10">조회수</th>
		</tr>
			<c:forEach var="bean" items="${list}">
			<tr bgcolor="#ffffdd" align="center">
				<td>${bean.board_num}</td>
				<td align="left"><a href="boardDetail.do?board_num=${bean.board_num}&pg=${pg}">${bean.board_subject}</a></td>
				<td>${bean.board_name}</td>
				<td>${bean.board_date}</td>
				<td>${bean.board_readcount}</td>
			</tr>
			</c:forEach>
	</table>
	<div style="text-align:center;">
		<c:if test="${startPage > 5 }">
			[<a class="paging" href="boardList.do?pg=${startPage - 1}">이전</a>]
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:if test="${pg == i}">
				[<a class="currentPaging" href="boardList.do?pg="${i}">${i}</a>]
			</c:if>
			
			<c:if test="${pg != i}">
				[<a class="paging" href="boardList.do?pg=${i}">${i}</a>]
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage < totalP}">
			[<a class="paging" href="boardList.do?pg=${endPage + 1}">다음</a>]
		</c:if>
	</div>
	<a href="index.jsp">메인화면</a> &nbsp;
	<a href="boardWriteForm.do">글 쓰기</a>
</body>
</html>