<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="400">
		<tr>	
			<th width="130">표현식</th>
			<th width="130">값</th>
			<th width="130">jsp 표현식</th>
		</tr>
		<tr align="center">
			<td>\${25+36}</td>
			<td>${25+36}</td>
			<td><%=25+36 %></td>
		</tr>
		<tr align="center">
			<td>\${25/36}</td>
			<td>${25/36}</td>
			<td><%=25/36 %></td>
		</tr>
		<tr align="center">
			<td>\${25%36}</td>
			<td>${25%36}</td>
			<td><%=25%36 %></td>
		</tr>
		<tr align="center">
			<td>\${25>36}</td>
			<td>${25>36}</td>
			<td><%=25>36 %></td>
		</tr>
		<tr align="center">
			<td>\${header.host}</td>
			<td>${header.host}</td>
			<td><%=request.getHeader("host") %></td>
		</tr>
		<tr align="center">
			<td>\${header['host']}</td>
			<td>${header['host']}</td>
			<td><%=request.getHeader("host") %></td>
		</tr>
	</table>
</body>
</html>