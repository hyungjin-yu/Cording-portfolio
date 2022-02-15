<%@page import="member.bean.memberDTO"%>
<%@page import="member.dao.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	memberDAO dao = new memberDAO();
	String name = dao.login(id, pwd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(name == null) {%>
	<p>로그인에 실패했습니다.</p>
<% } else { %>
	<p><%=name %>님이 로그인 성공</p>	
<% } %>
</body>
</html>