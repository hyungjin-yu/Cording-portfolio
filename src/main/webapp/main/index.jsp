<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>*** 메인 화면 ***</h3>
	<br>
	<a href="../board/boardList.jsp?pg=1">목록</a><br>
<% if(session.getAttribute("memID") == null) { %>
	<!-- 로그인 전 화면 -->
	<a href="../member/LoginForm.jsp">로그인</a><br>
	<a href="../member/writeForm.jsp">회원가입</a><br>
<% } else {%>
	<!-- 로그인 후 화면 -->
	<a href="../board/boardWriteForm.jsp">글쓰기</a><br>
	<a href="../member/logout.jsp">로그아웃</a><br>
	<a href="">회원 정보 수정</a><br>
<% } %>
</body>
</html>