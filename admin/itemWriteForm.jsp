<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/adminBody.css">
<link rel="stylesheet" href="../css/itemWriteForm.css">
<style type="text/css">
#admin_item_button {
	background-color: black;
	color: white;
}
#admin_notice_button, 
#admin_member_button, 
#admin_sales_button {
	background-color: white;
	color: black;
}
</style>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../script/itemWriteScript.js?v=1"></script>
<script type="text/javascript">
$(function(){
	$("#category1").load("../ajax/item-category-data.html #category1-1", function(){
		$(this).show();
	});
	
	$(document).on("change", "#category1 > select", function(){
		$("#category2").empty().hide();
		$("#category3").empty().hide();
		
		var target = $(this).find("option:selected").attr("data-target");
		var selector = "../ajax/item-category-data.html " + target;
		
		$("#category2").load(selector, function() {
			$(this).show();
		});
	});
	
	$(document).on("change", "#category2 > select", function(){
		$("#category3").empty().hide();
		
		var target = $(this).find("option:selected").attr("data-target");
		var selector = "../ajax/item-category-data.html " + target;
		
		$("#category3").load(selector, function() {
			$(this).show();
		});
	});
	
	$(document).on("change", "#category3 > select", function(){
		if($(this).find("option:selected").index() > 0) {
			var data1 = $("#category1 > select > option:selected").val();
			var data2 = $("#category2 > select > option:selected").val();
			var data3 = $("#category3 > select > option:selected").val();
			
			$("#item_category1_hidden").attr('value', data1);
			$("#item_category2_hidden").attr('value', data2);
			$("#item_category3_hidden").attr('value', data3);
			
		}
	});
	
	
	// file upload
	$("#item_image_file1").on('change',function(){
		var fileName1 = $("#item_image_file1").val();
		$("#item_image1_upload_name").val(fileName1);
	});
	
	$("#item_image_file2").on('change',function(){
		var fileName2 = $("#item_image_file2").val();
		$("#item_image2_upload_name").val(fileName2);
	});
	
});
</script>
</head>
<body>
	<!------------ admin menu ------------>
	<jsp:include page="adminMenu.jsp"/>
	
	<div id="item_write_wrap">
		<div id="item_write_wrap_inner">
			<div id="item_write_label_div">
				New Item
			</div>
			
			<form action="../admin/itemWrite.do" method="post" enctype="multipart/form-data" 
					name="itemWriteForm" onsubmit="checkItemWrite(); return false;">
				<div class="item_write_field">
					<input type="text" name="item_code" placeholder="상품번호">
					<div class="item_write_field_msg" id="item_code_msg"></div>
				</div>
			
				<div class="item_write_field" id="item_category1_div">
					<div id="category1"></div>
					<input type="hidden" id="item_category1_hidden" name="item_category1">
					<div class="item_write_field_msg" id="item_category1_msg"></div>
				</div>
				
				<div class="item_write_field" id="item_category2_div">
					<div id="category2"></div>
					<input type="hidden" id="item_category2_hidden" name="item_category2">
					<div class="item_write_field_msg" id="item_category2_msg"></div>
				</div>
				
				<div class="item_write_field" id="item_category3_div">
					<div id="category3"></div>
					<input type="hidden" id="item_category3_hidden" name="item_category3">
					<div class="item_write_field_msg" id="item_category3_msg"></div>
				</div>
			
				<div class="item_write_field">
					<input type="text" name="item_name" placeholder="이름">
					<div class="item_write_field_msg" id="item_name_msg"></div>
				</div>
			
				<div class="item_write_field">
					<input type="text" name="item_color" placeholder="색상">
					<div class="item_write_field_msg" id="item_color_msg"></div>
				</div>
			
				<div class="item_write_field">
					<input type="text" name="item_size" placeholder="사이즈">
					<div class="item_write_field_msg" id="item_size_msg"></div>
				</div>
			
				<div class="item_write_field">
					<input type="text" name="item_price" placeholder="가격">
					<div class="item_write_field_msg" id="item_price_msg"></div>
				</div>
				
				<div class="item_write_field">
					<input type="text" name="cart_qty" placeholder="수량">
					<div class="item_write_field_msg" id="cart_qty_msg"></div>
				</div>
			
				<div class="item_write_field_details">
					<textarea name="item_details" placeholder="설명"></textarea>
					<div class="item_write_field_msg" id="item_details_msg"></div>
				</div>
				
				<div class="item_write_field item_image_field">
					<div class="item_image_upload_name_div">
						<input class="item_image_upload_name" id="item_image1_upload_name" placeholder="메인 이미지" readonly>
					</div>
					<div class="item_image_input_file_div">
						<input type="file" id="item_image_file1" class="item_image_input_file" name="item_image1">
						<label for="item_image_file1">파일 선택</label>
					</div>
					<div class="item_write_field_msg" id="item_image1_msg"></div>
				</div>
				
				<div class="item_write_field item_image_field">
					<div class="item_image_upload_name_div">
						<input class="item_image_upload_name" id="item_image2_upload_name" placeholder="상세보기 이미지" readonly>
					</div>
					<div class="item_image_input_file_div">
						<input type="file" id="item_image_file2" class="item_image_input_file" name="item_image2">
						<label for="item_image_file2">파일 선택</label>
					</div>
				</div>
				
				<div id="item_write_form_buttons_div">
					<button type="submit" id="submit_button">상품 등록</button>
					<button type="reset" id="reset_button">등록 취소</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>