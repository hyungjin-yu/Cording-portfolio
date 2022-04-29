<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW(관리자) - 매출관리</title>
<link rel="stylesheet" href="../css/adminBody.css">
<link rel="stylesheet" href="../css/salesList.css?v=1">
<style type="text/css">
#admin_sales_button {
	background-color: black;
	color: white;
}
#admin_notice_button, 
#admin_item_button, 
#admin_member_button {
	background-color: white;
	color: black;
}
</style>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){

	$.ajax({
		url: "salesListJson.do",
		type: "post",
		data: {"pg": "${pg}"}, 
		dataType: "json",
		success: function(json){
			$.each(json.items, function(index, item){
				// 태그 생성
				var tr1 = $("<tr>", {align: "center"});
				var td1 = $("<td>").html(item.sales_date);
				var td2 = $("<td>").html(item.sales_code);
				var td3 = $("<td>").html(item.sales_name);
				var td4 = $("<td>").html(item.sales_category1);
				var td5 = $("<td>").html(item.sales_category2);
				var td6 = $("<td>").html(item.sales_category3);
				var td7 = $("<td>").html(item.sales_size);
				var td8 = $("<td>").html(item.sales_color);
				var td9 = $("<td>").html(item.sales_price);
				var td10 = $("<td>").html(item.sales_qty);
				var td11 = $("<td>").html(item.sales_totalprice);
				
				// 조립
				tr1.append(td1).append(td2).append(td3).append(td4).append(td5).append(td6).append(td7).append(td8).append(td9).append(td10).append(td11);
				
				// 출력
				$("#sales_list_tbody").append(tr1);
				$("#sales_part").html(item.sales);
			});
		},
		error: function(xhr, textStatus, errorThrown) {
			alert("[Error] " + xhr.status);
		}
	});

	
	// pagination
	$.ajax({
		url: "salesList.do?pg=${startPage - 1 }",
		type: "get",
		data: {"startPage": "${startPage}"},
		dataType: "html",
		success: function(json){
			$('#sales_list').html(data);
		},
		error: function(xhr, textStatus, errorThrown) {
			alert("[Error] " + xhr.status);
		}
	});
	
	
	// category로 검색
	$("#category1").load("../ajax/sales-category-data.html #sales_search_category1-1", function(){
		$(this).show();
	});
	
	$(document).on("change", "#category1 > select", function(){
		$("#category2").empty().hide();
		$("#category3").empty().hide();
		$("#category4").empty().hide();
		$("#category5").empty().hide();
		
		var target = $(this).find("option:selected").attr("data-target");
		var selector = "../ajax/sales-category-data.html " + target;
		
		$("#category2").load(selector, function() {
			$(this).show();
		});
	});
	
	$(document).on("change", "#category2 > select", function(){
		$("#category3").empty().hide();
		$("#category4").empty().hide();
		$("#category5").empty().hide();
		
		var target = $(this).find("option:selected").attr("data-target");
		var selector = "../ajax/sales-category-data.html " + target;
		
		$("#category3").load(selector, function() {
			$(this).show();
		});
	});
	
	$(document).on("change", "#category3 > select", function(){
		$("#category4").empty().hide();
		$("#category5").empty().hide();
		
		var target = $(this).find("option:selected").attr("data-target");
		var selector = "../ajax/sales-category-data.html " + target;
		
		$("#category4").load(selector, function() {
			$(this).show();
		});
	});

/*	
	$(document).on("change", "#category4 > select", function(){
		$("#category5").empty().hide();
		
		var target = $(this).find("option:selected").attr("data-target");
		var selector = "../ajax/sales-category-data.html " + target;
		
		$("#category5").load(selector, function() {
			$(this).show();
		});
	});


	$(document).on("change", "#category4 > select", function(){
		if($(this).find("option:selected").index() > 0) {
			
		}
	});
*/

	var data1 = $("#category1 > select > option:selected").val();
	var data2 = $("#category2 > select > option:selected").val();
	var data3 = $("#category3 > select > option:selected").val();
	var data4 = $("#category4 > select > option:selected").val();
	var data5 = $("#category5 > select > option:selected").val();
	
	if(data1=="ord_date") {
		$("#data1_hidden").attr('name', 'year').attr('value', data2);
		$("#data2_hidden").attr('name', 'month').attr('value', data3);
		$("#data3_hidden").attr('name', 'day').attr('value', data4);
	} else if(data1=="item_category") {
		$("#data1_hidden").attr('name', 'item_category1').attr('value', data2);
		$("#data2_hidden").attr('name', 'item_category2').attr('value', data3);
		$("#data3_hidden").attr('name', 'item_category3').attr('value', data4);
	} else if(data1=="user_gender") {
		$("#data1_hidden").attr('name', 'user_gender').attr('value', data2);
	} else if(data1=="user_agegroup") {
		$("#data1_hidden").attr('name', 'user_agegroup').attr('value', data2);
	}
	
});
</script>

