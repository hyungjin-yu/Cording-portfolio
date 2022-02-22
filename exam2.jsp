<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		frm = document.frm;
		
		if(!frm.x.value) {
			alert("x 값을 입력하세요.");
			frm.x.focus();
		} else if(!frm.y.value){
			alert("y 값을 입력하세요.");
			frm.y.focus();
		} else if(isNaN(frm.x.value)) {
			alert("x값을 숫자로 입력하세요.");
			frm.x.focus();
		} else if(isNaN(frm.y.value)) {
			alert("y값을 숫자로 입력하세요.");
			frm.y.focus();
		} else {
			frm.submit();
		}
	}
</script>
</head>
<body>
	<form action="exam2Pro.jsp" name="frm">
		X : <input type="text" name="x"><br>
		Y : <input type="text" name="y"><br>
		<input type="button" value="계산" onclick="check()">
		<input type="reset" value="취소">
	</form>
</body>
</html>