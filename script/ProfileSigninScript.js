function check() {	
	var frm = document.form;

	if (!frm.user_id.value) {
		alert("ID를 입력하세요.");
		frm.user_id.focus();
	} else if (!frm.user_password.value) {
		alert("비밀번호를 입력하세요.");
		frm.user_password.focus();
	} else {
		frm.submit();
	}
}