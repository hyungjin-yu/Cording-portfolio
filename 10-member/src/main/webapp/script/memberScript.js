// 아이디 입력창 띄우기
function checkId() {
	var sId = document.frm.id.value;
	
	if(sId == "") {
		alert("먼저 아이디를 입력해주세요.");
		document.frm.id.focus();
	} else {
		// 브라우저창 열기
		window.open("checkId.jsp?id="+sId, "", "width=350 height=100 left=500 top=200");
	}
}

 // 로그인 화면에서 입력 검사
function checklLogin() {
	 //alert("test2"); 
     var f = document.form1;
     if(!f.id.value) {
		alert("아이디를 입력하세요");
		f.id.focus();
	} else if(!f.pwd.value) {
		alert("비밀번호를 입력하세요");
		f.pwd.focus();
	} else {
		f.submit();
	}
}

function move_writeForm() {
	//alert("test");
	location.href="../member/writeForm.jsp";
}
 
  function check(){
        let name = document.getElementById("name");
        let id = document.getElementById("id");
        let pwd = document.getElementById("pass");
        let re = document.getElementById("re");
        let form = document.getElementById("form");

        if(name.value == ""){
            alert("이름을 입력하세요");
            name.focus();
            return false;
        } else if(id.value == ""){
            alert("아이디를 입력하세요.");
            id.focus();
            return false;
        } else if(pwd.value == ""){
            alert("비밀번호를 입력하세요.");
            pw.focus();
            return false;
        } else if(repwd.value == ""){
            alert("비밀번호 재확인을 입력하세요.");
     		repwd.focus();
            return false;
        } else if(pwd.value != repwd.value){
            alert("비밀번호를 재확인하세요");
            pwd.focus();
            return false;
        }
        form.submit();
    }
