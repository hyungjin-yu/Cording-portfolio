<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터 처리
	String realFolder = request.getServletContext().getRealPath("./storage");
	// 파일 저장
	MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "UTF-8");
	// 데이터 읽기
	String imageId = multi.getParameter("imageId");
	String imageName = multi.getParameter("imageName");
	int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
	int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
	String imageContent = multi.getParameter("imageContent");
	String image1 = multi.getOriginalFileName("image1");
	
	// db 
	ImageboardDTO dto = new ImageboardDTO();
	dto.setImageId(imageId);
	dto.setImageName(imageName);
	dto.setImagePrice(imagePrice);
	dto.setImageQty(imageQty);
	dto.setImageContent(imageContent);
	dto.setImage1(image1);
	
	ImageboardDAO dao = new ImageboardDAO();
	int result = dao.imageboardWrite(dto);
	
	// view 처리 파일로 이동 : forward 방식
	// 1. 데이터 공유
	request.setAttribute("imageId", imageId);
	request.setAttribute("imageName", imageName);
	request.setAttribute("imagePrice", imagePrice);
	request.setAttribute("imageQty", imageQty);
	request.setAttribute("imageContent", imageContent);
	request.setAttribute("image1", image1);

	// 2. 화면 이동
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardModifyResult");
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