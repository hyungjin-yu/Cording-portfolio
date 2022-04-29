function checkItemWrite() {
	// 제목 및 내용 입력검사
	var frm = document.itemWriteForm;

	if (!frm.item_code.value) {
		alert("상품코드를 입력하세요.");
		frm.item_code.focus();
	} else if (!frm.item_category1.value) {
		alert("카테고리를 선택하세요.");
		frm.item_category1.focus();
	} else if (!frm.item_category2.value) {
		alert("카테고리를 선택하세요.");
		frm.item_category2.focus();
	} else if (!frm.item_category3.value) {
		alert("카테고리를 선택하세요.");
		frm.item_category3.focus();
	} else if (!frm.item_name.value) {
		alert("상품이름을 입력하세요.");
		frm.item_name.focus();
	} else if (!frm.item_color.value) {
		alert("상품색상을 입력하세요.");
		frm.item_color.focus();
	} else if (!frm.item_size.value) {
		alert("상품사이즈를 입력하세요.");
		frm.item_size.focus();
	} else if (!frm.item_price.value) {
		alert("상품가격을 입력하세요.");
		frm.item_price.focus();
	} else if (!frm.cart_qty.value) {
		alert("상품수량을 입력하세요.");
		frm.cart_qty.focus();
	} else if (!frm.item_details.value) {
		alert("상품설명을 입력하세요.");
		frm.item_details.focus();
	} else if (!frm.item_image1.value) {
		alert("상품의 메인이미지를 선택하세요.");
		frm.item_image1.focus();
	} else {
		frm.submit();
	}
}

function checkItemModify() {
	var frm = document.itemModifyForm;
	
	if (!frm.item_code.value) {
		alert("상품코드를 입력하세요.");
		frm.item_code.focus();
	} else if (!frm.item_category1.value) {
		alert("카테고리1을 선택하세요.");
		frm.item_category1.focus();
	} else if (!frm.item_category2.value) {
		alert("카테고리2를 선택하세요.");
		frm.item_category2.focus();
	} else if (!frm.item_category3.value) {
		alert("카테고리3을 선택하세요.");
		frm.item_category3.focus();
	} else if (!frm.item_name.value) {
		alert("상품이름을 입력하세요.");
		frm.item_name.focus();
	} else if (!frm.item_color.value) {
		alert("상품색상을 입력하세요.");
		frm.item_color.focus();
	} else if (!frm.item_size.value) {
		alert("상품사이즈를 입력하세요.");
		frm.item_size.focus();
	} else if (!frm.item_price.value) {
		alert("상품가격을 입력하세요.");
		frm.item_price.focus();
	} else if (!frm.cart_qty.value) {
		alert("상품수량을 입력하세요.");
		frm.cart_qty.focus();
	} else if (!frm.item_details.value) {
		alert("상품설명을 입력하세요.");
		frm.item_details.focus();
	} else if (!frm.item_image1.value) {
		alert("상품의 메인이미지를 선택하세요.");
		frm.item_image1.focus();
	} else {
		frm.submit();
	}
}