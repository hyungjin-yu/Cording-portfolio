<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){	
		var dialog = document.getElementById("myMsgDialog"); 
		dialog.showModal();	
	}
	
	function close_ok(){ 
		var dialog = document.getElementById("myMsgDialog"); 
		dialog.close(); 
		location.href="../main/index.jsp";
	} 
</script>
</head>
<body>
	<c:if test="${result > 0}">
		<dialog id="myMsgDialog"> 
			<h3>회원 탈퇴 성공</h3> 
			<input type="button" id="btn_ok" onclick="close_ok()" 
			value=" 확 인 " > 
		</dialog>
	</c:if>
	<c:if test="${result == 0}">
		<dialog id="myMsgDialog"> 
			<h3>회원 탈퇴 실패</h3> 
			<input type="button" id="btn_ok" onclick="close_ok()" 
			value=" 확 인 " > 
		</dialog>
	</c:if>
</body>
</html>