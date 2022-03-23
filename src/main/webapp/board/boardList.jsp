<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function isLogin(seq) {
		if(${memId == null}) {
			alert("로그인을 해야 볼 수 있습니다.");
		} else {
			location.href="boardView.do?seq=" + seq + "&pg=" + ${pg};
		}
	}
</script>
</head>
<body>
<div style="width: 700px;">
	
		<table border="1">
			<tr id="title">
				<th id="titleNo">글번호</th>
				<th id="titleSub">제목</th>
				<th id="titleName">작성자</th>
				<th id="titleDate">작성일</th>
				<th id="titleHit">조회수</th>
			</tr>
			
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.seq}</td>
					<td><a href="#" onclick="isLogin(${dto.seq})">${dto.subject}</a></td>
					<td>${dto.name}</td>
					<td>${dto.logtime}</td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>
		</table>
	
	<div style="text-align: center;">
		<c:if test="${startPage > 3}">
			[<a class="paging" href="boardList.do?pg=${startPage-1}">이전</a>]
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:if test="${pg == i}">
				[<a class="currentPaging" href="boardList.do?pg=${i}">${i}</a>]
			</c:if>
			<c:if test="${pg != i}">
				[<a class="paging" href="boardList.do?pg=${i}">${i}</a>]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < totalP}">
			[<a class="paging" href="boardList.do?pg=${endPage+1}">다음</a>]
		</c:if>
	</div>
</div>
<a href="boardWriteForm.do">새글쓰기</a>
</body>
</html>