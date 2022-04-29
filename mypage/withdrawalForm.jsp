<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var dialog = document.getElementById("myMsgDialog"); 
		dialog.showModal();
	}
	
	function close_ok(){ 
		var dialog = document.getElementById("myMsgDialog"); 
		dialog.close(); 
		location.href="withdrawal.do";
	} 
	function close_cancel(){ 
		var dialog = document.getElementById("myMsgDialog"); 
		dialog.close(); 
		location.href="mypageForm.do";
	}
</script>
</head>
<body>
	<dialog id="myMsgDialog"> 
		<h3>NAW 회원 탈퇴</h3>
	<div>
		NAW 회원 탈퇴를 진행하시겠습니까?<br>
		<br> NAW 회원 탈퇴를 진행하실 경우, <br>
		<br> 1. NAW 패션, 슈즈, 악세사리 등의 오프라인 구매 이력 <br>
		<br> 2. NAW 패션, 슈즈, 악세사리 등의 오프라인 및 온라인 회원 정보 및 구매 정보 등 모든 정보가 삭제되며 또한 한번 삭제된 정보는
		절대 복구하실 수 없습니다. *진행 중인 NAW.com의 패션, 슈즈, 악세사리의 애프터서비스, 제품 예약 그리고 미사용 디파짓 등의 현황이 있으실 경우 회원 탈퇴 시 정상적인 서비스를 받을
		수 없게 되오니, 고객 케어 센터를 통해 확인 및 삭제를 진행해 주십시오. <br>
		<br> NAW 회원 탈퇴를 진행하시겠습니까? 
	</div>
		<input type="button" id="btn_ok" onclick="close_ok()" 
			value=" 탈 퇴" > 
		<input type="button" id="btn_cancel" onclick="close_cancel()" 
			value=" 취 소 " >
	</dialog>
</body>
</html>