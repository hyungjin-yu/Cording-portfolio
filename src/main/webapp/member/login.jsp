<%@page import="java.net.URLEncoder"%>
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
	
	// 페이지 이동
	if(name != null) {		// 로그인 성공
		// 1. 자바 영역에서 get 방식으로 전송할 때, 인코딩을 설정해서 name을 전달해야함
		//response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name, "utf-8") + "&id=" + id);
		
/*		// 2. 쿠키를 이용한 페이지 이동
		Cookie cookie = new Cookie("memName", URLEncoder.encode(name, "utf-8"));
		cookie.setMaxAge(120);
		response.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("memID", id);
		cookie2.setMaxAge(120);
		response.addCookie(cookie2);
*/
		// 3. 세션을 이용한 페이지 이동
		session.setAttribute("memName", name);
		session.setAttribute("memID", id);
		
		response.sendRedirect("loginOk.jsp");
	} else {				// 로그인 실패
		response.sendRedirect("loginFail.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	<% if(name == null) {%>
		<p>로그인에 실패했습니다.</p>
	<% } else { %>
		<p><%=name %>님이 로그인 성공</p>	
	<% } %>
--%>
</body>
</html>