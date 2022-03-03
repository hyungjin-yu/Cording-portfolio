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
	<form action="boardReplyPro.do" method="post"> 
	<input type="hidden" name="pg"  value="${pg}">
	<input type="hidden" name="board_num" value="${boardBean.board_num}">
	<input type="hidden" name="board_re_ref" value="${boardBean.board_re_ref}">
	<input type="hidden" name="board_re_lev"  value="${boardBean.board_re_lev}">
	<input type="hidden" name="board_re_seq"  value="${boardBean.board_re_seq}">
		<h2 align="center">답글 등록</h2>
			<table>
				<tr>
					<td class="sub">글쓴이</td>
					<td class="content"><input type="text" name="board_name"></td>
				</tr>
				<tr>
					<td class="sub">비밀번호</td>
					<td class="content" ><input type="password" name="board_pass"></td>
				</tr>
				<tr>
					<td class="sub">제목</td>
					<td class="content" ><input type="text" name="board_subject"></td>
				</tr>
				<tr>
					<td class="sub">내용</td>
					<td class="content"><textarea rows=15" cols="40"  name="board_content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="답변글 등록">
					<input type="reset" value="다시 쓰기">
					</td>
				</tr>
			</table>
	</form>
</body>
</html>