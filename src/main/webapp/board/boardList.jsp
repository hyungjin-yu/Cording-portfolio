<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int pg = 1;
	if(request.getParameter("pg") != null)
	pg = Integer.parseInt(request.getParameter("pg"));
	
	String id = (String) session.getAttribute("id");
	
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	BoardDAO dao = new BoardDAO();
	List<BoardDTO> list = dao.boardList(startNum, endNum);
	
	int totalA = dao.getTotalA();
	int totalP = (totalA + 4) / 5;
	
	int startPage = (pg-1) / 3*3 + 1;
	int endPage = startPage + 2;
	
	if(endPage > totalP) endPage = totalP;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function isLogin(seq) {
		if(<%=session.getAttribute("memId") == null%>) {
			alert("로그인을 해야 볼 수 있습니다.");
		} else {
			location.href="boardView.jsp?seq=" + seq + "&pg=" + <%=pg%>;
		}
	}
</script>
</head>
<body>
<div style="width: 700px;">
	
		<table border="1">
			<tr id="title">
				<th id="titleNo">글번호</th>
				<th id="titleSub">제목</th>
				<th id="titleName">작성자</th>
				<th id="titleDate">작성일</th>
				<th id="titleHit">조회수</th>
			</tr>
			
			<%for(BoardDTO dto : list) { %>
			<tr>
				<td><%=dto.getSeq() %></td>
				<td><a href="boardView.jsp?seq=<%=dto.getSeq()%>&pg=<%=pg%>" onclick="isLogin(<%=dto.getSeq()%>)"><%=dto.getSubject() %></a></td>
				<td><%=dto.getName() %></td>
				<td><%=dto.getLogtime() %></td>
				<td><%=dto.getHit() %></td>
			</tr>
			<%} %>
		</table>
	
	<div style="text-align: center;">
		<% if(startPage > 3) { %>
			[<a class="paging" href="boardList.jsp?pg=<%=startPage-1%>">이전</a>]
		<% } %>
		
		<% for(int i=startPage; i<=endPage; i++) {%>
			<% if(pg == i) {%>
				[<a class="currentPaging" href="boardList.jsp?pg=<%=i %>"><%=i%></a>]
			<%} else { %>
				[<a class="paging" href="boardList.jsp?pg=<%=i %>"><%=i%></a>]
			<% } %>
		<% } %>
			
		<% if(endPage < totalP) {%>
			[<a class="paging" href="boardList.jsp?pg=<%=endPage+1%>">다음</a>]
		<% } %>
	</div>
</div>
</body>
</html>