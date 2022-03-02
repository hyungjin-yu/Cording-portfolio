<%@page import="testjava.Scorebean"%>
<%@page import="testjava.ScoreDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));
	int endNum = pg*10;
	int startNum = endNum - 9;
	
	ScoreDAO dao = new ScoreDAO();
	List<Scorebean> list = dao.scoreList(startNum, endNum);
	
	int totalA = dao.getTotalA();	// 총 글 수 
	int totalP = (totalA + 9) / 10;	// 총 페이지 수
	
	int startPage = (pg-1)/5*5 + 1;
    int endPage = startPage + 4;
    
    if(endPage > totalP) endPage = totalP;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.currentPaging {color: red; text-decoration: underline;}
.paging {color: blue; text-decoration: none;}
</style>
</head>
<body>
	<table>
		 <tr bgcolor="skyblue">
         <th width="140">학번</th>  <!-- <th> 태그 : 문자열을 굵고 가운데 배치 -->
         <th width="70">이름</th>
         <th width="70">국어</th>
         <th width="70">영어</th>
         <th width="70">수학</th>
         <th width="70">총점</th>
         <th width="70">평균</th>
      </tr>
      <% for(Scorebean bean : list) { %>
      	<tr bgcolor="#ffffdd" align="center">
         <td><%=bean.getHak() %></td>
         <td><%=bean.getStuname() %></td>
         <td><%=bean.getKor() %></td>
         <td><%=bean.getEng() %></td>
         <td><%=bean.getMath() %></td>
         <td><%=bean.getSumscore() %></td>
         <td><%=bean.getAvgscore() %></td>
      </tr>
		<% } %>	 
	</table>
	<div style="text-align: center;">
		  <% if(startPage > 3) { %>
	  	  		[<a class="paging" href="scoreList.jsp?pg=<%=startPage-1%>">이전</a>]
	  	  <% } %>
	  	  		
	  	  <% for(int i=startPage; i<=endPage; i++) { %>
	  	  	 <% if(pg == i) { %>
	  	  		[<a class="currentPaging" href="scoreList.jsp?pg=<%=i%>"><%=i %></a>]
	  	  	 <% } else { %>	  	  		
	  	  		[<a class="paging" href="scoreList.jsp?pg=<%=i%>"><%=i %></a>]
	  	  	 <% } %>
	  	  <% } %>
	  	  		
	  	  <% if(endPage < totalP) { %>	
	  	  		[<a class="paging" href="scoreList.jsp?pg=<%=endPage+1%>">다음</a>]
	  	  <% } %>
 	</div> 
</body>
</html>