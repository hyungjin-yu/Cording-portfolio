function check() {	
	var frm = document.form;

	if (!frm.user_name.value) {
		alert("이름을 입력하세요.");
		frm.user_name.focus();
	} else if (!frm.user_id.value) {
		alert("ID를 입력하세요.");
		frm.user_id.focus();
	} else if (!frm.user_email.value) {
		alert("이메일을 입력하세요.");
		frm.user_email.focus();
	} else {
		frm.submit();
	}
}