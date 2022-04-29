<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 상세보기</title>
<style type="text/css">
#view_container {
	width: 950px;
	height: 1000px;
	padding: 30px 20px;
	margin: auto;
}
#inquiry_reply_form {width: 950px; height: 500px;}
#reply_write {padding: 15px; margin: auto;}
#reply_comment {text-align: center;}
#reply_info {font-size: 14px; text-align: center;}
#reply_write textarea {
	border : 1px solid #ccc;
	vertical-align: middle;
	margin-top: 10px;
	padding: 3px 10px;
	font-size: 12px;
	line-height: 150%;
	width: 800px;
	height: 150px;
	resize: none;
}
#reply_submit {margin-top: 10px; padding: 4px; float: right;}
#view_subject > p {font-size: 27px; font-weight: bold;}
#view_info {width: 840px; margin:0 30px;}
#view_date {float: left; padding: 0 0 0 500px; font-size: 14px;}
#view_id {float: left; text-align: center; font-size: 14px;}
#view_content{width: 850px; height: 300px; border: 1px solid; clear: both; padding: 20px; margin: auto;}
.inquiry_view_btn {text-align: right;}
#inquiry_view_btn1 {width:190px; margin-top: 20px; padding: 4px; display: inline-block;}
#btn_image {margin: 0 20px;}
#inquiry_view_btn1 a {text-decoration: none; color:#262222;}
#inquiry_view_btn1 a:hover {text-decoration: underline;}
</style>
<script type="text/javascript">
	$(function(){
		// 뒤로가기 버튼 누르면 history.back();
		$("#inquiry_view_btn1 img").click(function(){
			history.back();
		});
		
		$("#inquiry_reply_form").hide();
		
		$("#reply_btn").click(function(){
			$("#inquiry_reply_form").show();
		});
		
		// 답글 입력검사
		$("#reply_submit_btn").click(function(){
			if(!$("#subject_form").val()) {
				alert("제목을 입력해주세요.");
				$("#subject_form").focus();
				return false;
			} else if(!$("#comment_form").val()) {
				alert("내용을 입력해주세요.");
				$("#comment_form").focus();
				return false;
			}
			
			var subject = $("#subject_form").val();
			var content = $("#comment_form").val();

			location.href="../item/inquiryReply.do?inquiry_subject=" + subject 
							+ "&inquiry_content=" + content + "&pg=${pg}&inquiry_code=${dto.inquiry_code}";
		});
	});
</script>
</head>
<body>
	<div id="view_container">	
		<div id="view_subject">
			<p>${dto.inquiry_subject }</p>
			<hr>
		</div>
		<div id="view_info">
			<div id="view_id">
				<p>작성자 : ${dto.user_id }</p>		
			</div>
			<div id="view_date">
				<p>작성일 : ${dto.inquiry_date }</p>
			</div>
		</div>
		<div id="view_content">
			${dto.inquiry_content }
		</div>
	
		<div class="inquiry_view_btn">
			<div id="inquiry_view_btn1">
			<c:if test="${login_id == dto.user_id }">
				<!-- 수정 -->
				<a href="../item/inquiryModifyForm.do?pg=${pg }&inquiry_code=${dto.inquiry_code }">수정</a>&nbsp;&nbsp;
				<!-- 삭제 -->
				<a href="../item/inquiryDelete.do?pg=${pg }&inquiry_code=${dto.inquiry_code }">삭제</a>&nbsp;&nbsp;
			</c:if>	
				<!-- 답글 : 누르면 밑에 답글 작성 폼이 나타남 -->
				<span id="reply_btn" style="cursor:pointer;">답글</span>	
				
				<!-- 뒤로가기 -->
					<img src="../img/back.png" width="20" height="20" style="cursor:pointer;" id="btn_image">
			</div>
		</div>
		
<!-- 답글 폼 생성 -->

		<div id="inquiry_reply_form">
			<!-- href="../item/inquiryReply.do?pg=${pg }&inquiry_code=${dto.inquiry_code }" -->
			<div id="reply_write">
				<p id="reply_info">-답글을 적어주세요-</p><br>
				<div id="reply_comment">
					<div>제목 : <input type="text" id="subject_form" size="80"></div>
					<div><textarea name="comment" id="comment_form"></textarea></div>
				</div>
				<div id="reply_submit">
					<img src="../img/submit.png" width="25" height="25" style="cursor:pointer;" id="reply_submit_btn">
				</div>
			</div>
		</div>
	</div>
</body>
</html>