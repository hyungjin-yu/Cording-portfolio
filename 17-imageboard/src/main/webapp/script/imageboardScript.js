function doSubmit() {
   // 입력검사
   var frm = document.form;
   
   		if(!frm.imageId.value || frm.imageId.value == "img_") {
			alert("상품코드를 입력하세요.");
            frm.imageId.focus();
   		} else if(!frm.imageName.value){
            alert("상품명을 입력하세요.");
            frm.imageName.focus();
        } else if(!frm.imagePrice.value) {
            alert("단가를 입력하세요.");
            frm.imagePrice.focus();
        } else if(isNaN(frm.imagePrice.value)) {
            alert("단가를 숫자로 입력하세요.");
            frm.imagePrice.value = "";
            frm.imagePrice.focus();
        } else if(!frm.imageQty.value){
            alert("개수를 입력하세요.");
            frm.imageQty.focus();
        } else if(isNaN(frm.imageQty.value)){
            alert("개수를 숫자로 입력하세요.");
            frm.imageQty.value = "";
            frm.imageQty.focus();
        } else if(!frm.imageContent.value){
            alert("내용을 입력하세요.");
            frm.imageContent.focus();
        } else {
         frm.submit();
      }  
}

function Submit() {
   // 입력검사
   var frm = document.form;
   
   		if(!frm.imageId.value || frm.imageId.value == "img_") {
			alert("상품코드를 입력하세요.");
            frm.imageId.focus();
   		} else if(!frm.imageName.value){
            alert("상품명을 입력하세요.");
            frm.imageName.focus();
        } else if(!frm.imagePrice.value) {
            alert("단가를 입력하세요.");
            frm.imagePrice.focus();
        } else if(isNaN(frm.imagePrice.value)) {
            alert("단가를 숫자로 입력하세요.");
            frm.imagePrice.value = "";
            frm.imagePrice.focus();
        } else if(!frm.imageQty.value){
            alert("개수를 입력하세요.");
            frm.imageQty.focus();
        } else if(isNaN(frm.imageQty.value)){
            alert("개수를 숫자로 입력하세요.");
            frm.imageQty.value = "";
            frm.imageQty.focus();
        } else if(!frm.imageContent.value){
            alert("내용을 입력하세요.");
            frm.imageContent.focus();
        } else {
         frm.submit();
      }  
}