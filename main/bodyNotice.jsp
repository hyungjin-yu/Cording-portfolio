<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#bodyNotice_body {
	padding: 0;
	margin: 0;
	width: 100%;	
}
#notice_line {
	font-size: 25px;
	text-decoration: underline;
	text-underline-position: under;
}
a {
	text-decoration: none;
	color: #262222;
}
#notice_line:hover,
a:hover {
	color: #7C7C7C;
}
</style>
</head>
<body id="bodyNotice_body">
	<span id="notice_line">Notice : <a href="../notice/noticeList.do"> ${dto.notice_title } </a></span>
</body>
</html>