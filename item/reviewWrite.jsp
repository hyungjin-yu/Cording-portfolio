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
			alert("리뷰글이 작성되었습니다.");
			location.href= "../item/itemView.do?item_code=${item_code}";
		} else {
			alert("리뷰글 작성에 실패했습니다.");
			location.href= history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>