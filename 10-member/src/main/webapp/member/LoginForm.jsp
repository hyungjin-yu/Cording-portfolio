<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/memberScript.js"></script>
<style type="text/css">
table, td{
	border: 1px solid black;
}
</style>
</head>
<body>
	<form action="login.jsp" method="post" name="form1">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="로그인" onclick="checklLogin(); return false;">
				<input type="button" value="회원가입" onclick="location.href='writeForm.jsp'">
				<input type="button" value="회원가입" onclick="location.href='move_writeForm()'">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>