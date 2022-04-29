<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW - 공지</title>
<link rel="stylesheet" href="../css/adminBody.css">
<link rel="stylesheet" href="../css/noticeList.css">
<style type="text/css">
#admin_notice_button {
	background-color: black;
	color: white;
}
#admin_item_button, 
#admin_member_button, 
#admin_sales_button {
	background-color: white;
	color: black;
}
.notice_title {
	text-align: center;
	text-decoration: none;
}
.notice_title {color: black;}
.notice_title:link {color: black;}
.notice_title:visited {color: gray;}
</style>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	// 4개 중복되서 나옴 ㅠㅠ
	$(document).ready(function(){
		// 글 작성 폼 숨기기
		$("#noticeWriteForm").hide();
		
		$('.leaderDescription').hide();
		$(".notice_title").click(function(){
			var descriptionDiv = $(".leaderDescription");
			
			if ($(this).hasClass('active')){
				// hide the content div
				$(descriptionDiv).slideUp();
				
				// and remove the active class from the .leader and content div
				$(descriptionDiv).removeClass("active");
				$(this).removeClass('active');
			} else {
				alert("here");
				// Remove "active" from all .leader divs
				$(".notice_title").removeClass("active");
				
				// Add "active" class to the one just clicked
				$(this).addClass("active");
				
				// Slide up the content div if it is already open while we are updating data, before re-opening, similar to the JSFiddle you posted
				if ($(descriptionDiv).hasClass("active")) {
					// Remove active class
					$(descriptionDiv).removeClass("active"); 
					var $this = this;
					$(descriptionDiv).slideUp("500", function() {
						$($this).after(descriptionDiv);
						// Update our data
						UpdateData($this);
						// Re-open it.
						$(descriptionDiv).slideDown('slow').addClass('active');
					});
				} else {
					$(this).after(descriptionDiv);
					// Update our data
					UpdateData(this);
					$(descriptionDiv).slideDown('slow').addClass('active');
				}
			}
		});
		
		function UpdateData(thisElement) {
			var descriptionDiv = $(".leaderDescription");
			// Update our data
			$(descriptionDiv).find('.leaderName').text($(thisElement).attr('data-name'));
			$(descriptionDiv).find('.leaderTitle').text($(thisElement).attr('data-title'));
			$(descriptionDiv).find('.leaderProfile').text($(thisElement).attr('data-profile'));
		}
		
	});
	
	// 글 작성
	$("#notice_write_button").on("click", function(){
		$("#noticeWriteForm").fadeIn();
		$("#noticeLatestView").fadeOut();
	});
	
});


</script>
</head>
<body>
	<!------------ admin menu ------------>
	<c:if test="${login_id == 'admin' }">
		<jsp:include page="../admin/adminMenu.jsp"/>
	</c:if>
	<!------------ notice write form ------------>
	<span id="noticeWriteForm"><jsp:include page="noticeWriteForm.do"/></span>
	
	<!------------ notice view ------------>
	<span id="noticeLatestView"><jsp:include page="noticeLatestView.do"/></span>
	
	<!------------ notice list ------------>
	
	<div id="notice_list">
		<table id="notice_list_table" align="center">
			<tr>
				<th class="notice_date">날짜</th>
				<th class="notice_title">제목</th>
			</tr>
			
			<tbody id="notice_list_tbody">
				<!-- 공지 목록 출력 -->
			</tbody>
			

			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.notice_date }</td>
					<td><a class="notice_title" href="javascript:void(0)">${dto.notice_title }</a></td>
				</tr>
				<tr>
					<td colspan="2" class="leaderDescription">
						${dto.notice_content }
					</td>
				</tr>
			</c:forEach>
			
			
		</table>
	</div>
	
	<!-- paging -->
	<div class="pagination" style="text-align: center;">
		<c:if test="${startPage > 3 }">
			<a class="paging" href="noticeList.do?pg=${startPage - 1 }">&laquo;</a>
		</c:if>
	
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<c:if test="${pg == i }">
				<a class="currentPaging" href="noticeList.do?pg=${i }">${i }</a>
			</c:if>
			<c:if test="${pg != i }">
				<a class="paging" href="noticeList.do?pg=${i }">${i }</a>
			</c:if>		
		</c:forEach>
	
		<c:if test="${endPage < totalP }">
			<a class="paging" href="noticeList.do?pg=${endPage + 1 }">&raquo;</a>
		</c:if>		
	</div>
	
	<c:if test="${login_id == 'admin' }">
		<div id="notice_write_button_div">
			<!-- 누르면 숨겨진 글 작성 창이 뜸 -->
			<button type="submit" id="notice_write_button">새 공지</button>
		</div>
	</c:if>
</body>
</html>