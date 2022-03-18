function checkBoardWrite() {
	var form = document.boardWriteForm;
	
	if(!form.subject.value) {
		alert("제목을 입력하세요");
		form.subject.focus();
	} else if(!form.content.value) {
		alert("내용을 입력하세요");
		form.subject.focus();
	} else {
		form.submit();
	}
}