<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		if(${result > 0}) {
			alert("탈퇴 완료");
		} else {
			alert("탈퇴 실패");
		}
		// 메인 화면으로 이동
		location.href = "../main/index.do";
	}
</script>
</head>
<body>

</body>
</html>