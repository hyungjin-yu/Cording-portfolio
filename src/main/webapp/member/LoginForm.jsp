<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function login() { 
    var f = document.form;
    if(!f.id.value.trim()) {
		alert("아이디를 입력하세요");
		f.id.focus();
	} else if(!f.pwd.value.trim()) {
		alert("비밀번호를 입력하세요");
		f.pwd.focus();
	} else {
		f.submit();
	}
}
</script>
</head>
<body>
	<form action="login.jsp" method="post" name="form" onsubmit="login(); return false;">
	<table border="1">
		<tr align="center">
			<td><label>아이디</label></td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td><label>비밀번호</label></td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>