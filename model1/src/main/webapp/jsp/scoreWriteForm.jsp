<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../javascript/scoreScript.js"></script>
</head>
<body>
	<form action="scoreWrite.jsp" method="post" name="frm" >
		<table border="1">
			<tr>
				<td>학번</td>
				<td><input type="text" name="hak"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="stuname"></td>
			</tr>
			<tr>
				<td>국어</td>
				<td><input type="text" name="kor"></td>
			</tr>
			<tr>
				<td>영어</td>
				<td><input type="text" name="eng"></td>
			</tr>
			<tr>
				<td>수학</td>
				<td><input type="text" name="math"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="성적 입력" onclick="checkScoreWrite(); return false;">
					<input type="reset" value="다시 입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>