<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String realFolder = request.getServletContext().getRealPath("./storage");
	
	// 파일 저장(post방식이기 때문에 멀티씀)
	MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "UTF-8");
	
	// 데이터 읽기
	int pg = Integer.parseInt(multi.getParameter("pg"));
	int seq = Integer.parseInt(multi.getParameter("seq"));
	String imageId = multi.getParameter("imageId").replace(" ","");
	String imageName = multi.getParameter("imageName").replace(" ","");
	int imagePrice = Integer.parseInt(multi.getParameter("imagePrice").replace(" ",""));
	int imageQty = Integer.parseInt(multi.getParameter("imageQty").replace(" ",""));
	String imageContent = multi.getParameter("imageContent");
	String image1 = multi.getOriginalFileName("image1");	// 얘만 OriginalFileName
	
	ImageboardDTO dto = new ImageboardDTO();
	dto.setSeq(seq);
	dto.setImageId(imageId);
	dto.setImageName(imageName);
	dto.setImagePrice(imagePrice);
	dto.setImageQty(imageQty);
	dto.setImageContent(imageContent);
	dto.setImage1(image1);
	
	ImageboardDAO dao = new ImageboardDAO();
	int result = dao.checkModify(dto);
	
	request.setAttribute("result", result);
	
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