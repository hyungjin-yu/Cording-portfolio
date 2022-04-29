<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title> 
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<link rel="stylesheet" href="../css/body.css?after2">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../script/jquery.bxslider.js"></script>
<script type="text/javascript">
	$(function(){
	  var $slider = $('#new_release_slider'),
	      $firstSlide = $slider.find('li').first() // 첫번째 슬라이드
	      .stop(true).animate({'opacity':1},200);  // 첫번째 슬라이드만 보이게 하기

	  function PrevSlide(){ 						//이전버튼 함수
		stopSlide();startSlide(); 					//타이머 초기화
	    var $lastSlide = $slider.find('li').last() 	//마지막 슬라이드
	    .prependTo($slider); 						//마지막 슬라이드를 맨 앞으로 보내기  
	    $secondSlide = $slider.find('li').eq(1)		//두 번째 슬라이드 구하기
	    .stop(true).animate({'opacity':0},400);		//밀려난 두 번째 슬라이드는 fadeOut 시키고
	    $firstSlide = $slider.find('li').first()	//맨 처음 슬라이드 다시 구하기
	    .stop(true).animate({'opacity':1},400);		//새로 들어온 첫 번째 슬라이드는 fadeIn 시키기
	  }
	  
	  function NextSlide(){ 						// 다음 버튼 함수
	    stopSlide();startSlide(); 					//타이머 초기화
	    $firstSlide = $slider.find('li').first() 	// 첫 번째 슬라이드
	    .appendTo($slider); 						// 맨 마지막으로 보내기
	    var $lastSlide = $slider.find('li').last() 	// 맨 마지막으로 보낸 슬라이드
	    .stop(true).animate({'opacity':0},400); 	// fadeOut시키기
	    $firstSlide = $slider.find('li').first()	// 맨 처음 슬라이드
	    .stop(true).animate({'opacity':1},400);		// fadeIn 시키기
	  }
	  
	  $('#next').on('click', function(){ 		//다음버튼 클릭
	    NextSlide();
	  });
	  $('#prev').on('click', function(){ 		//이전 버튼 클릭
	    PrevSlide();
	  });

	  startSlide(); 							// 자동 슬라이드 시작
	  
	  var theInterval;

	  function startSlide() {
	    theInterval = setInterval(NextSlide, 3000); //자동 슬라이드 설정
	  }

	  function stopSlide() { 						//자동 멈추기
	    clearInterval(theInterval);
	  }
	  
	  $('#new_release_slider').hover(function(){ //마우스 오버시 슬라이드 멈춤
	    stopSlide();
	  }, function (){
	    startSlide();
	  });
	});
</script>
</head>
<body id="body_body">	
	<!-- 신상품 : 1350x500 -->
	<div id="new_release">
		<div id="new_release_inner">		
			<!-- 자동으로 이미지가 넘어가는 기능 -->
			<div id="new_release_img">
				<ul id="new_release_slider">
				    <li>
				      <div style="background-image:url(../img/new_release1.jpg);"></div>
				    </li>
				    <li>
				      <div style="background-image:url(../img/new_release2.jpg);"></div>
				    </li>
				    <li>
				      <div style="background-image:url(../img/new_release3.jpg);"></div>
				    </li>
				    <li>
				      <div style="background-image:url(../img/new_release4.jpg);"></div>
				    </li>
				    <li>
				      <div style="background-image:url(../img/new_release5.jpg);"></div>
				    </li>
			    </ul>
		    </div>
			<div class="btn">
			  <button type="button" id="prev">&#10094;</button>
			  <button type="button" id="next">&#10095;</button>
			</div>
		</div>
	</div>
	
	<!-- 공지 (include) 최신 글 하나 보여주기 : include -->
	<div id="notice">
		<div id="first_notice">
			<jsp:include page="bodyNotice.do"/>
		</div>
	</div><br>
	
	<!-- 추천상품 : 이미지 3개 -->
	<div id="recommend">
		<div id="recommend_inner">
		<p class="title">Best Product</p><br>
		
			<div class="recommend_item">
				<a href="../item/itemView.do?item_code=3004"><img alt="1" src="../storage/나이키머큐리얼에어줌베이퍼14프로TF_footballgrey_1.jpg" width="380" height="380"></a>
				<p>나이키 머큐리얼 에어<br>줌 베이퍼 14 프로 TF</p>
			</div>					
			<div class="recommend_item">	
				<a href="../item/itemView.do?item_code=2010"><img alt="2" src="../storage/w_shoes_011_a.png" width="380" height="380"></a>
				<p>나이키 와플 데뷰</p>
			</div>			
			<div class="recommend_item">
				<a href="../item/itemView.do?item_code=3002"><img alt="3" src="../storage/조던시리즈ES_black_1.jpg" width="380" height="380"></a>
				<p>조던 시리즈 ES</p>
			</div>
		</div>
	</div><br>
	
	<!-- 인기상품소개 -->
	<div id="best">
		<div id="best_inner">
		<p class="title"></p><br>
		
		<div id="best_item">
			<!-- 6:4 -->
			<div>
			<div class="best_content">
				<p style="font-size: 40px; font-weight: bold;"><span style="font-size: 55px;">3</span>-스트라이프로 이어진 전 세계</p>
				<p style="font-size: 20px;">아디다스 커뮤니티와 하나로 연결하는 화합의 힘을 담아낸 클래식 윈드브레이커입니다.</p>
				<p style="font-size: 20px;">넉넉한 핏과 가벼운 소재의 조화로 날씨에 따라<br>티셔츠 또는 스웨트셔츠 위로 편안하게 레이어드할 수 있습니다.</p>
			</div>
			<div class="best_img">
				<img src="../storage/w_cloth_001_a.png" width="500px" height="500px">
			</div>
			</div>
			<p></p>
			
			<div>
			<div class="best_img">
				<img src="../storage/나이키스포츠웨어스우시_남성풀집리버서블재킷AS_hotcurry_1.jpg" width="500px" height="500px">
			</div>
			<div class="best_content">
				<p style="font-size: 40px; font-weight: bold;"><span style="font-size: 55px;">추</span>운 날씨를 위한 스테이트먼트 룩</p>
				<p style="font-size: 22px;">나이키 스포츠웨어 재킷은 뒤집을 수 있는 디자인의 오버사이즈 로고로 개성을 표현하고,<br>이동 중에도 룩을 바꿀 수 있습니다.</p> 
				<p style="font-size: 22px;">프렌치 테리와 태피터 소재를 사용하여 쌀쌀한 날씨에 보온성을 제공합니다.</p>
			</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
