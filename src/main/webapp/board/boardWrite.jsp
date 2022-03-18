<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	String id = (String)session.getAttribute("memId");
	String name = (String)session.getAttribute("memName");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	// DB처리
	BoardDTO dto = new BoardDTO();  
	
	dto.setId(id);
	dto.setName(name);
	dto.setSubject(subject);
	dto.setContent(content);
	
	BoardDAO dao = new BoardDAO();
	int result = dao.boardWrite(dto); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.onload = function() {
		if(<%=result > 0%>) {
			alert("글 등록 성공");
		} else {
			alert("글 등록 실패");
		}
		location.href = "boardList.jsp?pg=1";
	}
</script>
</head>
<body>
	
</body>
</html>