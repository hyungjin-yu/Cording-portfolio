<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="3">${dto.subject}</td>
		</tr>
		<tr>
			<td width="150">글번호 : ${dto.seq}</td>	<!-- seq오류나면 dto.지워보기 -->
			<td width="150">작성자 : ${dto.name}</td>
			<td width="150">조회수 : ${dto.hit}</td>
		</tr>
		<tr>
			<td colspan="3" height="200" valign="top"><pre>${dto.content}</pre></td>
		</tr>
	</table>
	
	<input type="button" value="목록" onclick="location.href='boardList.do?pg=${pg}'">
	
	<!-- 글수정, 글삭제 버튼은 글쓴이에게만 표시함 -->
	<c:if test="${memId == dto.id }">
		<input type="button" value="글수정" 
		onclick="location.href='boardModifyForm.do?seq=${seq}&pg=${pg}'">
		<input type="button" value="글삭제" 
		onclick="location.href='boardDelete.do?seq=${seq}&pg=${pg}">
	</c:if>
</body>
</html>