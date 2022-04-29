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
			alert("답글을 등록했습니다.");
			location.href= "../item/inquiryList.do?pg=${pg}&inquiry_code=${inquiry_code}";
		} else {
			alert("답글 등록에 실패했습니다.");
			location.href= history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>