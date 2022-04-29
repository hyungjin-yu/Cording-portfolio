<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<link rel="stylesheet" href="../css/inquiry.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#inquiry_submit").click(function(){
			//입력검사
			if(!$("#subject_form").val()) {
				alert("제목을 입력해주세요.");
				$("#subject_form").focus();
				return false;
			} else if(!$("#comment_form").val()) {
				alert("내용을 입력해주세요.");
				$("#comment_form").focus();
				return false;
			}
			
			var subject = $("#subject_form").val();
			var comment = $("#comment_form").val();
			//alert("subject_form =" + subject + " comment_form = " + comment);
			
			// DB로 보내기
			location.href="../item/inquiryWrite.do?inquiry_subject=" + subject + "&inquiry_content=" + comment;
		});
	});
	
</script>
</head>
<body id="inquiry_body">
	<div id="inquiry_container">
		<h2>1:1 문의게시판</h2>
		<!-- 문의글 작성폼 -->
		<div class="inquiry_form">
		<div id="inquiry_write">
			<p id="inquiry_info">-문의사항을 적어주세요-</p><br>
			<div id="inquiry_comment">
				<div>제목 : <input type="text" id="subject_form" size="80"></div>
				<div><textarea name="comment" id="comment_form"></textarea></div>
			</div>
			<div id="inquiry_submit">
				<img src="../img/submit.png" width="25" height="25" style="cursor:pointer;">
			</div>
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
						<td style="text-align: left; padding: 0 20px;">
							<c:if test="${vo.re_lev != 0 }">
								<!-- 두글자 공백문자 띄우기 -->
								<c:forEach var="i" begin="0" end="${vo.re_lev * 2 }" step="1">
									&nbsp;
								</c:forEach>
								└
							</c:if>
							<!-- 제목 누를 때마다 조회수 증가 -->
							<a href="../item/inquiryView.do?pg=${pg }&inquiry_code=${vo.inquiry_code }" 
								class="inquiry_subject_link">
								${vo.inquiry_subject }
							</a>
						</td>
						<td>${vo.user_id }</td>
						<td>${vo.inquiry_date }</td>
						<td>${vo.inquiry_readcount }</td>
					</tr>
				</c:forEach>				
			</table>	
			</div>
		</div>
		
		<!-- 페이징처리 -->
			<div style="text-align: center;" class="inquiryList_page">
			<c:if test="${startPage > 3 }">
				<a class="paging" href="inquiryList.do?pg=${startPage - 1 }">&#10094;</a>
			</c:if>
	
			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
				<c:if test="${pg == i }">
					<a class="currentPaging" href="inquiryList.do?pg=${i }">${i }</a>
				</c:if>
				<c:if test="${pg != i }">
					<a class="paging" href="inquiryList.do?pg=${i }">${i }</a>
				</c:if>		
			</c:forEach>
	
			<c:if test="${endPage < totalP }">
				<a class="paging" href="inquiryList.do?pg=${endPage + 1 }">&#10095;</a>
			</c:if>		
		</div>
	</div>
</body>
</html>