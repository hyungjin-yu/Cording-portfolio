<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/order_check.css">
</head>
<body>
<div id="container">
	<form>
		<fieldset>
			<legend>개인정보</legend>
			<ul>
				<li>
					<label for="user_name" class="title">이름</label>
					<input type="text" id="user_name" placeholder="${user_id}">
				</li>
				
				<li>
					<label for="tel" class="title">연락처</label>
					<input type="text" id="tel" placeholder="${user_phone}">
				</li>
			</ul>
		</fieldset>
		<fieldset>
			<legend>배송지 정보</legend>
			<ul>
				<li>
					<label for="addr" class="title">주소</label>
					<input type="text" id="post" placeholder="${user_post}">
					<input type="text" id="addr1" placeholder="${user_addr1}">
					<input type="text" id="addr2" placeholder="${user_addr2}">
				</li>
			</ul>
		</fieldset>
		<fieldset>
			<legend>주문 정보</legend>
			<ul>
				<li>
					<label for="product" class="title">제품 이름</label>
					<input type="text" id="product" placeholder="${item_name}">
				</li>
			</ul>
		</fieldset>
	</form>
	<div class="centered">
			<input type="button" value="결제 완료">
			<button type="button" onclick="location.href='../main/index.jsp'" value="메인화면">메인화면</button>
	</div>
</div>
</body>
</html>