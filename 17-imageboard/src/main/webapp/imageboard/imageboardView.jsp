<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));	
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	ImageboardDAO dao = new ImageboardDAO();
	ImageboardDTO dto = dao.ImageView(seq);
	// 데이터 공유
	request.setAttribute("pg", pg);
	request.setAttribute("dto", dto);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardViewResult");
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