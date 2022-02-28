<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	background-color: orange;
}
</style>
</head>
<body>
	<table>
		 <tr bgcolor="#ffff00">
         <th width="70">번호</th> 
         <th width="100">제목</th>
         <th width="70">작성자</th>
         <th width="130">날짜</th>
         <th width="70">조회수</th>
      </tr>
      	<c:forEach var="dto" items="${list}">
      	<tr bgcolor="#ffffdd" align="center">
	         <td>${bean.board_num }</td>	
	         <td align="left"><a href="boardDetail.do?board_num=${bean.board_num }&pg=${pg}">${bean.board_subject }</a></td>
	         <td>${bean.board_name }</td>
	         <td>${bean.board_date }</td>
	         <td>${bean.board_readcount }</td>
	         </tr>
		</c:forEach>
	</table>
	<!-- 페이지 표시 -->
	<div style="text-align: center;">
		  <c:if test="${startPage > 3 }">
	  	  		[<a class="paging" href="../board/boardList.jsp?pg=${startPage-1 }">이전</a>]
	  	  </c:if>
	  	  		
	  	  <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
	  	  	 <c:if test="${pg == i }">
	  	  		[<a class="currentPaging" href="../board/boardList.jsp?pg=${i }">${i }</a>]
	  	  	 </c:if>
	  	  	 
	  	 	 <c:if test="${pg != i }">	  	  		
	  	  		[<a class="paging" href="../board/boardList.jsp?pg=${i }">${i }</a>]
	  	  	 </c:if>
	  	  </c:forEach>
	  	  		
	  	  <c:if test="${endPage < totalP }">
	  	  		[<a class="paging" href="../board/boardList.jsp?pg=${endPage+1 }">다음</a>]
	  	   </c:if>
 	</div> 
 	<br>
 	<a href="../index.jsp">메인 화면</a> &nbsp;
 	<a href="../boardWriteForm.do">글 쓰기</a>
</body>
</html>