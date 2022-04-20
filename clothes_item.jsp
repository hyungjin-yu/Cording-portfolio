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
					<div class="item_info">
						<a href="order_info.jsp"><img src="${dto.item_image1}" id="item_image1"></a>
						<label id="item_name">${dto.item_name}</label>
						<label id="item_details">${dto.item_details}</label>
						<label id="item_size">${dto.item_size}</label>
						<label id="item_color">${dto.item_color}</label>
					</div>
				</c:forEach>
			</div>
		</div>
	</main>
</body>
</html>