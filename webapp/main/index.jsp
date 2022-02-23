<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	height: 100%;
}
#header {
	width: 90%;
	height: 10%;
	text-align: center;
	border: 1px solid black;
}
#container {
	width: 700px;
	height: 96.5%;
	border: 1px solid black;
}
#nav {
	width: 20%;
	height: 100%;
	float: left;
	background: orange;
	padding: 10px;
}
#section {
	width: 70%;
	height: 96.5%;
	float: left;
	padding: 10px;
}
#footer {
	width: 100%;
	height: 10%;
	clear: both;
	text-align: center;
	border: 1px solid black;
}
h3 > a:link {
	color: black; text-decoration: none;
}
h3 > a:visited {
	color: black; text-decoration: none;
}
h3 > a:action {
	color: black; text-decoration: none;
}
h3 > a:hover {
	color: green; text-decoration: underline;
}
</style>
</head>
<body>
<div style="width: 800px; height: 700px">
	<div id = "header">
		<h1>이미지 게시판</h1>
	</div>
	
	<div id = "container">
		<div id="nav">
			<h3><a href="../main/index.jsp">** 메인 화면 **</a></h3>
			<a href="#">회원가입</a><br>
			<a href="#">로그인</a><br>
			<a href="#">로그아웃</a><br>
			<a href="#">회원 정보 수정</a><br>
			<hr>
			<a href="#">글쓰기</a><br>
			<a href="#">글 목록</a><br>
			<hr>
			<a href="index.jsp?req=imageboardWriteForm">이미지 등록</a><br>
			<a href="../imageboard/imageboardList.jsp?pg=1">이미지 목록</a><br>
		</div>
		
		<div id="section">
			<!-- view 처리 파일 -->
			<c:if test="${param.req == null}">
				<jsp:include page="body.jsp"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'imageboardWriteForm'}">
				<jsp:include page="../imageboard/imageboardWriteForm.jsp"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'imageboardWriteResult'}">
				<jsp:include page="../imageboard/imageboardWriteResult.jsp"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'imageboardListResult'}">
				<jsp:include page="../imageboard/imageboardListResult.jsp"></jsp:include>
			</c:if>
		</div>
	</div>
	
	<div id="footer">
		<p>EZEN IT ACADEMY</p>
	</div>
</div>
</body>
</html>