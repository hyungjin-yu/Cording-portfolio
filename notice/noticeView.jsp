<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#notice_view {
	width: 100%;
	height: 600px;
	display: inline-flex;
    justify-content: center;
    margin-bottom: 50px;
}
#notice_view_inner {
	width: 50%;
	height: 399px;
	border-collapse: collapse;
}
#notice_view_label_div {
	width: 100%;
	height: 40px;
	font-size: 50px;
	display: inline-table;
	margin-top: 25px;
	margin-bottom: 25px;
}
#notice_view_title_date_div {
	width: 100%;
	height: 40px;
    border-top: 1px solid #767677;
	border-bottom: 1px solid #767677;
}
#notice_view_title_div {
	width: 70%;
	height: 100%;
	display: inline-flex;
	align-items: center;
	padding-left: 15px;
}
#notice_view_date_div {
	display: inline;
	padding-right: 15px;
}
#notice_view_content_div {
	width: 100%;
	height: 350px;
	text-align: center;
	padding-top: 20px;
	padding-bottom: 20px;
}
#notice_view_buttons_div {
	width: 100%;
	display: inline-flex;
	justify-content: center;
}
#notice_view_buttons_div > button {
	width: 120px;
	height: 40px;
	border: 1px solid black;
	font-weight: bold;
	margin-left: 5px;
	margin-right: 5px;
}
#notice_modify_button {
	background-color: black;
	color: white;
}
#notice_delete_button {
	background-color: white;
	color: black;
}
#notice_modify_button:hover, 
#notice_delete_button:hover {
	color: #767677;
	border: 1px solid #767677;
	cursor: pointer;
}

</style>
</head>
<body>
	<div id="notice_view">
		<div id="notice_view_inner">
			<!-- view latest notice -->
			
			<div id="notice_view_label_div">
				Notice
			</div>
			
			<div id="notice_view_title_date_div">
				<div id="notice_view_title_div">
					${dto.notice_title }
				</div>
				<div id="notice_view_date_div">
					${dto.notice_date }
				</div>
			</div>
			
			<div id="notice_view_content_div">
				${dto.notice_content }
			</div>
			
			<c:if test="${adminId != null }">
				<div id="notice_view_buttons_div">
					<button id="notice_modify_button">공지 수정</button>
					<button id="notice_delete_button">공지 삭제</button>
				</div>
			</c:if>
			
		</div>
	</div>
</body>
</html>