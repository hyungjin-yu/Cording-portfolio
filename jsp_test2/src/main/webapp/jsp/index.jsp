<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>메인화면</title>
<style type="text/css">
body {
   margin: 0;
   padding: 0;
   height: 100%;
}
div#main {
   width: 800px;
   height: 800px;
   margin: auto;
}
header {
   width: 100%;
   height: 10%;
   background: skyblue;
   text-align: center;
   border: 1px solid lightgray;
}
nav{
    float: left;
    width: 180px;
    height: 80%;
    background: skyblue;
    padding-left: 9px;
    border: 1px solid lightgray;
}	
section{
    float: left;
    width: 600px;
    height: 80%;
    text-align: center;
    background: aliceblue;
    border: 1px solid lightgray;
}
footer{
    clear: both;
    width: 100%;
    height: 10%;
    color: black;
    background: skyblue;
    text-align:center;
    border : 1px solid lightgray;
}
a{
	text-decoration: none;
}
.index:link{color: black; text-decoration:none;}
.index:visited{color: black; text-decoration:none;}
.index:active{color: black; text-decoration:none;}
.index:hover{color: magenta; text-decoration:none;}
</style>
</head>
<body>
<div id="main">
   <header>
      <h1>도서관리</h1>
   </header>
   
   <nav>
      <h2><a href="index.jsp" class="index">** 메인 메뉴**</a></h2>
      <a class="index" href="bookWriteForm.do">도서 등록</a><br>
	  <a class="index" href="bookList.do">도서 목록</a><br>
   </nav>
   
   <section>
       	<c:if test="${ref != null}">
         	<jsp:include page="${ref}" flush="false"/>
      	</c:if>
   </section>
   
   <footer> 유형진 </footer>
</div>
</body>
</html>