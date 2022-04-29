<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW</title>
</head>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<link rel="stylesheet" href="../css/index.css">

<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".top_menu > li").mouseenter(function(){
			let menu_i = $(this).index();
			
			if(menu_i < 3) {
				$(".menu_pan").css({
					display: "none"
				}).eq($(this).index()).css({
					background: "#fff"
				}).slideDown();
			}
		});
		
		$(".menu_pan").mouseleave(function(){
			$(".menu_pan").slideUp();
		});
		
		// 로그인 알림창
		$(".icon_private > a").click(function(){
			if(${login_id == null}) {
				alert("로그인 후 이용가능합니다.");
				return false;
			}
		});
	});
</script>
<body id="indexBody">
<!---- HEADER ---->
	<div id="indexHeader">
			<!-- 로고 이미지 -->
			<div id="logo">
				<a href="../main/index.jsp">
					<img alt="NAW" src="../img/NAW_main.jpg" width="110" height="100">
				</a>
			</div>
			<!-- 메뉴 바 : MEN WOMEN KIDS -->
			<div class="menu_bar">
				<ul class="top_menu">
					<li><a href="../item/itemList_category1.do?item_category1=MEN">MEN</a></li>
					<li><a href="../item/itemList_category1.do?item_category1=WOMEN">WOMEN</a></li>
					<li><a href="../item/itemList_category1.do?item_category1=KIDS">KIDS</a></li>
				</ul>
			</div>
			
			<!-- 아이콘 -->
			<!-- 세션 id값이 없으면 alert창 띄우기 -->
			<div id="icon">		
				<span class="icon_private">
					<a href="../orderlist/orderlist.do"><img alt="orderlist" src="../img/list.png" width="25" height="27"></a>
					<a href="../mypage/mypageForm.do"><img alt="user" src="../img/user.jpg" width="33" height="33"></a>
					<a href="../item/cartList.do"><img alt="cart" src="../img/shopping-cart.jpg" width="33" height="33"></a>
					<a href="../item/inquiryList.do"><img alt="inquiry" src="../img/conversation.png" width="27" height="30"></a>	
				</span>	
				<c:if test="${login_id == null }">
					<a href="../signin/profileMain.do"><img alt="login" src="../img/enter.png" width="28" height="27"></a>
				</c:if>
				<c:if test="${login_id != null }">
					<a href="../signin/logout.do"><img alt="logout" src="../img/logout.png" width="28" height="27"></a>
				</c:if>
				
			</div>		

		<!-- 하위 메뉴 카테고리 : 신발 의류 용품 -->
		<div class="menu_pan">
			<div class="c">
				<!-- MEN 하위 메뉴 -->
				<div class="menu_sub">
					<div class="category"><a href="../item/itemList_category2.do?item_category1=MEN&item_category2=신발">신발</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=신발&item_category3=러닝">러닝</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=신발&item_category3=농구">농구</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=신발&item_category3=축구">축구</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=신발&item_category3=골프">골프</a></div>
				</div>
										
				<div class="menu_sub">
					<div class="category"><a href="../item/itemList_category2.do?item_category1=MEN&item_category2=의류">의류</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=의류&item_category3=자켓">자켓</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=의류&item_category3=티셔츠">티셔츠</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=의류&item_category3=후디">후디</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=의류&item_category3=팬츠">팬츠</a></div>
				</div>
										
				<div class="menu_sub">
					<div class="category"><a href="../item/itemList_category2.do?item_category1=MEN&item_category2=용품">용품</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=용품&item_category3=양말">양말</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=용품&item_category3=모자">모자</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=용품&item_category3=가방">가방</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=MEN&item_category2=용품&item_category3=장갑">장갑</a></div>
				</div>	
			</div>		
		</div>	
						
		<div class="menu_pan">	
			<div class="c">
				<!-- WOMEN 하위 메뉴 -->
				<div class="menu_sub">
					<div class="category"><a href="../item/itemList_category2.do?item_category1=WOMEN&item_category2=신발">신발</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=신발&item_category3=러닝">러닝</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=신발&item_category3=트레이닝">트레이닝</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=신발&item_category3=아웃도어">아웃도어</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=신발&item_category3=골프">골프</a></div>
				</div>
					
				<div class="menu_sub">
					<div class="category"><a href="../item/itemList_category2.do?item_category1=WOMEN&item_category2=의류">의류</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=의류&item_category3=자켓">자켓</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=의류&item_category3=티셔츠">티셔츠</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=의류&item_category3=후디">후디</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=의류&item_category3=팬츠">팬츠</a></div>
				</div>
								
				<div class="menu_sub">
					<div class="category"><a href="../item/itemList_category2.do?item_category1=WOMEN&item_category2=용품">용품</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=용품&item_category3=양말">양말</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=용품&item_category3=모자">모자</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=용품&item_category3=가방">가방</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=WOMEN&item_category2=용품&item_category3=장갑">장갑</a></div>
				</div>
			</div>
		</div>	
						
		<div class="menu_pan">	
			<div class="c">
				<!-- KIDS 하위 메뉴 -->
				<div class="menu_sub">
					<div class="category"><a href="../item/itemList_category2.do?item_category1=KIDS&item_category2=신발">신발</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=신발&item_category3=Big">big</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=신발&item_category3=Little">little</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=신발&item_category3=Babies">babies</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=신발&item_category3=Running">Running</a></div>
				</div>
								
				<div class="menu_sub">
					<div class="category"><a href="../item/itemList_category2.do?item_category1=KIDS&item_category2=의류">의류</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=의류&item_category3=자켓">자켓</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=의류&item_category3=티셔츠">티셔츠</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=의류&item_category3=후디">후디</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=의류&item_category3=팬츠">팬츠</a></div>
				</div>
								
				<div class="menu_sub">
					<div class="category"><a href="../item/itemList_category2.do?item_category1=KIDS&item_category2=용품">용품</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=용품&item_category3=양말">양말</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=용품&item_category3=모자">모자</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=용품&item_category3=가방">가방</a></div>
					<div class="category"><a href="../item/itemList_category3.do?item_category1=KIDS&item_category2=용품&item_category3=장갑">장갑</a></div>
				</div>
			</div>
		</div>
	</div>								
	
<!---- CONTAINER ---->	
	<div id="indexContainer">
		<!-- view -->
		<div id="indexSection">
			<!-- 관리자 페이지 아이디 : admin, 비밀번호 : admin -->
			<c:if test="${login_id == 'admin'}">			
				<c:if test="${req == null }">
					<jsp:include page="../admin/adminBody.jsp"/>
				</c:if>
				<!-- req로 정보 보내기 -->
				<c:if test="${req != null }">
					<jsp:include page="${req }"/>
				</c:if>	
			</c:if>
			
			<!-- 고객 페이지 -->
			<c:if test="${login_id != 'admin'}">
				<c:if test="${req == null }">
					<jsp:include page="../main/body.jsp"/>		<!-- 공지 최신글 받아오려면 .do -->
				</c:if>
				<!-- req로 정보 보내기 -->
				<c:if test="${req != null }">
					<jsp:include page="${req }"/>
				</c:if>	
			</c:if>
		</div>
	</div>
	
<!---- FOOTER ---->	
	<div id="indexFooter">
	<!-- 사이트 정보 -->
		<p>서울 서초구 서초대로77길 55 에이프로스퀘어 3층</p>
		<p>project_NAW: KJE&nbsp;YHJ&nbsp;LHW&nbsp;CYJ&nbsp;&nbsp;TEL: 032)3333-3333</p>
	</div>
</body>
</html>