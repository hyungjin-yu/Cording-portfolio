<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#inquiryModify_body {font-family: 'Trebuchet MS', 'NanumSquareAcb', serif;}
#view_modify_container {
	width: 950px;
	height: 700px;
	padding: 30px 20px;
	margin: auto;
}
#modify_content textarea {
	border : 1px solid #ccc;
	vertical-align: middle;
	margin-top: 10px;
	padding: 3px 10px;
	font-size: 14px;
	line-height: 150%;
	width: 930px;
	height: 150px;
	text-align: left;
	resize: none;
}
#modify_subject > input {font-size: 27px; font-weight: bold;}
#modify_info {width: 840px; margin:0 30px;}
#modify_date {float: left; padding: 0 0 0 500px; font-size: 14px;}
#modify_id {float: left; text-align: center; font-size: 14px;}
.inquiry_modify_btn {text-align: right;}
#inquiry_modify_btn1 {width:190px; margin-top: 20px; padding: 4px; display: inline-block;}
#btn_image {margin: 0 20px;}
#inquiry_modify_btn1 a {text-decoration: none; color:#262222;}
#inquiry_modify_btn1 a:hover {text-decoration: underline;}
#modify_submit:hover {text-decoration: underline;}
</style>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#modify_submit").click(function(){
			var inquiry_subject = $("#modify_subject").find("#subject_text").val();
			var inquiry_content = $("#modify_textarea").val();
			
			// 입력검사
			if(!inquiry_subject) {
				alert("제목을 입력해주세요.");
				$("#modify_subject").find("#subject_text").focus();
			} else if(!inquiry_content) {
				alert("내용을 입력해주세요.");
				$("#modify_textarea").focus();
			} else {
				location.href="../item/inquiryModify.do?inquiry_subject=" + inquiry_subject 
												+ "&inquiry_content=" + inquiry_content 
												+ "&pg=${pg}&inquiry_code=${inquiry_code}";
			}
		});
		
		// 뒤로가기
		$("#btn_image").click(function(){
			var result = confirm("수정을 취소하시겠습니까?");
			if(result) {
				history.back();
			}
		});
	});
</script>
</head>
<body id="inquiryModify_body">
	<div id="view_modify_container">
	<h2>문의글 수정</h2>
		<div id="modify_container">	
			<div id="modify_subject">
				<input type="text" size="58" id="subject_text" value="${dto.inquiry_subject }">
				<hr>
			</div>
			<div id="modify_info">
				<div id="modify_id">
					<p>작성자 : ${dto.user_id }</p>		
				</div>
				<div id="modify_date">
					<p>작성일 : ${dto.inquiry_date }</p>
				</div>
			</div>
			<div id="modify_content">
				<textarea id="modify_textarea">${dto.inquiry_content }</textarea>
			</div>
			<!-- 세션아이디와 작성자id가 일치 -->
			<!--<c:if test="${memId == dto.user_id }">	
				
			</c:if>-->
			<div class="inquiry_modify_btn">	
			<div id="inquiry_modify_btn1">
				<span id="modify_submit" style="cursor:pointer;">수정하기</span>&nbsp;&nbsp;
				<!-- 뒤로가기 -->
				<img src="../img/back.png" width="20" height="20" style="cursor:pointer;" id="btn_image">
			</div>
			</div>
		</div>
	</div>
</body>
</html>