<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${result > 0}) {
	   alert("삭제 성공");
	   location.href = "boardList.do?pg=${pg}";
	} else {
		alert("삭제 실패");
	    location.href = "boardView.do?seq=" + ${seq} + "&pg=" + ${pg};
	}
</script>
</head>
<body>
	
</body>
</html>