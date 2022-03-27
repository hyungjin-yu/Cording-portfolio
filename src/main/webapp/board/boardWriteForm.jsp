<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.text {
   text-align: center;
}
#content {
   width: 400px;
   height: 300px;
}
#title {
   width: 400px;
}
</style>
<script type="text/javascript" src="../script/boardScript.js"></script>
</head>
<body>
   <form action="boardWrite.do" method="post" name="form"
       onsubmit="checkBoardWrite(); return false;">
      <table border="1" width="470">
         <tr>
            <td class="text" width="70">제목</td>
            <td><input type="text" name="subject" id="title"> </td>
         </tr>
         <tr>
            <td class="text">내용</td>
            <td><textarea name="content" id="content"></textarea></td>            
         </tr>
         <tr>
            <td class="text" colspan="2">
	            <input type="submit" value="글쓰기">
	            <input type="reset" value="다시작성">            
            </td>
         </tr>
      </table>
   </form>
</body>
</html>