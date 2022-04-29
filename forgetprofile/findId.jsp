<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){	
		if(${user_id != null}) {
			alert("[NAW] 고객님의 아이디는 ${user_id}입니다.");
			location.href="../signin/profileMain.do";
		} else {
			alert("[NAW] 입력하신 정보가 일치하지 않습니다. 재확인바랍니다.");
			history.back();
		}
	}
</script>
<body>
	
</body>
</html>