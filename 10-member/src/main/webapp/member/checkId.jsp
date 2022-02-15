<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");

	// DB : id가 있는지 검사
	boolean exist = false;	// true면 아이디가 존재, false면 아이디 없음
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="checkId.jsp" method="post">
<% if(exist) {%>
	<%=id %>는 존재합니다.<br><br>
	아이디 <input type="text" name="id">
	<input type="submit" value="중복체크">
<% } else { %>
	<%=id %>는 사용 가능 합니다.<br><br>
	<input type="button" value="사용" onclick="">
<% } %>
</form>
</body>
</html>