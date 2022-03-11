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
		if(${result > 0}) {			
			alert('등록 성공')
		} else {
			alert('등록 실패')
		}
	}	
</script>
</head>
<body>
	<c:if test="${result > 0}">
		등록 성공
	</c:if>
	
	<c:if test="${result == 0}">
		등록 실패
	</c:if>
</body>
</html>