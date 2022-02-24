<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	// DB 작업
	ImageboardDAO dao = new ImageboardDAO();
	int result = dao.imageDelete(seq);
	
	// view 처리 파일로 이동 : forward 방식
	// 1. 데이터 공유
	request.setAttribute("result", result);
	request.setAttribute("seq", seq);
	request.setAttribute("pg", pg);

	// 2. 화면 이동
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardDeleteResult");
	dispatcher.forward(request, response);
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