</head>
<body>
	<!------------ admin menu ------------>
	<jsp:include page="../admin/adminMenu.jsp"/>
	
	<div id="sales_list_wrap">
		<div id="sales_list_wrap_inner">
			<div id="sales_list_label_div">
				Sales List
			</div>
			
			<form action="salesList.do" method="post">
				<div id="sales_search_div">
					<div id="sales_search_span_div">
						<span id="category1"></span>
						<span id="category2"></span>
						<span id="category3"></span>
						<span id="category4"></span>
						<span id="category5"></span>
					</div>
					
					<input type="hidden" id="data1_hidden">
					<input type="hidden" id="data2_hidden">
					<input type="hidden" id="data3_hidden">
					<input type="hidden" id="data4_hidden">
					<input type="hidden" id="data5_hidden">
					
					<input type="hidden" name="sales_search_button_clicked" value="clicked">
					
					<div id="sales_search_by_word_div">
						<button id="sales_search_by_word_button" type="submit">검색</button>
					</div>
				</div>
			</form>
			
			
			<div id="sales_list">
				<table id="sales_list_table" align="center">
					<tr>
						<th>주문일</th>
						<th>상품번호</th>
						<th>상품명</th>
						<th>카테고리1</th>
						<th>카테고리2</th>
						<th>카테고리3</th>
						<th>사이즈</th>
						<th>색상</th>
						<th>가격</th>
						<th>수량</th>
						<th>매출</th>
					</tr>
					
					<tbody id="sales_list_tbody">
						<!-- 매출 목록 출력 -->
					</tbody>
					
					<!-- 
					<c:forEach var="dto" items="${list }">
						<tr>
							<td>${dto.sales_date}</td>
							<td>${dto.sales_code}</td>
							<td>${dto.sales_name}</td>
							<td>${dto.sales_category1}</td>
							<td>${dto.sales_category2}</td>
							<td>${dto.sales_category3}</td>
							<td>${dto.sales_size}</td>
							<td>${dto.sales_color}</td>
							<td>${dto.sales_price}</td>
							<td>${dto.sales_qty}</td>
							<td>${dto.sales_totalprice}</td>
						</tr>
					</c:forEach>
					 -->
				</table>
			</div>
			
			<!-- paging -->
			<div class="pagination" style="text-align: center;">
				<c:if test="${startPage > 3 }">
					<a class="paging" href="salesList.do?pg=${startPage - 1 }">&laquo;</a>
				</c:if>
			
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<c:if test="${pg == i }">
						<a class="currentPaging" href="salesList.do?pg=${i }">${i }</a>
					</c:if>
					<c:if test="${pg != i }">
						<a class="paging" href="salesList.do?pg=${i }">${i }</a>
					</c:if>		
				</c:forEach>
			
				<c:if test="${endPage < totalP }">
					<a class="paging" href="salesList.do?pg=${endPage + 1 }">&raquo;</a>
				</c:if>		
			</div>
			
			<div id="sales_view_div">
				<div id="sales_view_inner_div">
					<div id="sales_view_inner2_div">
						<div id="sales_view_label_div">총 매출액</div>
						<div id="sales_separator">│</div>
						<div id="sales_part">${sales}원</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>