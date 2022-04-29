<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW(관리자) - 공지수정</title>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#submit_button").click(function(){
			var title = $("#notice_title").val();
			var content = $("#notice_content").text();
			
			location.href="../notice/noticeModify.do?notice_title=" 
					+ title + "&notice_content=" + content + "&seq=${seq}";
		});
	});

</script>
<style type="text/css">
#notice_modify_form {
	width: 100%;
	height: 600px;
	display: inline-flex;
	justify-content: center;
	margin-bottom: 20px;
}
#notice_modify_form_inner {
	width: 50%;
	height: 599px;
	border-collapse: collapse;
}
#notice_modify_label_div {
	width: 100%;
	height: 40px;
	font-size: 50px;
	display: inline-table;
	margin-top: 25px;
	margin-bottom: 25px;
}
.notice_modify_field > input[type="text"] {
	width: 100%;
	height: 40px;
    border: 1px solid #767677;
    margin-bottom: 30px;
}
.notice_modify_field > textarea {
	width: 100%;
	height: 100px;
    border: 1px solid #767677;
    margin-bottom: 30px;
}
#notice_modify_form_buttons_div {
	width: 100%;
	display: inline-flex;
	justify-content: center;
}

#notice_content {
	height: 300px;
}

#notice_modify_form_buttons_div > button {
	width: 120px;
	height: 40px;
	border: 1px solid black;
	font-weight: bold;
	margin-left: 5px;
	margin-right: 5px;
}
#submit_button {
	background-color: black;
	color: white;
}
#reset_button {
	background-color: white;
	color: black;
}
#submit_button:hover, 
#reset_button:hover {
	color: #767677;
	border: 1px solid #767677;
	cursor: pointer;
}

</style>
</head>
<body>
<div id="notice_modify_form">
	<div id="notice_modify_form_inner">
		<div id="notice_modify_label_div">
			Notice Modify
		</div>
	
		<div class="notice_modify_field" id="notice_title_div">
			<input type="text" id="notice_title" name="notice_title" value="${dto.notice_title }">
		</div>
		<div class="notice_modify_field" id="content_div">
			<textarea id="notice_content" name="notice_content">${dto.notice_content }</textarea>
		</div>
		<div id="notice_modify_form_buttons_div">
			<button type="submit" id="submit_button">공지 수정</button>
			<button type="reset" id="reset_button" onclick="history.back()">등록 취소</button>
		</div>
	</div>
</div>
</body>
</html>