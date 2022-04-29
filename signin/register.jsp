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
			alert("Welcome ! Naw 멤버가 되신 것을 환영합니다 !");
			location.href="../signin/profileMain.do";
		} else {
			alert("회원가입에 실패하였습니다. 재확인바랍니다.");
			location.href="javascript:history.go(-1);";
		}
	}
</script>
</head>
<body>

</body>
</html>