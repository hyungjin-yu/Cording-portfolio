<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../css/cartList.css">
<body>
	<div id="cartList_title">
		<p style="font-size: 24px; font-weight: bold;">장바구니</p>
		<p>$개 상품</p>
	</div>
	<hr>
	<div id="cartList_list">
		<!-- 상품 목록 : 60% -->
		<div id="cartList_item">
			<table>
				<!-- c:forEach -->
			</table>
		</div>
		
		<!-- 주문하기 : 40% -->
		<div id="cartList_order">
			<table id="order_cost">
				<tr>
					<td colspan="2" height="50" id="order_cost_title">주문예정금액</td>
				</tr>
				<tr>
					<td>상품 금액</td>
					<td></td>
				</tr>
				<tr>
					<td>예상 배송비</td>
					<td></td>
				</tr>
				<tr>
					<td>상품 할인 금액</td>
					<td></td>
				</tr>
				<tr>
					<td>주문 할인 금액</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
						<img alt="" src="">		<!-- 주문하기 버튼 -->
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 추천상품 -->
	<div id="cartList_recommend">
		
	</div>
</body>
</html>