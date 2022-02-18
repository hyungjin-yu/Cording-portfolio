<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. get 또는 post 방식으로 전달된 데이터 받기
	//String name = request.getParameter("name");
	//String id = request.getParameter("id");
	
/*	// 2. 쿠키로 전달된 데이터 받기
	String name = null;
	String id = null;
	
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null) {
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("memName")) {
				name = URLDecoder.decode(cookies[i].getValue(), "utf-8");
			} else if(cookies[i].getName().equals("memID")) {
				id = cookies[i].getValue();
			} 
		}
	}
*/
	// 3. 세션에 저장된 데이터 받기
	String name = (String)session.getAttribute("memName");
	String id = (String)session.getAttribute("memID");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="../image/tumi.png" width="30" height="30" onclick="location.href='../main/index.jsp'" style="cursor:pointer;">
	<%=id + "(" + name + ")" %>님이 로그인
	<br>
	<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
</body>
</html>