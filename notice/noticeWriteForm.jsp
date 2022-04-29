<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW(관리자) - 공지등록</title>
<link rel="stylesheet" href="../css/noticeWriteForm.css">
<script type="text/javascript" src="../script/noticeScript.js?v=1"></script>
</head>
<body>
<div id="notice_write_form">
	<div id="notice_write_form_inner">
		<form action="../notice/noticeWrite.do" method="post" name="noticeWriteForm"
			onsubmit="checkNoticeWrite(); return false;">
			<div id="notice_write_label_div">
				New Notice
			</div>
			
			<div class="notice_write_field" id="notice_title_div">
				<input type="text" id="notice_title" name="notice_title" placeholder="제목">
			</div>
			<div class="notice_write_field" id="content_div">
				<textarea id="notice_content" name="notice_content" placeholder="설명"></textarea>
			</div>
			<div id="notice_write_form_buttons_div">
				<button type="submit" id="submit_button">공지 등록</button>
				<button type="reset" id="reset_button">등록 취소</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>