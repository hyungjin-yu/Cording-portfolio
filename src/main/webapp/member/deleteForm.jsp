<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		if(confirm("회원 탈퇴하시겠습니까?")) {
			location.href="delete.dp";
		} else {
			location.href="../main/index.do";
		}			
	}	
</script>
</head>
<body>

</body>
</html>