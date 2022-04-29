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
		var dialog = document.getElementById("write_dialog");
		dialog.showModal();
	}
	function close_ok() {
		var dialog = document.getElementById("write_dialog");
		dialog.close();
		location.href = "noticeList.do";
	}
</script>
</head>
<body>
	<dialog id="write_dialog" align="center">
		<c:if test="${result > 0 }">
			<p>최근 공지를 삭제했습니다.</p>
		</c:if>
		<c:if test="${!(result > 0)}">
			<p>최근 공지를 삭제하지 못했습니다.</p>
		</c:if>
		<input type="button" id="btn_ok" value="확인" onclick="close_ok()">
	</dialog>
</body>
</html>