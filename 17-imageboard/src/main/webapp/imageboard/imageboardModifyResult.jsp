<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		if(${result > 0 }) {
			alert("작성하신 글을 수정하였습니다.");
		} else {
			alert("작성하신 글을 수정하지 못했습니다.");
		}
		location.href = "../imageboard/imageboardListResult.jsp?seq=" + ${seq } + "&pg=" + ${pg };
	}
</script>
</head>
<body>
	<c:if test="${result > 0 }">
		수정성공
	</c:if>
	<c:if test="${result == 0 }">
		수정실패
	</c:if>
</body>
</html>