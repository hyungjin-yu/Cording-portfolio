<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int seq = (int) session.getAttribute("seq");
	int pg = (int) session.getAttribute("pg");
	
	// db
	BoardDAO dao = new BoardDAO();
	int result = dao.boardDelete(seq);
	
	String id = (String) session.getAttribute("id");
	String subject = (String) session.getAttribute("subject");
	String name = (String) session.getAttribute("name");
	String content = (String) session.getAttribute("content");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   <% if(result > 0) { %> 
      alert("삭제 성공");
      location.href = "boardList.jsp?pg=<%=pg%>";
   <% } else { %>
      alert("삭제 실패");
      location.href = "boardView.jsp?seq=" + <%=seq%> + "&pg=" + <%=pg%>;
   <% } %>
</script>
</head>
<body>
	
</body>
</html>