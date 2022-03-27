// modifyForm 입력 검사
function checkModify(){        
        var form = document.frm;

        if(form.pwd.value == ""){
            alert("변경할 비밀번호를 입력하세요.");
            form.pwd.focus();           
        } else if(form.repwd.value == ""){
            alert("변경할 비밀번호 재확인을 입력하세요.");
     		form.repwd.focus();
        } else if(form.pwd.value != form.repwd.value){
            alert("비밀번호를 재확인하세요");
            form.pwd.focus();
        } else if(form.email1.value == ""){
            alert("변경할 이메일을 입력하세요");
            form.email1.focus();
        } else if(form.email2.value == ""){
            alert("변경할 이메일를 입력하세요.");
            form.email2.focus();
        } else if(form.tel1.value == ""){
            alert("변경할 전화번호를 입력하세요.");
            form.tel1.focus();
        } else if(form.tel2.value == ""){
            alert("변경할 전화번호를 입력하세요.");
            form.tel2.focus();
        } else if(form.tel3.value == ""){
            alert("변경할 전화번호를 입력하세요.");
            form.tel3.focus();
        } else if(form.addr.value == "") {
            alert("변경할 주소를 입력하세요.");
            form.addr.focus();
        } else {
			form.submit();
		}        
}

// 아이디 입력창 띄우기
function checkId() {
	var sId = document.frm.id.value;
	
	if(sId == "") {
		alert("먼저 아이디를 입력하세요.");
		document.frm.id.focus();
	} else {
		// 브라우저창 열기
		window.open("checkId.jsp?id="+sId, "", "width=450 height=100 left=500 top=200")
	}
}

// 로그인 화면에서 입력 검사
function checkLogin(){
	var f = document.form1;
	if(!f.id.value){
		alert("아이디를 입력하세요");
		f.id.focus();
	} else if(!f.pwd.value){
		alert("비밀번호를 입력하세요");
		f.pwd.focus();
	} else {
		f.submit();
	}	
	//return false;  // submit 무효화
}

function move_writeForm() {
	//alert("test2");	
	location.href = "../member/writeForm.jsp";
}

function check(){
        let name = document.getElementById("name");
        let id = document.getElementById("id");
        let pwd = document.getElementById("pwd");
        let repwd = document.getElementById("repwd");
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
            pwd.focus();
            return false;
        } else if(repwd.value == ""){
            alert("비밀번호 재확인을 입력하세요.");
            repwd.focus();
            return false;
        } else if(pwd.value != repwd.value){
            alert("비밀번호를 재확인하세요");
            return false;
        } else {
			form.submit();
		}       
}

function check3(){
		var frm = document.frm;

        if(!frm.name.value){
            alert("이름을 입력하세요");
            frm.name.focus();
            return false;
        } else if(!frm.id.value){
            alert("아이디를 입력하세요.");
            frm.id.focus();
            return false;
        } else if(!frm.pwd.value){
            alert("비밀번호를 입력하세요.");
            frm.pwd.focus();
            return false;
        } else if(!frm.repwd.value){
            alert("비밀번호 재확인을 입력하세요.");
            frm.repwd.focus();
            return false;
        } else if(frm.pwd.value != frm.repwd.value){
            alert("비밀번호를 재확인하세요");
            return false;
        } else {
			frm.submit();
		}        
}
