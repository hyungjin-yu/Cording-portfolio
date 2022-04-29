function checkNoticeWrite() {
	// 공지 제목 및 내용 입력검사
	var frm = document.noticeWriteForm;

	if (!frm.notice_title.value) {
		alert("공지 제목을 입력하세요.");
		frm.notice_title.focus();
	} else if (!frm.notice_content.value) {
		alert("공지 내용을 입력하세요.");
		frm.notice_content.focus();
	} else {
		frm.submit();
	}
}

function checkNoticeModify() {
	var form = document.noticeModifyForm;
	
	if(!form.notice_title.value.trim()) {
		alert("공지 제목을 입력하세요.");
		form.notice_title.focus();
	} else if(!form.notice_content.value.trim()) {
		alert("공지 내용을 입력하세요.");
		form.notice_content.focus();
	} else {
		form.submit();
	}
}