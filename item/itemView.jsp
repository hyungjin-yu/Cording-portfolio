<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<link rel="stylesheet" href="../css/itemView.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		// 로그인 여부 확인
		if(${login_id == null}) {
			$(".button_buy").click(function(){
				alert("로그인 후 이용가능합니다.");
				return false;
			});
		};
		
		if(${login_id != null}) {
			// 바로구매
			$(".button_buy").eq(0).click(function(){
				//alert("바로구매");
				var item_qty = $(".number").val();
				location.href='../item/order_info_buynow.do?item_code=${dto.item_code}&item_qty=' + item_qty;
			});
			
			// 장바구니
			$(".button_buy").eq(1).click(function(){
				//alert("장바구니");
				var item_qty = $(".number").val();
				location.href='../item/cartWrite.do?item_code=${dto.item_code}&item_qty=' + item_qty;
			});		
		}
	});
</script>
</head>
<body id="itemView_body">
	<!-- 제품 상세 정보 -->
		<div id="itemView_aside">
			<div class="container2">
				<a href="#" class="filtering"><strong>사이즈</strong></a>
				<div class="bar">
					<ul>
						<li><a href="#" id="250">250</a>
						<li><a href="#" id="255">255</a>
						<li><a href="#" id="260">260</a>
						<li><a href="#" id="265">265</a>
					</ul>
				</div>
				<br>
				<br> <a href="#" class="filtering"><strong>색상</strong></a>
				<div class="bar">
					<ul>
						<li><a href="#" id="white">White</a>
						<li><a href="#" id="basic">Basic</a>
						<li><a href="#" id="blue">Blue</a>
						<li><a href="#" id="green">Green</a>
					</ul>
				</div>
			</div>
			<div class="Quantity">
				<div style="text-align: center; margin-bottom: 5px">수량</div>
				<input type="number" value="1" min="0" max="10" class="number">
			</div>
			<hr>
			<!-- jQuery -->
			<button type="button" class="button_buy">바로구매</button>
			<button type="button" class="button_buy">장바구니</button>	

		</div>
	<!-- 제품 사진 -->
	<main id="itemView_main">
		<div class="container3">
			<img alt="${dto.item_name}" src="../storage/${dto.item_image1}" class="itemView_img">
			<img alt="${dto.item_name}" src="../storage/${dto.item_image2}" class="itemView_img">
		</div>
		<hr style="border-top: 5px double #949494;">
		<div class="container3_itemInfo">
			<p style="font-size: 24px; text-align: center;">-제품 사양-</p><br>
			<div style="font-size: 20px; margin-bottom: 10px;">${dto.item_name}</div>
			<div style="font-size: 18px; text-align: right; margin-bottom: 10px;">사이즈: ${dto.item_size }</div>
			<div style="font-size: 18px; text-align: right; margin-bottom: 20px;">색상: ${dto.item_color }</div>
			<div>${dto.item_details}</div>
		</div>
		<hr style="border-top: 5px double #949494;">
		<!-- 리뷰 게시판 -->
		<p style="font-size: 26px; text-align: center;">-Review-</p>
		<div class="container4">
			<jsp:include page="reviewList.do?item_code=${dto.item_code }"></jsp:include>
		</div>
	</main>
</body>
</html>