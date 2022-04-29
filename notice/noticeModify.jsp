<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		if(${result > 0}) {
			alert("공지를 수정했습니다.");
			location.href="../notice/noticeList.do";
		} else {
			alert("공지를 수정하지 못하였습니다.");
			location.href= history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>