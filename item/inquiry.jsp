<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판</title>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<style type="text/css">
	
</style>
</head>
<body>
	<div>
		<table>
			<tr>
				<td>No.</td>	<!-- 글번호 -->
				<td>제목</td>		<!-- 글제목 -->
				<td>작성자</td>		<!-- 작성자 -->
				<td>작성일</td>		<!-- 작성일 -->
				<td>조회수</td>		<!-- 조회수 -->
			</tr>
			<!-- c:forEach -->
			<!-- 답글기능 추가 -->
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>