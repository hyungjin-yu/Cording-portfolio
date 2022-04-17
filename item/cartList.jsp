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
		<!-- 상품 목록 : 70% -->
		<div id="cartList_item">
			<!-- c:forEach로 테이블 추가생성 -->
			<div id="cartList_item_img">	<!-- 상품이미지 -->
				<img alt="" src="../img/kirby_spring.jpg" width="170" height="170">
			</div>
			<table id="cartList_item_table">		
				<tr>
					<td width="230" style="font-weight: bold; font-size: 18px;">커비</td>	<!-- 상품명 -->
					<td>
						<a href="#" id="cartList_option_modify">옵션 변경</a>	 <!-- 수정 -->
					</td>	
					<td>10,000원</td>	<!-- 총합계 -->
					<td width="50">		<!-- 삭제 버튼 -->
						<a href="#">
							<img alt="" src="../img/cancel.png" width="17" height="17">
						</a>
					</td>	
				</tr>
				<tr>
					<td>상품번호: 1234<br>사이즈&nbsp;&nbsp;&nbsp;: L</td>	<!-- 상품 번호 & 상품 사이즈 -->
				</tr>
				<tr>
					<td>수량: 1개</td>	<!-- 상품 수량 -->
				</tr>
			</table>
		</div>
		
		<!-- 주문하기 : 30% -->
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
					<td colspan="2" height="50" id="order_cost_btn">주문하기</td>	<!-- jquery click -->
				</tr>
			</table>
			<p style="font-size: 14px;">* 장기간 장바구니에 보관하신 상품은 시간이 지남에 따라 가격과 혜택이 변동될 수 있으며,
			최대 30일동안 보관됩니다.</p>
		</div>
	</div>
	<!-- 추천상품 -->
	<div id="cartList_recommend">	
		<div id="cartList_recommend_inner">		
			<p class="cartList_recommend_title">추천상품</p><br>
			<!-- 리스트 : 같은 카테고리의 상품들 select로 불러오기 : 5개 -->
			<!-- c:forEach로 div 생성 -->

			<div class="cartList_recommend_item">
				<a href="#"><img alt="" src="../img/나이키머큐리얼에어줌베이퍼14프로TF_footballgrey_1.jpg" width="200" height="200"></a>
				<p>나이키 머큐리얼 에어<br>줌 베이퍼 14 프로 TF</p>	<!-- 상품명 -->
			</div>
			<div class="cartList_recommend_item">	
				<a href="#"><img alt="2" src="../img/w_shoes_011_a.png" width="200" height="200"></a>
				<p>나이키 와플 데뷰</p>
			</div>			
			<div class="cartList_recommend_item">
				<a href="#"><img alt="3" src="../img/조던시리즈ES_sail_1.jpg" width="200" height="200"></a>
				<p>조던 시리즈 ES</p>
			</div>	
			<div class="cartList_recommend_item">	
				<a href="#"><img alt="2" src="../img/w_shoes_011_a.png" width="200" height="200"></a>
				<p>나이키 와플 데뷰</p>
			</div>			
			<div class="cartList_recommend_item">
				<a href="#"><img alt="3" src="../img/조던시리즈ES_sail_1.jpg" width="200" height="200"></a>
				<p>조던 시리즈 ES</p>
			</div>	
						
		</div>
	</div>
</body>
</html>