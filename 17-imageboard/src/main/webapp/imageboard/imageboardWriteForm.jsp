<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/imageboardScript.js"></script>
</head>
<body>
	<form action="../imageboard/imageboardWrite.jsp" method="post" name="form" enctype="multipart/form-data">
		<h3>이미지 등록</h3>
		<table border="1" width="480">
			<tr>
				<th width="100">상품코드</th>
				<td><input type="text" name="imageId" value="img_" size="50"></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="imageName" size="50"></td>
			</tr>
			<tr>
				<th>단가</th>
				<td><input type="text" name="imagePrice" size="50"></td>
			</tr>
			<tr>
				<th>개수</th>
				<td><input type="text" name="imageQty" size="50"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="imageContent" rows="10" cols="53"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="image1" size="50"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="이미지 등록" onclick="doSubmit(); return false;">
					<input type="reset" value="다시 작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>