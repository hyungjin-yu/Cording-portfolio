<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
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
		
		// 입력검사
		$("#review_modify_submit_btn").click(function(){
			// 입력 검사
			if(!$("#comment").val()) {
				alert("내용을 입력해주세요.");
				$("#comment").focus();
				return false;
			} 
			
			/* DB로 보내기 */
			var review_code = ${dto.review_code};
			var review_content = $("#comment").val();
			var review_star = 0;
			for(var i=0; i<5; i++) {
				if($(".stars").eq(i).attr("src") == "../img/star_active.png") {
					review_star++;
				}
			}			
			location.href="../item/reviewModify.do?review_content=" + review_content +
								"&review_star=" + review_star + "&review_code=" + review_code + "&item_code=${item_code}";
		});
	});
</script>
<style type="text/css">
#review_modify_container {width: 500px; padding: 30px 20px; margin: 50px auto;}
#reviewModifyForm_body {font-family: 'Trebuchet MS', 'NanumSquareAcb', serif; width: 100%;}
#review_modify_write {padding: 20px 15px; border-bottom: 1px solid #c0c0c0;}
#review_modify_info {font-size: 14px;text-align: center;}
#stars_all {padding: 10px 0 0 0;text-align: right;}
#review_modify_write label {display: inline-block;width: 80px;font-size: 14px;font-weight: bold;margin-bottom: 10px;}
#review_modify_write textarea {
	border : 1px solid #ccc;
	vertical-align: middle;
	padding: 3px 10px;
	font-size: 12px;
	line-height: 150%;
	width: 400px;
	height: 90px;
}
#review_modify_submit {text-align: right;}
</style>
</head>
<body id="reviewModifyForm_body">
<div id="review_modify_container">
	<div id="review_modify_write">
		<p id="review_modify_info">-수정할 내용을 적어주세요-</p>	
		<!-- 별점 -->
		<div id="stars_all">
			<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
			<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
			<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
			<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
			<img class="stars" alt="" src="../img/star.png" width="25" height="25" style="cursor:pointer;">
		</div>
		<div id="review_modify_comment">
			<label>리뷰 내용</label>
			<textarea name="comment" id="comment">${dto.review_content }</textarea>
		</div>
		<div id="review_modify_submit">
			<img alt="" src="../img/submit.png" id="review_modify_submit_btn" width="25" height="25" style="cursor:pointer;">
		</div>
	</div>
</div>
</body>
</html>