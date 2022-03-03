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
	<table border="1">
		<tr>
			<td>비밀 번호 : </td>
			<td><input type="password" name="board_pass"></td><br>
			<td>
				<input type="submit" value="삭제">
				<input type="button" value="돌아가기" onclick="history.back()">
				<input type="hidden" name="board_num" value="${param.board_num }">
				<input type="hidden" name="pg" value="${param.pg }">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>