<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="3">
				<font size="5">${dto.subject}</font>
			</td>
			
		</tr>
		<tr align="center">
			<td width="150">글 번호 : ${dto.seq}</td>
			<td width="150">작성자 : ${dto.name}</td>
			<td width="150">조회수 : ${dto.hit}</td>
		</tr>
		<tr>
			<td colspan="3" height="200" valign="center"><pre>
				${dto.content}</pre></td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="location.href='boardList.do?pg=${pg}'">
	<c:if test="${memId == dto.id }">
		<input type="button" value="수정">
		<input type="button" value="삭제" onclick="location.href='boardDelete.do?pg=${pg}&seq=${seq}'">
	</c:if>
</body>
</html>