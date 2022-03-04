<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="boardDeletePro.do" method="post">
		<label>비밀 번호 : </label>
		<input type="password" name="board_pass"><br><br>
		<input type="submit" value="삭제">
		<input type="button" value="돌아가기" onclick="history.back()">
		<input type="hidden" name="board_num" value="${param.board_num }">	 <!-- param.board_num도 가능, board_num도 가능 상관없다 -->
		<input type="hidden" name="pg" value="${param.pg }">
	</form>
</body>
</html>