<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
			/* 수정 이벤트 : 옵션 변경 */
			$(".qty_minus").on("click", function(){
				// 수정한 수량, 장바구니 시퀀스 정보 가져오기
				var qty = $(this).parent().find(".cart_qty").text();
				var seq = $(this).parent().find(".cart_seq").val();
				
				if(qty > 1) {
					var qty_minus = qty - 1;
					//alert("cart_qty=" + qty_minus + "&cart_seq=" + seq);
					location.href="cartModify.do?cart_qty=" + qty_minus + "&cart_seq=" + seq;
				} else {
					alert("최소 수량은 1개입니다.");
				}
			});
		
			$(".qty_plus").on("click", function(){
				var qty = $(this).parent().find(".cart_qty").text();
				var seq = $(this).parent().find(".cart_seq").val();
				
				var qty_plus = Number(qty) + 1;
				location.href="cartModify.do?cart_qty=" + qty_plus + "&cart_seq=" + seq;
			});
			
			/* 삭제 이벤트 */
			$(".cartList_delete").click(function(){
				var seq = $(this).parent().find(".cart_seq").val();
				
				var result = confirm("선택하신 상품을 삭제하시겠습니까?");
				if(result) {
					location.href="../item/cartListDelete.do?cart_seq=" + seq;
				} 
			});
			
			$("#order_cost_btn").click(function() {
				location.href="../item/cartOrder.do";
			});	
	});	
	
	
</script>
<link rel="stylesheet" href="../css/cartList.css">
<body>
	<div id="cartList_title">
		<p style="font-size: 24px; font-weight: bold;">장바구니</p>
		<p>${totalA }개 상품</p>
	</div>
	<hr>
	<div id="cartList_list">
		<!-- 상품 목록 : 70% -->
		<div id="cartList_item">
			<!-- 목록 : 3개, 블럭 3개 -->
		<!-- c:forEach로 테이블 추가생성 -->
		<c:forEach var="dto" items="${list }">
			<table id="cartList_item_table">		
				<tr>
					<!-- 상품이미지 -->
					<td rowspan="3" width="170">
						<img id="cartList_item_img" src="../storage/${dto.item_image }" width="150" height="150">
					</td>
					<td width="230" style="font-weight: bold; font-size: 18px;">
						${dto.item_name }							<!-- 상품명 -->
					</td>	
					<td class="cartList_option_modify" width="">	 <!-- 수량 증가감소기능 -->
						<img class="qty_minus" src="../img/minus.png" 
							width="14" height="14" style="cursor:pointer;">
							수량: <span class="cart_qty">${dto.cart_qty }</span>개
						<img class="qty_plus" src="../img/plus.png" 
							width="14" height="14" style="cursor:pointer;">
						<input type="hidden" class="cart_seq" value="${dto.cart_seq }">
					</td>	
					<td>${dto.cart_totalprice }원</td>				<!-- 총합계 -->
					<td width="50">									<!-- 삭제 버튼 -->
						<img class="cartList_delete" src="../img/cancel.png" 
							width="17" height="17" style="cursor:pointer;">
						<input type="hidden" class="cart_seq" value="${dto.cart_seq }">
					</td>	
				</tr>
				<tr>
					<td>상품번호: ${dto.item_code }<br></td>		<!-- 상품 번호 & 상품 사이즈 -->
				</tr>
				<tr>
					<td>사이즈&nbsp;&nbsp;&nbsp;: L</td>			<!-- 상품 수량 -->
				</tr>
			</table>
		</c:forEach>
			
		</div>
		
		<!-- 주문하기 : 30% -->
		<div id="cartList_order">
			<table id="order_cost">
				<tr>
					<td colspan="2" height="50" id="order_cost_title">주문예정금액</td>
				</tr>
				<tr>
					<td>상품 금액</td>
					<td class="cart_item_info">${totalPrice }원</td>
				</tr>
				<tr>
					<td>예상 배송비</td>
					<td class="cart_item_info">3000원</td>
				</tr>
				<tr>
					<td>상품 할인 금액</td>
					<td class="cart_item_info">0원</td>
				</tr>
				<tr>
					<td>주문 할인 금액</td>
					<td class="cart_item_info">0원</td>
				</tr>
				<tr>
					<td colspan="2" height="50" id="order_cost_btn" style="cursor:pointer;">
						주문하기
					</td>
				</tr>
			</table>
			<p style="font-size: 14px;">* 장기간 장바구니에 보관하신 상품은 시간이 지남에 따라 가격과 혜택이 변동될 수 있습니다.</p>
		</div>

		<!-- 페이징 처리 -->
			<div id="cartList_page">
				<c:if test="${startPage > 3 }">
					<a class="paging" href="cartList.do?pg=${startPage-1 }">이전</a>
				</c:if>
				
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<c:if test="${pg == i }">
						<a class="currentPaging" href="cartList.do?pg=${i }">${i }</a>
					</c:if>
					<c:if test="${pg != i }">
						<a class="paging" href="cartList.do?pg=${i }">${i }</a>
					</c:if>
				</c:forEach>
				
				<c:if test="${endPage < totalP }">
					<a class="paging" href="cartList.do?pg=${endPage + 1 }">다음</a>
				</c:if>
			</div>
	</div>
	<!-- 추천상품 -->
	<div id="cartList_recommend">	
		<div id="cartList_recommend_inner">		
			<!-- 수동으로 best상품들을 나열... -->
			<p class="cartList_recommend_title">추천상품</p><br>
			<div class="cartList_recommend_item">
				<a href="#">
				<img alt="" src="../storage/나이키스포츠웨어스우시_남성풀집리버서블재킷AS_hotcurry_4.jpg" width="200" height="200"></a>
				<p>나이키 머큐리얼 에어<br>줌 베이퍼 14 프로 TF</p>	<!-- 상품명 -->
			</div>
			<div class="cartList_recommend_item">	
				<a href="#">
				<img alt="2" src="../storage/w_shoes_011_a.png" width="200" height="200"></a>
				<p>나이키 와플 데뷰</p>
			</div>			
			<div class="cartList_recommend_item">
				<a href="#">
				<img alt="3" src="../storage/줌프릭3_greyfog_1.jpg" width="200" height="200"></a>
				<p>조던 시리즈 ES</p>
			</div>	
			<div class="cartList_recommend_item">	
				<a href="#">
				<img alt="2" src="../storage/w_cloth_013_a.png" width="200" height="200"></a>
				<p>나이키 와플 데뷰</p>
			</div>			
			<div class="cartList_recommend_item">
				<a href="#">
				<img alt="3" src="../storage/Running_2_스타러너3_핑크_1.PNG" width="200" height="200"></a>
				<p>조던 시리즈 ES</p>
			</div>	
						
		</div>
	</div>
</body>
</html>