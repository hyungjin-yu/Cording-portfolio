function checkBoardWrite() {
   // 제목 및 내용 입력검사
   var frm = document.form;
   
   		if(!frm.subject.value){
            alert("제목를 입력하세요.");
            frm.subject.focus();
        } else if(!frm.content.value){
            alert("내용를 입력하세요.");
            frm.content.focus();
        } else {
         frm.submit();
      }  
   
}

function checkBoardModify() {
	var frm = document.form;
	
		if(!frm.subject.value){
            alert("제목를 입력하세요.");
            frm.subject.focus();
        } else if(!frm.content.value){
            alert("내용를 입력하세요.");
            frm.content.focus();
        } else {
         frm.submit();
      }  
}