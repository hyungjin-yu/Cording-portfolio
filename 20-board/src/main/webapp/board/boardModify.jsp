<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	width:400px;
	height:800px
}
.sub {
	text-align: left;
	background-color: orange;
	width: 100px;
}
.content {
	background-color: skyblue;
}
</style>
<script type="text/javascript">
	function modifyCheck() {
		var frm = document.frm;
		
		if(!frm.board_name.value) {
			alert("이름을 입력하세요.");
			frm.board_name.focus();
		} else if(!frm.board_pass.value) {
			alert("비밀번호를 입력하세요.");
			frm.board_pass.focus();
		} else if(!frm.board_subject.value) {
			alert("제목을 입력하세요.");
			frm.board_subject.focus();
		} else if(!frm.board_content.value) {
			alert("내용을 입력하세요.");
			frm.board_content.focus();
		} else {
			frm.submit();
		}
	}
</script>
</head>
<body>
<form action="boardModifyPro.do" method="post" name="frm"> 
		<input type="hidden" name="board_num" value="${bean.board_num }">
		<input type="hidden" name="pg" value="${pg }">
			<table>
				<tr>
					<td class="sub">글쓴이</td>
					<td class="content"><input type="text" name="board_name" value="${bean.board_name }"></td>
				</tr>
				<tr>
					<td class="sub">비밀번호</td>
					<td class="content" ><input type="password" name="board_pass"></td>
				</tr>
				<tr>
					<td class="sub">제목</td>
					<td class="content" ><input type="text" name="board_subject" value="${bean.board_subject }"></td>
				</tr>
				<tr>
					<td class="sub">내용</td>
					<td class="content"><textarea rows=15" cols="40"  name="board_content">${bean.board_content }</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="button" value="수정" onclick="modifyCheck(); return false;">
					<input type="reset" value="다시 쓰기" onclick="history.back()">
					</td>
				</tr>
			</table>
	</form>
</body>
</html>