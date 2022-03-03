<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.border{
	border: 1px solid black;
	width:500px;
	height:500px;
	text-align:center;
}
.content{
	background:skyblue;
	height:300px;
}
</style>
</head>
<body>
	<div class="border">
		<h1>글 내용 상세보기</h1>
		제목:${bean.board_subject }&emsp;&emsp;첨부파일:<a href="#">${bean.board_file}</a>
		<br>
		<br>
		<div class="content">
			<p>
				<pre>${bean.board_content }</pre>
			</p>
		</div>
		<input type="button" value="답변" onclick="location.href='boardReplyForm.do?board_num=${bean.board_num}&pg=${pg}'">
		<input type="button" value="수정" onclick="location.href='boardModify.do?board_num=${bean.board_num}&pg=${pg}'">
		<input type="button" value="삭제" onclick="location.href='boardDeleteForm.do?board_num=${bean.board_num}&pg=${pg}'">
		<input type="button" value="목록" onclick="location.href='boardList.do?pg=${pg}'">
	</div>
</body>
</html>