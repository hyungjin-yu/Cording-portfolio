<%@page import="member.dao.BoardDAO"%>
<%@page import="member.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
		
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	//세션에 저장된 데이터 받기
	String name = (String)session.getAttribute("memName");
	String id = (String)session.getAttribute("memID");
	
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
	window.onload = functon() {
		if(<%=result > 0 %>) {
			alert("작성하신 글을 저장하였습니다.");
		} else {
			alert("작성하신 글을 저장하지 못했습니다.");
		}
		location.href = "boardList.jsp?pg=1";
	}
</script>
</head>
<body>
	<%if(result>0) { %>
		<p>작성하신 글을 저장하였습니다.</p>
	<%} else { %>
		<p>작성하신 글을 저장하는데 실패하였습니다.</p>
	<%} %>
	<%-- 
	글쓴이 : <%=name %><br>
	제목 : <%=subject %><br>
	내용 : <%=content %><br>
	--%>
</body>
</html>