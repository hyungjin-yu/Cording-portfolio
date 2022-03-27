<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, th, td {
	border: 1px solid;
	border-collapse: collapse;
	padding: 3px;
}

th {
	background: lightgray;
}

.paging {color: blue; text-decoration: none;}
.currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>
	<div style="height:170px;">
		<table align="center" width="650">
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>성별</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>가입일</th>
			</tr>

			<c:forEach var="dto" items="list">
				<tr align="center">
				<td>${dto.name}</td>
				<td>${dto.id}</td>
				<td>${dto.gender}</td>
				<td>${dto.email1}@${dto.email2}</td>
				<td>${dto.tel1}-${dto.tel2}-${dto.tel3}</td>
				<td>${dto.logtime}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<br>
		
	<div style="text-align: center;">
	
		<c:if test="${startPage > 3}">
			[<a class="paging" href="memberList.do?pg=${startPage - 1}">이전</a>]
		</c:if> 
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:if test="${pg==i}">
				[<a class="currentPaging" href="memberList.do?pg=${i}">${i}</a>]
			</c:if>
			<c:if test="${pg!=i}">
				[<a class="paging" href="memberList.do?pg=${i}">${i}</a>]
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage < totalP}">
			[<a class="paging" href="memberList.do?pg=${endPage + 1}">다음</a>]
		</c:if>
	</div> 
	
	<a href="../main/index.do">메인</a>
</body>
</html>