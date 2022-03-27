<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js"></script>
<style>
	table {
		width: 500px;
	}
	
	table tr td:nth-child(1) {
		text-align: center;
		width: 15%;
	}
	
	input[name=subject] {
		width: 98%;
	}
	
	textarea {
		width: 98%;
		height: 300px;
		resize: none;
	}
</style>
</head>
<body>
	<form action="boardModify.do" method="post" name="boardModifyForm" 
		onsubmit="checkBoardModify(); return false;">
		<input type="hidden" name="seq" value="${seq}">
		<input type="hidden" name="pg" value="${pg }">
		
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="${dto.subject}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content">${dto.content}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기">
					<input type="reset" value="리셋">
					<input type="button" value="취소" onclick="location.href='boardView.do?seq=${seq}&pg=${pg}'">
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>