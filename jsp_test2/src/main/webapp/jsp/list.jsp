<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, th, td{
border : 1px solid black;
border-collapse: collapse;
padding : 3px;
}
th {
background: yellow;
}
.paging {
	color: blue;
	text-decoration: none;
}

.currentPaging {
	color: red;
	font-weight: bold;
	text-decoration: underline;
}
td>a:link {color: black; text-decoration: none;}
td>a:visited {color: black; text-decoration: none;}
td>a:hover {color: green; text-decoration: underline;}
td>a:active {color: black; text-decoration: none;}
</style>
</head>
<body>
	<div>
		<table align="center" width="600">
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>출판일</th>
			</tr>
			<c:forEach var="bean" items="${list }">
				<tr align="center">
					<td>${bean.book_num() }</td>
					<td>${bean.book_name() } </td>
					<td>${bean.book_writer() }</td>
					<td>${bean.publisher()}</td>
					<td>${bean.price()}</td>
					<td>${bean.book_date() }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<div>
			<!-- Paging -->
			<c:if test="${startPage > 3 }">
				[<a class="paging" href="bookList.do?pg=${startPage-1 }">이전</a>]
			</c:if>
			
			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
				<c:if test="${pg == i }">
					[<a class="currentPaging" href="bookList.do?pg=${i }">${i }</a>]
				</c:if>
				
				<c:if test="${pg != i }">
					[<a class="paging" href="bookList.do?pg=${i }">${i }</a>]
				</c:if>
			</c:forEach>
			
			<c:if test="${endPage < totalP}">
				[<a class="paging" href="bookList.do?pg=${endPage+1 }">다음</a>]
			</c:if>
		</div>
	<a href="index.jsp">메인</a>
</body>
</html>