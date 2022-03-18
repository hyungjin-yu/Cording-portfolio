<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO dao = new MemberDAO();
	String name = dao.login(id, pwd);
	
	if(name != null) {
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		
		response.sendRedirect("../board/boardList.jsp");
	} else {
		response.sendRedirect("LoginForm.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>