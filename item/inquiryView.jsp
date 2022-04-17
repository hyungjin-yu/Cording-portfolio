<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 상세보기</title>
<style type="text/css">
#container {
	width: 500px;
	padding: 30px 20px;
}

#view_table {
	width: 100%;
	border: 1px solid #ccc;
}
#view_subject > p {font-size: 32px; font-weight: bold;}
#view_info {margin:0;}
#view_date {float: left; padding: 0 0 0 200px; font-size: 14px;}
#view_id {float: left; text-align: center; font-size: 14px;}
#view_content{width: 450px; height: 300px; clear: both; background: #ccc; padding: 20px; margin: auto;}
#view_btn {float: right;}
</style>
</head>
<body>
	<div id="container">
		<div id="view_subject">
			<p>$제목</p>
			<hr>
		</div>
		<div id="view_info">
			<div id="view_id">
				<p>$작성자id</p>		
			</div>
			<div id="view_date">
				<p>$작성일자</p>
			</div>
		</div>
		<div id="view_content">
			$문의내용
		</div>
		<br>
		<!-- 본인이면 삭제하기 -->
		<!-- 답글 -->
		
		<!-- 뒤로가기 -->
		<div id="view_btn">
			<img alt="" src="../img/back.png" width="25" height="25">	<!-- 클릭시 history.back() -->
		</div>
	</div>
</body>
</html>