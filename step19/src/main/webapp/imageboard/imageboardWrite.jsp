<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	파일 이름 : ${dto.image1}<br>
	상품명 : ${dto.imageName}<br>
	<img src="../storage/${dto.image1}">
</body>
</html>