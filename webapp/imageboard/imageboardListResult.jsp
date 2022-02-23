<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="javax.swing.text.html.ImageView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid black;
	width: 500px;
}
th, td {
	border: 1px solid boack;
}
.currentPaging {color: red; text-decoration: underline;}
.paging {color: blue; text-decoration: none;}
</style>
</head>
<body>
<div style="height:170px;">
   <table border="1" width="540">
      <tr bgcolor="#ffff00">
         <th width="70">번호</th> 
         <th width="100">이미지</th>
         <th width="70">이름</th>
         <th width="100">가격</th>
         <th width="100">개수</th>
         <th width="150">합계</th>
      </tr>
      	<c:forEach var="dto" items="${list}">
      	<tr bgcolor="#ffffdd" align="center">
	         <td>${dto.seq }</td>
			 <td><img src="../storage/${dto.image1 }" width="50px"></td>
	         <td>${dto.imageName }</td>	<!-- ${dto.getImageName()} -->
	         <td>${dto.imagePrice }</td>
	         <td>${dto.imageQty }</td>
	         <td>${dto.imageQty * dto.imagePrice }</td>
	         </tr>
		</c:forEach>
    </table>	
    <!-- 페이지 표시 -->
	<div style="text-align: center;">
		  <c:if test="${startPage > 3 }">
	  	  		[<a class="paging" href="../imageboard/imageboardList.jsp?pg=${startPage-1 }">이전</a>]
	  	  </c:if>
	  	  		
	  	  <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
	  	  	 <c:if test="${pg == i }">
	  	  		[<a class="currentPaging" href="../imageboard/imageboardList.jsp?pg=${i }">${i }</a>]
	  	  	 </c:if>
	  	  	 
	  	 	 <c:if test="${pg != i }">	  	  		
	  	  		[<a class="paging" href="../imageboard/imageboardList.jsp?pg=${i }">${i }</a>]
	  	  	 </c:if>
	  	  </c:forEach>
	  	  		
	  	  <c:if test="${endPage < totalP }">
	  	  		[<a class="paging" href="../imageboard/imageboardList.jsp?pg=${endPage+1 }">다음</a>]
	  	   </c:if>
 	</div> 
</body>
</html>