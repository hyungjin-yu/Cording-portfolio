<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW Order List</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../script/OrderlistScript.js"></script>
<link rel="stylesheet" href="../css/order_list.css">
<script type="text/javascript">
	$(function(){
		$(".order_info_inner").click(function(){
			var ord_number = $(this).find(".ord_number").val();
			//alert("ord_number = " + ord_number);
			location.href="../orderlist/orderdetail.do?ord_number=" + ord_number;
		});
	});
</script>
</head>
<body id="orderlist_body">
	<form action="../orderlist/orderlist.do" method="post" name="form" id="form"
		onsubmit="check(); return false;">
		<div class="allOrderlist">
			<h1 class="heading is-1 " data-test="lblMyDetails">MY Order List</h1>

			<div id="orderlist_container" style="text-align: left;">
				<div class="rs-ol-wrapper">
					<c:forEach var="vo" items="${list }">
						<ul class="rs-ol-tile-list-as-grid" aria-labelledby="rs-ol-header">
							<li class="rs-ol-tile-as-grid-item" 
							data-trigger-click="click .rs-ol-tile-name"
							data-trigger-context="true" tabindex="-1">
								<div class="order_info_inner">
									<div class="rs-ol-tile-image">
										<img src="../storage/${vo.ord_image }" width="200" height="200">
									</div>
									<div class="rs-ol-tile-info">	
										<div class="rs-ol-item-name">
											상품명 :<br>
											 ${vo.ord_name }
										</div>						
										<div class="rs-ol-item-quantity" >
											<span class="visuallyhidden"></span>
											<span aria-hidden="true">수량: </span>${vo.ord_qty}
										</div>		
										<div class="rs-ol-tile-delivery" aria-hidden="true">
										배송됨 ${vo.ord_date}
										</div>
									</div>
									<input type="hidden" value="${vo.ord_number }" class="ord_number">
								</div>
							</li>
						</ul>	
					</c:forEach>
				</div>
			<!-- 페이징 처리 -->
				<div id="orderlist_page">
					<c:if test="${startPage > 3 }">
						<a class="paging" href="orderlist.do?pg=${startPage-1 }">이전</a>
					</c:if>
				
					<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
						<c:if test="${pg == i }">
							<a class="currentPaging" href="orderlist.do?pg=${i }">${i }</a>
						</c:if>
						<c:if test="${pg != i }">
							<a class="paging" href="orderlist.do?pg=${i }">${i }</a>
						</c:if>
					</c:forEach>
				
					<c:if test="${endPage < totalP }">
						<a class="paging" href="orderlist.do?pg=${endPage + 1 }">다음</a>
					</c:if>					
				</div>	
			</div>
		</div>
	</form>
</body>
</html>