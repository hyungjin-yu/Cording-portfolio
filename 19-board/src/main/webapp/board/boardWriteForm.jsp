<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	width:400px;
	height:800px
}
.sub {
	text-align: left;
	background-color: orange;
	width: 100px;
}
.content {
	background-color: skyblue;
}
</style>
</head>
<body>
	<form action="boardWritePro.do" method="post" enctype="multipart/form-data"> 
		<h2 align="center">게시판 등록</h2>
			<table>
				<tr>
					<td class="sub" name="board_name">글쓴이</td>
					<td class="content"><input type="text"></td>
				</tr>
				<tr>
					<td class="sub">비밀번호</td>
					<td class="content" name="board_pass"><input type="password"></td>
				</tr>
				<tr>
					<td class="sub">제목</td>
					<td class="content" name="board_subject"><input type="text"></td>
				</tr>
				<tr>
					<td class="sub">내용</td>
					<td class="content" name="board_content"><textarea rows=15" cols="40"></textarea></td>
				</tr>
				<tr>
					<td class="sub">파일 첨부</td>
					<td class="content" name="board_file"><input type="file" value="찾아보기..."></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="reset" value="다시 쓰기">
					</td>
				</tr>
			</table>
	</form>
</body>
</html>