<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/itemList.css">
</head>
<body>
	<main>
		<div class="container3">
			<c:forEach var="dto" items="${list}">
				<div class="item_info">
					<table>
						<tr>
							<td><a href="order_info.do"><img src="${dto.item_image1}" id="item_image1"></a></td>
						</tr>
						<tr>
							<td><label id="item_name">상품명 : ${dto.item_name}</label></td>
						</tr>
						<tr>
							<td><label id="item_details" style="color: ${dto.item_color}">상품 설명 : ${dto.item_details}</label></td>
						</tr>
						<tr>
							<td><label id="item_size">사이즈 : ${dto.item_size}</label></td>
						</tr>
						<tr>
							<td>색상 : <label id="item_color" style="color: ${dto.item_color}"><strong>${dto.item_color}</strong></label></td>
						</tr>
					</table>
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>