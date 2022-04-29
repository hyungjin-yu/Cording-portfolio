<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		if(${result > 0}) {
			alert("결제가 정상적으로 완료되었습니다.");
			location.href="../main/index.jsp";
		} else {
			alert("결제에 실패했습니다.");
			history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>