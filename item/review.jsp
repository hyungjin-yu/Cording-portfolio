<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 게시판</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
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
		
		// 입력
		$("#review_submit_btn").click(function(){
			// 로그인 확인
			if(${login_id == null}) {
				alert("로그인 후 이용가능합니다.");
				return false;
			} else if(!$("#comment").val()) {	// 입력검사
				alert("내용을 입력해주세요.");
				$("#comment").focus();
				return false;
			} 
			
			/* DB로 보내기 */
			var item_code = $(this).parent().find(".item_code").val();
			var review_content = $("#comment").val();
			var review_star = 0;
			for(var i=0; i<5; i++) {
				if($(".stars").eq(i).attr("src") == "../img/star_active.png") {
					review_star++;
				}
			}	
			//alert("item_code = " + item_code);
			location.href="../item/reviewWrite.do?review_content=" 
							+ review_content + "&review_star=" + review_star + "&item_code=" + item_code;		
		});	
		
		// 수정
		$(".comment_modify").on("click", function(){
			var item_code = $(this).parent().find(".item_code").val();
			var review_code = $(this).parent().find(".comment_code").val();		
			location.href="../item/reviewModifyForm.do?review_code=" + review_code 
								+ "&item_code=" + item_code;
		});
		
		// 삭제 버튼 클릭시의 동작을 미리 설정
		// on() : 존재하지 않는 태그의 이벤트를 document 내장 객체에 등록하는 것
		$(".comment_delete").click(function(){
			if(confirm("정말 선택하신 항목을 삭제하시겠습니까?")) {
				var item_code = $(this).parent().find(".item_code").val();
				var review_code = $(this).parent().find(".comment_code").val();
				// DB로 정보 보내기
				location.href="../item/reviewDelete.do?review_code=" + review_code + "&item_code=" + item_code;
			} else {
				return false;
			}	
		});
		
		$("#review_list li").slice(0, 3).show(); 		// 최초 3개 선택
		$("#view_more_btn").click(function(e){ 			// Load More를 위한 클릭 이벤트e
			e.preventDefault();
			if($("#review_list li:hidden").length != 0){ 			// 숨겨진 li가 있는지 체크
				$("#review_list li:hidden").slice(0, 2).fadeIn(); 	// 숨김 설정된 다음 10개를 선택하여 표시
							
			} else {
				alert("더 이상 항목이 없습니다"); 					// 더 이상 로드할 항목이 없는 경우 경고
			}
		});	
		
	});
</script>
</head>
<body id="review_body">
	<!-- 리뷰 작성 폼 -->
	<div id="review_container">
		<div id="review_write">
			<p id="review_info">-별점과 리뷰를 남겨주세요-</p>
			<!-- 별점 -->
			<div id="stars_all">
				<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
				<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
				<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
				<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
				<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
			</div>
			<div id="review_comment">
				<label>리뷰 내용</label>
				<textarea name="comment" id="comment"></textarea>
			</div>
			<div id="review_submit">
				<img alt="" src="../img/submit.png" id="review_submit_btn" width="23" height="23" style="cursor:pointer;">
				<input type="hidden" value="${item_code }" class="item_code">
			</div>
		</div>		
		<hr>
		<div id="review_list_container">
		<!-- 리뷰 게시판 -->
		<ul id="review_list">
		<!-- DB : 기존의 리뷰 내용 불러오기 -->

		<c:if test="${list.size() == 0 }">
			<li class="comment_item_nothing">
				<span>등록된 리뷰가 없습니다.</span>
			</li>
		</c:if>	
		
		<c:if test="${list.size() > 0 }">

			<!-- c:forEach : 목록 3개씩 -->
			<c:forEach var="vo" items="${list }">	
			<li class="comment_item">
				<span class="comment_id">${vo.user_id }님</span>
				<span>작성일: ${vo.review_date }</span>
				<c:if test="${login_id == vo.user_id }">
				<span class="comment_modify" style="cursor:pointer;">수정</span>
				<span class="comment_delete" style="cursor:pointer;">삭제</span>	
				</c:if>			
				<p><span class="comment_content">${vo.review_content }</span></p>
				<div class="star_font">
					<img src="../img/star_active.png" width="20" height="20">
					<span class="comment_star">${vo.review_star}</span>/5
				</div>
				<input type="hidden" value="${vo.review_code }" class="comment_code">
				<input type="hidden" value="${item_code }" class="item_code">
			</li>
			</c:forEach>	
		</c:if>			

		</ul>
		
		<p id="view_more_btn" style="cursor:pointer;">더보기</p>
		</div>
	</div>
</body>
</html>