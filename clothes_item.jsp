<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/itemList.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
</head>
<body>
	<main>
		<div class="container3">
			<div id="item">
				<c:forEach var="dto" items="${list}">
					<img alt="${dto.item_name}" src="${dto.item_image1}">
					<label>${item_name}</label>
					<label>${item_details}</label>
				</c:forEach>
			</div>
		</div>
	</main>
</body>
</html>