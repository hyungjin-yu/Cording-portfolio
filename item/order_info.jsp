<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<link rel="stylesheet" href="../css/order_info.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#item_pay_btn").on("click", function(){
			// 결제 수단 값
			var card = $("input[name='card']:checked").val();
			
			// 입력검사
			if(!card) {
				alert("결제수단을 선택해주세요.");
			} else {
				var hidden = $("input[type='hidden']").val();				
				if(hidden == 'cart') {	// 장바구니
					//alert("장바구니");
					location.href="../item/cartOrderInsert.do?ord_payment=" + card;
				}		
				if(hidden == 'buynow') {
					//alert("바로구매");
					var item_code = $("#item_code_val").text();
					location.href="../item/order_check.do?item_code=" + item_code + "&item_qty=${item_qty}&ord_payment=" + card;
				}
			}
		});		
	});
</script>
</head>

<body id="order_info_body">
	<div style="text-align: center;"><h1>Order Check</h1></div>
	<div class="order">

		<div id="order_buynow">	
		<c:forEach var="dto" items="${list_now }">
			<div class="order_buynow_aside">
				<div class="order_buynow_img">
					<img src="../storage/${dto.item_image1 }" width="300" height="300">
				</div>
				<div class="order_buynow_item_info">
					<table style="width:350px; height: 300px; margin: 20px auto; flaot: left;">
						<tr>
							<td>상품번호</td>
							<td class="item_info"><span id="item_code_val">${dto.item_code}</span></td>
						</tr>
						<tr>
							<td>제품명</td>
							<td class="item_info">${dto.item_name}</td>
						</tr>
						<tr>
							<td>수량</td>
							<td class="item_info">${item_qty }개</td>
						</tr>
						<tr>
							<td>상품 금액</td>
							<td class="item_info">${dto.item_price}원</td>
						</tr>
						<tr>
							<td>배송비</td>
							<td class="item_info">3000원</td>
						</tr>
						<tr>
							<td>총 결제 금액</td>
							<td class="item_info">${item_qty*dto.item_price}원</td>
						</tr>
					</table>
				</div>
			</div>
			<input type="hidden" value="buynow" name="hidden_value">
			</c:forEach>
		</div>

		<!-- 장바구니 구매 -->
		<div class="order">
			<div id="order_buynow">
			<c:forEach var="dto" items="${list}">
				<div class="order_cart_aside">		
					<div class="order_buynow_img">
						<img src="../storage/${dto.item_image }" width="300" height="300">
					</div>
					<div class="order_buynow_item_info">
						<table style="width:350px; height: 300px; margin: 20px auto; flaot: left;">
							<tr>
								<td>제품명</td>
								<td class="item_info">${dto.item_name}</td>
							</tr>
							<tr>
								<td>수량</td>
								<td class="item_info">${dto.cart_qty }개</td>
							</tr>
							<tr>
								<td>상품 금액</td>
								<td class="item_info">${dto.item_price}원</td>
							</tr>
							<tr>
								<td>배송비</td>
								<td class="item_info">3000원</td>
							</tr>
							<tr>
								<td>총 결제 금액</td>
								<td class="item_info">${dto.cart_totalprice}원</td>
							</tr>
						</table>			
					</div>			
				</div>
				<input type="hidden" value="cart" name="hidden_value">
			</c:forEach>
			</div>
		</div>
		<!-- 회원 정보 가져오기 -->
		<div class="order_buynow_main">
			<table style="width:280px; height: 380px; margin: auto;">
				<tr>
					<td class="user_label">구매자 이름</td>
				</tr>
				<tr>
					<td class="user_info">${user_dto.user_name}</td>
				</tr>
				<tr>
					<td class="user_label">전화번호</td>
				</tr>
				<tr>
					<td class="user_info">${user_dto.user_phone}</td>
				</tr>
				<tr>
					<td class="user_label">배송지</td>
				</tr>
				<tr>
					<td class="user_info" style="font-size: 14px;">${user_dto.user_addr1}</td>
				</tr>
				<tr>
					<td class="user_info" style="font-size: 14px;">${user_dto.user_addr2}</td>
				</tr>
				<tr>
					<td class="user_label">결제 수단 선택</td>
				</tr>
				<tr>
					<td class="user_info">
						<input type="radio" value="toss" name="card">toss
						<input type="radio" value="kakao" name="card">kakao
						<input type="radio" value="payco" name="card">payco
					</td>
				</tr>
				<tr style="background: #262222; cursor: pointer;">
					<th id="item_pay_btn" style="color: white;">결제</th>
				</tr>
			</table>
		</div>		
	</div>
</body>
</html>