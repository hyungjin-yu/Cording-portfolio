<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	window.onload = function() {
		if(${result > 0}) {
			alert("비밀번호 변경이 완료되었습니다.");
			location.href="../main/index.jsp";
		} else {
			alert("비밀번호 변경에 실패하였습니다. 재확인바랍니다.");
			history.back();
		}
	}
</script>
</head>
<body>
</body>
</html>