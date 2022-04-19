<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/order_info.css">
</head>
<body>
	<div class="order">
	<aside>
		<label>제품명<input type="text" value="" ></label><br><br>
		<label>상품 금액<input type="text" value="" ></label><br><br>
		<label>배송비<input type="text" value="" ></label><br><br>
		<label>총 결제 금액<input type="text" value="" ></label><br><br>
	</aside>
	
	<main>
		<label>구매자 이름<br><input type="text" value="" ></label><br><br>
		<label>전화번호<br><input type="text" value="" ></label><br><br>
		<label>배송지<br><input type="text" value="" ></label><br><br>
		<label>결제 수단 선택<br><input type="radio" value="toss" name="card">toss
						 <input type="radio" value="kakao" name="card">kakao
						 <input type="radio" value="payco" name="card">payco</label>
	</main>
	
	<button type="button" value="결제" id="pay" onclick="location.href='order_check.jsp'">결제</button>
	</div>
</body>
</html>