<%@page import="member.bean.BoardDTO"%>
<%@page import="member.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// DB
	BoardDAO dao = new BoardDAO();
	// 조회수 증가하기
	dao.updateHit(seq);
	// 상세보기용 1줄 데이터 얻어오기
	BoardDTO dto = dao.boardView(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="3"><%=dto.getSubject() %></td>
		</tr>
		<tr>
			<td width="150">글 번호 : <%=dto.getSeq() %></td>
			<td width="150">작성자 : <%=dto.getName() %></td>
			<td width="150">조회수 : <%=dto.getHit() %></td>
		</tr>
		<tr>
			<td colspan="3" height="200" valign="top"><pre><%=dto.getContent() %></pre></td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg %>'">
	<!-- 글 수정, 글 삭제 버튼은 글쓴이에게만 표시함 -->
	<% if(session.getAttribute("memID").equals(dto.getId())) { %>
	<input type="button" value="글 수정" onclick="">
	<input type="button" value="글삭제" onclick="location.href='boardDelete.jsp?seq=' + <%=seq%> + '&pg=' + <%=pg%>">
	<% } %>
</body>
</html>