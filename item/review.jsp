<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 게시판</title>
<link rel="stylesheet" href="../css/review.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {		
		// 별점 기능
		$(".stars").on("click", function(){		// 속성이 active 일때
			var index = $(this).index();
			if($(this).attr("src") == "../img/star_active.png") {
				// 별 채우기 해제
				for(var i=0; i<5; i++) {
					$(".stars").eq(i).attr("src", "../img/star.png");
				}
			} else {
				// 누른 아이콘의 인덱스까지 별 채우기
				for(var i=0; i<index+1; i++) {
					$(".stars").eq(i).attr("src", "../img/star_active.png");
				}
			}		
		});
		
		$("#review_submit").click(function(){
			// 입력 검사
			if(!$("#comment").val()) {
				alert("내용을 입력해주세요.");
				$("#comment").focus();
				return false;
			} 
			
			// 작성 일시 만들기
			// 작성일시 만들기
			var date = new Date();
			var yy = date.getFullYear();
			var mm = date.getMonth() + 1;
			var dd = date.getDate();
			var hh = date.getHours();
			var mi = date.getMinutes();
			var ss = date.getSeconds();
			// 자리수 보정
			if(mm<10) mm = "0" + mm;
			if(dd<10) dd = "0" + dd;
			if(hh<10) hh = "0" + hh;
			if(mi<10) mi = "0" + mi;
			if(ss<10) ss = "0" + ss;	
			// 오늘 날짜 생성
			var today = yy + "-" + mm + "-" + dd + "-" + hh + ":" + mi + ":" + ss;
			
			/* DB로 보내기 */
			
			
			/* DB내용 불러오기 */
			
			
			// 태그 생성
			var new_li = $("<li>");
			new_li.addClass("comment_item");

			var write_p = $("<p>");
			write_p.addClass("writer");
			
			var id_span = $("<span>");
			id_span.addClass("comment_id");
			id_span.html("test님");		//$("#user_name").val() + "님" : 세션 아이디
			
			var date_span = $("<span>");
			date_span.html(" / " + today + " ");
			
			var del_input = $("<img>");
			del_input.attr({		// 값을 여러개 입력할때는 중괄호
				"src":"../img/cancel.png",		
				"width":"15",
				"height":"15"
			});
			del_input.addClass("delete_btn");
			
			var content_p = $("<p>");
			content_p.html($("#comment").val());
			
			/* 조립과 삽입 */
			// 태그 조립하기
			write_p.append(id_span).append(date_span).append(del_input);
			new_li.append(write_p).append(content_p);	
			// <ul> 태그에 삽입
			$("#review_list").append(new_li);
			
			return false;	// submit 무효화
		});	
		
		// 삭제 버튼 클릭시의 동작을 미리 설정
		// on() : 존재하지 않는 태그의 이벤트를 document 내장 객체에 등록하는 것
		$(document).on("click", ".delete_btn", function(){
			if(confirm("정말 선택하신 항목을 삭제하시겠습니까?")) {
				$(this).parents(".comment_item").remove();
			}
		});			
	});
</script>
</head>
<body>

	<div id="container">
		<div id="review_write">
			<p id="review_info">-별점과 리뷰를 남겨주세요-</p>
			<form action="" id="review_form">	
				<!-- 별점 -->
				<div id="stars_all">
					<img class="stars" alt="" src="../img/star.png" width="25" height="25">
					<img class="stars" alt="" src="../img/star.png" width="25" height="25">
					<img class="stars" alt="" src="../img/star.png" width="25" height="25">
					<img class="stars" alt="" src="../img/star.png" width="25" height="25">
					<img class="stars" alt="" src="../img/star.png" width="25" height="25">
				</div>
				<div id="review_comment">
					<label>리뷰 내용</label>
					<textarea name="comment" id="comment"></textarea>
				</div>
				<div id="review_submit">
					<img alt="" src="../img/submit.png" width="25" height="25">
				</div>
			</form>
		</div>
			
		<hr>
		
		<!-- 리뷰 게시판 -->
		<ul id="review_list">
		<!-- DB : 기존의 리뷰 내용 불러오기 -->
			<!-- c:forEach : 목록 5개씩 블록은 3개? -->
			<li class="comment_item">
				<span class="comment_id">test님</span>	<!-- 임시 -->
				<span>*작성일자*</span>	<!-- 임시 -->
				<!-- 별점 내용 추가 -->
				<p>리뷰내용</p>
			</li>
			<!-- 태그 추가 -->
			
		</ul>
	</div>
</body>
</html>