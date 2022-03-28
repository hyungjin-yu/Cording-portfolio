<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 등록</title>
</head>
<body>
	 <h3>이미지 등록</h3>
	 <form action="imageboardWrite" method="post" enctype="multipart/form-data">
	 	<table border="1">
	 		<tr>
	 			<th>상품 코드</th>
	 			<td><input type="test" name="imageId" value="img_" size="40"></td>
	 		</tr>
	 		<tr>
	 			<th>상품명</th>
	 			<td><input type="text" name="imageName" size="40"></td>
	 		</tr>
	 		<tr>
	 			<th>단가</th>
	 			<td><input type="text" name="imagePrice" size="40"></td>
	 		</tr>
	 		<tr>
	 			<th>개수</th>
	 			<td><input type="text" name="imageQty" size="40"></td>
	 		</tr>
	 		<tr>
	 			<th>내용</th>
	 			<td><textarea rows="15" cols="40" name="imageContent" ></textarea></td>
	 		</tr>
	 		<tr>
	 			<td colspan="2">
	 				<input type="file" name="image1" size="45">
	 			</td>
	 		</tr>
	 		<tr>
	 			<td colspan="2" align="center">
	 				<input type="submit" value="이미지 등록">
	 				<input type="reset" value="다시 작성">
	 			</td>
	 		</tr>
	 	</table>
	 </form>
</body>
</html>