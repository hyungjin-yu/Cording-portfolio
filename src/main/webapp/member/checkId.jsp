<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkIdClose() {
		// opener : 자바스크립트 내장 객체, 부모 브라우저를 관리하는 객체
		opener.frm.id.value = "${id}";
		window.close();
		opener.frm.pwd.focus();
	}
	
	function checkId() {
		if(!document.frm.id.value) {
			alert("아이디를 입력하세요.");
			document.frm.id.focus();
		} else {
			document.frm.submit();
		}
	}
</script>
</head>
<body>
<form action="checkId.do" method="post" name="frm">
	<c:if test="${exist}">
		${id}는 사용중입니다.<br><br>
		아이디 <input type="text" name="id">
		<input type="button" value="중복체크" onclick="checkId()">
	</c:if>
	<c:if test="${!exist}">
		${id}는 사용가능합니다.<br><br>
		<input type="button" value="사용" onclick="checkIdClose()">
	</c:if>
</form>
</body>
</html>