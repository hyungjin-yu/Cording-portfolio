<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Title</title>
<script type="text/javascript" src="script/memberScript.js"></script>
<style type="text/css">
    table{
        width: 500px;
        border-collapse: collapse;
        border: 1px solid black;
    }
    th, td{
        border: 1px solid black;
        padding: 5px;
    }
    th{
    	background: lightgreen;
    }
</style>
</head>
<body>
<form action="bookWrite.do" method="post" name="frm" onsubmit="check(); return false;">
  <div>
    <table>
        <tr>
            <th width="20%">도서코드</th>
            <td width="80%"><input type="text" name="book_num" id="book_num" placeholder="* 필수 입력"></td>
        </tr>
        <tr>
            <th>도서명</th>
            <td><input type="text" name="book_name" id="book_name" placeholder="* 필수 입력"></td>
        </tr>
        <tr>
            <th>저자</th>
            <td><input type="text" name="book_writer" id="book_writer" placeholder="* 필수 입력"></td>
        </tr>
        <tr>
            <th>출판사</th>
            <td><input type="text" name="publisher" id="publisher"></td>
        </tr>
        <tr>
            <th>가격</th>
            <td><input type="text" name="price" id="price"></td>
        </tr>
        <tr>
            <th>출판일</th>
            <td><input type="text" name="date"></td>
        </tr>
    </table>
    	<input type="submit" value="도서 입력">
    	<input type="reset" value="취소">
    	&emsp;
    <a href="jsp/index.jsp">메인 화면</a>
    </div>
</form>
</body>
</html>