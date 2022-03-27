function checkBoardWrite() {
	// 제목 및 내용 입력검사
	var frm = document.form;

	if (!frm.subject.value) {
		alert("제목를 입력하세요.");
		frm.subject.focus();
	} else if (!frm.content.value) {
		alert("내용를 입력하세요.");
		frm.content.focus();
	} else {
		frm.submit();
	}
}

function checkBoardModify() {
	var form = document.boardModifyForm;
	
	if(!form.subject.value.trim()) {
		alert("제목을 입력하세요.");
		form.subject.focus();
	} else if(!form.content.value.trim()) {
		alert("내용을 입력하세요.");
		form.content.focus();
	} else {
		form.submit();
	}
}