function check() {
	var f = document.frm;
	if (!f.book_num.value) {
		alert("도서코드를 입력하세요");
		f.book_num.focus();
	} else if(!f.book_name.value) {
		alert("도서명을 입력하세요");
		f.book_name.focus();
	}  else if (!f.book_writer.value) {
		alert("저자를 입력하세요");
		f.book_writer.focus();
	}  else {
		f.submit();
	}
}