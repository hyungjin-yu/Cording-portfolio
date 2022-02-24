<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function () {
		if(${result > 0 }) {
			alert("삭제 성공");
			location.href = "../imageboard/imageboardList.jsp?pg=" + ${pg};
		} else {
			alert("삭제 실패");
			location.href = "../imageboard/imageboardView.jsp?seq=" + ${seq} + "&pg=" + ${pg};
		}
	}
</script>
</head>
<body>
	<c:if test="${result > 0 }">
		삭제 성공
	</c:if>
	<c:if test="${result == 0 }">
		삭제 실패
	</c:if>
</body>
</html>