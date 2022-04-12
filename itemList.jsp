<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/itemList.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".filtering").click(function(){
			if($(this).next().css("display")=="none") {
				$(this).next().slideDown(300);
			} else {
				$(this).next().slideUp();
			}
		});
		
		$("#filter_tool").click(function() {
			if($(".container2").next().css("marginLeft")=="0px") {
				$(".container2").delay(10); 
				$(".container2").animate({width:"toggle"},400);
			} else {
				$(".container2").delay(10); 
				$(".container2").animate({width:"toggle"},0);
			}
		});
	});
</script>
</head>
<body>
	<!---- HEADER ---->
	<header class="container1">
		<div class="category">
			<ul class="category_bar">
				<li><a href="../main/index.jsp">Men`s</a></li>
			</ul>
		</div>
		<!-- 메뉴 바 : 전체보기 신발 의류 -->
		<div class="menu_bar">
			<ul class="menu">
				<li><a href="#">전체보기</a></li>
				<li><a href="#">신발</a></li>
				<li><a href="#">의류</a></li>
			</ul>
		</div>
		<!-- 필터 버튼 -->
		<div class="filter">
			<ul class="filter_bar">
				<li><a href="#" id="filter_tool">필터</a></li>
				<div id="new_list">
					<select id="list">
						<option value="신상품순">신상품순</option>
						<option value="높은 가격순">높은 가격순</option>
						<option value="낮은 가격순">낮은 가격순</option>
						<option value="추천순">추천순</option>
					</select>
				</div>
			</ul>
		</div>
	</header>
	<!-- 상품 정렬 필터링 -->
	
	
	<!-- 필터리스트 -->
	<aside>
		<div class="container2">
			<a href="#" class="filtering">사이즈</a>
				<div class="bar">
					<ul>
						<li><a href="#" id="250">250</a>
						<li><a href="#" id="255">255</a>
						<li><a href="#" id="260">260</a>
						<li><a href="#" id="265">265</a>
					</ul>
				</div><br><br>
			<a href="#" class="filtering">색상</a>
				<div class="bar">
					<ul>
						<li><a href="#" id="white">White</a>
						<li><a href="#" id="basic">Basic</a>
						<li><a href="#" id="blue">Blue</a>
						<li><a href="#" id="green">Green</a>
					</ul>
				</div>
		</div>
	</aside>
	
	<!-- 목록 -->
	<main>
		<div class="container3">
			<div id="item">
				<img alt="나이키머큐리얼에어줌베이퍼14프로" src="../img/나이키머큐리얼에어줌베이퍼14프로TF_footballgrey_1.jpg">
				<label>나이키 머큐리얼 에어 줌 베이퍼 14 프로를 신고 거침없는 스피드를 만끽하세요. 최소한의 소재를 사용한 세련된 디자인으로 경기 시작부터 끝까지 한결같이 빠른 스피드를 유지할 수 있습니다.</label>
			</div>
			<div id="item">
				<img alt="나이키머큐리얼에어줌베이퍼14프로" src="../img/나이키머큐리얼에어줌베이퍼14프로TF_footballgrey_1.jpg">
				<label>나이키 머큐리얼 에어 줌 베이퍼 14 프로를 신고 거침없는 스피드를 만끽하세요. 최소한의 소재를 사용한 세련된 디자인으로 경기 시작부터 끝까지 한결같이 빠른 스피드를 유지할 수 있습니다.</label>
			</div>
			<div id="item">
				<img alt="나이키머큐리얼에어줌베이퍼14프로" src="../img/나이키머큐리얼에어줌베이퍼14프로TF_footballgrey_1.jpg">
				<label>나이키 머큐리얼 에어 줌 베이퍼 14 프로를 신고 거침없는 스피드를 만끽하세요. 최소한의 소재를 사용한 세련된 디자인으로 경기 시작부터 끝까지 한결같이 빠른 스피드를 유지할 수 있습니다.</label>
			</div>
			<div id="item">
				<img alt="나이키머큐리얼에어줌베이퍼14프로" src="../img/나이키머큐리얼에어줌베이퍼14프로TF_footballgrey_1.jpg">
				<label>나이키 머큐리얼 에어 줌 베이퍼 14 프로를 신고 거침없는 스피드를 만끽하세요. 최소한의 소재를 사용한 세련된 디자인으로 경기 시작부터 끝까지 한결같이 빠른 스피드를 유지할 수 있습니다.</label>
			</div>
		</div>
		<!-- 페이지 표시 -->
		<div style="text-align: center;">
			<c:if test="${startPage > 3 }">
				[<a class="paging" href="boardList.do?pg=${startPage - 1 }">이전</a>]
			</c:if>
		
			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
				<c:if test="${pg == i }">
					[<a class="currentPaging" href="boardList.do?pg=${i }">${i }</a>]
				</c:if>
				<c:if test="${pg != i }">
					[<a class="paging" href="boardList.do?pg=${i }">${i }</a>]
				</c:if>		
			</c:forEach>
		
			<c:if test="${endPage < totalP }">
				[<a class="paging" href="boardList.do?pg=${endPage + 1 }">다음</a>]
			</c:if>		
		</div> 
	</main>
	
</body>
</html>