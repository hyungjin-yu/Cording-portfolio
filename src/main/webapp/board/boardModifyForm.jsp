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
   width: 300px;
   height: 200px;
}
#title {
   width: 300px;
}
</style>
<script type="text/javascript" src="../script/boardScript.js"></script>
</head>
<body>
   <form action="boardModify.jsp" method="post" name="form"
       onsubmit="checkBoardModify(); return false;">
      <table border="1">
         <tr>
            <td class="text" width="100">제목</td>
            <td><input type="text" name="subject" id="title"> </td>
         </tr>
         <tr>
            <td class="text">내용</td>
            <td><textarea name="content" id="content"></textarea> </td>            
         </tr>
         <tr>
            <td class="text" colspan="2">
            <input type="submit" value="수정하기">
            <input type="reset" value="다시작성">            
            </td>
         </tr>
      </table>
   </form>
</body>
</html>