<%@page import="member.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB 작업
	BoardDAO dao = new BoardDAO();
	int result = dao.boardDelete(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	<%--if(<%=result > 0%>) {} --%>	// 이것이 자바스크립트의 if문
	
	<% if(result > 0) { %>	// 이번 경우는 자바의 if문
		alert("삭제 성공");
		location.href = "boardList.jsp?pg=<%=pg %>";
	<% } else { %>
		alert("삭제 실패");
		location.href = "boardview.jsp?seq=" + <%=seq%> + "&pg=" + <%=pg%>;
	<% } %>
</script>
</head>
<body>
	
</body>
</html>