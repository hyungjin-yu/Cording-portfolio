<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/adminBody.css">
<style type="text/css">
#admin_notice_button, 
#admin_item_button, 
#admin_member_button, 
#admin_sales_button {
	background-color: black;
	color: white;
}
</style>
</head>
<body>
<div id="admin_body_wrap">
	<div id="admin_body_wrap_inner">
		<div id="admin_body_label_div">
			Admin Page
		</div>
		
		<div id="admin_body_button_wrap_div">
			<div id="admin_body_button_wrap_inner_div">
				<div class="admin_body_button_div">
					<button type="button" id="admin_notice_button" 
							onclick="location.href='../notice/noticeList.do'">공지 관리</button>
				</div>
				<div class="admin_body_button_div">
					<button type="button" id="admin_item_button" 
							onclick="location.href='../admin/itemWriteForm.do'">상품 등록</button>
				</div>
				<div class="admin_body_button_div">
					<button type="button" id="admin_member_button"
							onclick="location.href='../member/memberList.do'">회원 관리</button>
				</div>
				<div class="admin_body_button_div">
					<button type="button" id="admin_sales_button" 
							onclick="location.href='../sales/salesList.do'">매출 관리</button>
				</div>
			</div>
		</div>
	
		
	</div>
</div>
</body>
</html>