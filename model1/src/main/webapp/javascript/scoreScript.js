function checkScoreWrite() {
   // 제목 및 내용 입력검사
   var frm = document.frm;
   
   		if(!frm.hak.value){
            alert("학번을 입력하세요.");
            frm.hak.focus();
        } else if(!frm.stuname.value){
            alert("이름을 입력하세요.");
            frm.stuname.focus();
        } else if(frm.hak.value != null && frm.stuname.value != null && !frm.kor.value && !frm.eng.value && !frm.math.value){
			location.href="../jsp/scoreList.jsp?pg=1";
		} else {
         frm.submit();
      }  
}

