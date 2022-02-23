<%@page import="java.util.List"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));	
	// 1) 목록 출력
	int endNum = pg*5;
	int startNum = endNum - 4;
	// db
	ImageboardDAO dao = new ImageboardDAO();
	// 표시할 리스트 객체
	 List<ImageboardDTO> list = dao.imageboardList(startNum, endNum);
	
	// 2) 페이징 처리
	int totalA = dao.getTotalA();	// 총 글 수 
    int totalP = (totalA + 4) / 5;	// 총 페이지 수
    
    int startPage = (pg-1)/3*3 + 1;
	int endPage = startPage + 2;	// 페이지 번호를 5개씩 한다면 +4
	// endPage 값 보정
	if(endPage > totalP) endPage = totalP;

	// view 처리 파일로 이동 : forward 방식
	// 1. 데이터 공유
	request.setAttribute("list", list);
	request.setAttribute("pg", pg);
	request.setAttribute("totalP", totalP);
	request.setAttribute("startPage", startPage);
	request.setAttribute("endPage", endPage);
	// 2. 화면 이동
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardListResult");
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