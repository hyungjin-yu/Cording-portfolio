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
			alert("선택하신 상품을 삭제했습니다.");
			location.href= "../item/cartList.do";
		} else {
			alert("삭제에 실패했습니다.");
			location.href= history.back();
		}
	}
</script>
</head>
<body>
	
</body>
</html>