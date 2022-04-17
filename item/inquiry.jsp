<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판</title>
<link rel="stylesheet" href="../css/inquiry.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#inquiry_submit").click(function(){
			//입력검사
			if(!$("#comment").val()) {
				alert("내용을 입력해주세요.");
				$("#comment").focus();
				return false;
			} 
			
			$("#comment").val("");	// 오류 있음ㅜㅜ
			
			// DB로 보내기 : 05-json exam03
			
		});
	});
	
</script>
</head>
<body>
	<div id="container">
		<!-- 문의글 작성폼 -->
		<div id="inquiry_write">
			<p id="inquiry_info">-문의사항을 적어주세요-</p>
			<form action="" id="inquiryForm">
				<div id="inquiry_comment">
					<label>문의 내용</label>
					<textarea name="comment" id="comment"></textarea>
				</div>
				<div id="inquiry_submit">
					<img alt="" src="../img/submit.png" width="25" height="25">
				</div>
			</form>
		</div>
		
		<hr>
		<!-- 문의글 게시판 -->
		<div id="inquiry_list">
			<table id="inquiry_table">
				<tr>
					<th id="inquiry_code">No.</th>			<!-- 글번호 -->
					<th id="inquiry_subject">제목</th>		<!-- 글제목 -->
					<th id="inquiry_id">작성자</th>			<!-- 작성자 -->
					<th id="inquiry_date">작성일</th>		<!-- 작성일 -->
					<th id="inquiry_readcount">조회수</th>	<!-- 조회수 -->
				</tr>
				<!-- 목록 -->
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.inquiry_code }</td>	<!-- 글번호 -->
						<td align="left">
							<c:if test="${vo.re_lev != 0 }">
								<!-- 두글자 공백문자 띄우기 -->
								<c:forEach var="i" begin="0" end="${vo.re_lev * 2 }" step="1">
									&nbsp;
								</c:forEach>
								▶
							</c:if>
							<a href="#">	<!-- inquiryView.do?pg=${pg }&inquiry_code=${vo.inquiry_code } -->
								${vo.inquiry_subject }
							</a>
						</td>
						<td>${vo.user_id }</td>
						<td>${vo.inquiry_date }</td>
						<td>${vo.inquiry_readcount }</td>
					</tr>
				</c:forEach>				
			</table>
			
			<!-- 페이징처리 -->
			<div style="text-align: center;">
			<c:if test="${startPage > 3 }">
				<a class="paging" href="#">&#10094;</a>
			</c:if>
	
			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
				<c:if test="${pg == i }">
					<a class="currentPaging" href="#">${i }</a>
				</c:if>
				<c:if test="${pg != i }">
					<a class="paging" href="#">${i }</a>
				</c:if>		
			</c:forEach>
	
			<c:if test="${endPage < totalP }">
				<a class="paging" href="#">&#10095;</a>
			</c:if>		
			</div>
		</div>
	</div>
</body>
</html>