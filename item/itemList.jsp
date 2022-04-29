<%@page import="org.springframework.web.bind.annotation.SessionAttribute"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<link rel="stylesheet" href="../css/itemList.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".filtering").click(function() {
			if ($(this).next().css("display") == "none") {
				$(this).next().slideDown(300);
			} else {
				$(this).next().slideUp();
			}
		});
		$("#filter_tool").click(function() {
			if ($(".container2").next().css("marginLeft") == "0px") {
				$(".container2").delay(10);
				$(".container2").animate({
					width : "toggle"
				}, 400);
			} else {
				$(".container2").delay(10);
				$(".container2").animate({width : "toggle"}, 0);
			}
		});
		
		// 상품 상세 페이지로 이동
		$(".item_image1").click(function(){
			var item_code = $(this).parent().find(".itemList_code").val();
			//alert("item_code= " + item_code);
			location.href= "../item/itemView.do?item_code=" + item_code;
		});
	});
</script>
</head>
<body id="itemList_body">
	<!---- HEADER ---->
	<div class="container1">
		<div class="itemList_category">
			<ul class="category_bar">
				<li><a href="#">Product</a></li>
			</ul>
		</div>
		
			<!-- 필터 버튼 -->
		<div class="itemList_filter">
			<ul class="filter_bar">
				<li><a href="#" id="filter_tool">필터</a></li>
				<div id="new_list">
					<select id="rank_list">
						<option value="신상품순">신상품순</option>
						<option value="높은 가격순">높은 가격순</option>
						<option value="낮은 가격순">낮은 가격순</option>
						<option value="추천순">추천순</option>
					</select>
				</div>
			</ul>
		</div>
	</div>
	<!-- 상품 정렬 필터링 -->
	<!-- 필터리스트 -->
	<aside id="itemList_aside">
		<div class="container2">
		<br>
			<a href="#" class="filtering">사이즈</a>
			<div class="button-group" data-filter-group="size">
				<ul>
					<li><button class="button is-checked" data-filter="">전체보기</button>
					<li><button class="button" data-filter=".260">260</button>
					<li><button class="button" data-filter=".265">265</button>
					<li><button class="button" data-filter=".270">270</button>
					<li><button class="button" data-filter=".275">275</button>
					<li><button class="button" data-filter=".280">280</button>
				</ul>
			</div>
			<br>
			<br> <a href="#" class="filtering">색상</a>
			<div class="button-group" data-filter-group="color">
				<ul>
					<li><button class="button is-checked" data-filter="">전체보기</button>
					<li><button class="button" data-filter=".White">White</button>
					<li><button class="button" data-filter=".Pink">Pink</button>
					<li><button class="button" data-filter=".Blue">Blue</button>
					<li><button class="button" data-filter=".Green">Green</button>
					<li><button class="button" data-filter=".Black">Black</button>
				</ul>
			</div>
		</div>
	</aside>
<div id="list_itemList_container">
	<!-- 목록 -->
	<main id="itemList_main">
		<div class="container3">
				<c:forEach var="dto" items="${list}">
					<div class="item_info">
						<table class="itemList_table">
							<tr>
								<td>
									<img src="../storage/${dto.item_image1}" width="380" height="380" class="item_image1" style="cursor: pointer;">
									<input type="hidden" value="${dto.item_code }" class="itemList_code">
								</td>
							</tr>
							<tr>
								<td><label id="item_name" style="color: #444444; float:right;">${dto.item_name}</label></td>
							</tr>
						</table>
					</div>
				</c:forEach>
		</div>		
	</main>
</div>
</body>
</html>