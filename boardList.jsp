<%@page import="member.dao.BoardDAO"%>
<%@page import="member.bean.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   int pg = Integer.parseInt(request.getParameter("pg"));
   // DB
   // 1페이지 당 5개씩
   // pg=1 : rn>=1 and rn<=6
   // pg=2 : rn>=6 and rn<=10
   
   int endNum = pg*5;
   int startNum = endNum - 4;
   
   // dao 작업
   List<BoardDTO> list = new ArrayList<BoardDTO>();
   BoardDAO dao = new BoardDAO();
   
   /*페이징 처리*/
   // 총 글 수 : 12
   // 총 페이지 수  : 3	=> (총 글 수 + 4) / 5 	<- 정수
   // [1][2][3]
   
   // 총 글 수  : 23
   // 총 페이지 수 : 5			
   // [1][2][3][4][5]
		   
   // 총 글 수  : 25
   // 총 페이지 수 : 5	 		
   // [1][2][3][4][5]
	int totalA = dao.getTotalA();	// 총 글 수 
	int totalP = (totalA + 4) / 5;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function isLogin(seq) {
		// 상세보기는 로그인 상태에서만 확인
		if(<%=session.getAttribute("memID") == null%>) {
			alert("먼저 로그인을 해주세요.");
		} else {
			location.href="boardview.jsp?seq=" + seq + "&pg=" + <%=pg%>;
		}
	}
</script>
<style type="text/css">
#subjectA:link{color:black; text-decoration:none;}
#subjectA:visited{color:black; text-decoration:none;}
#subjectA:hover{color:green; text-decoration:underline;}
#subjectA:active{color:black; text-decoration:none;}
</style>
</head>
<body>
<form action="">
   <table border="1" width="540">
      <tr bgcolor="#ffff00">
         <th width="70">글번호</th>
         <th>제목</th>
         <th width="100">작성자</th>
         <th width="100">작성일</th>
         <th width="70">조회수</th>
      </tr>
   <%for(BoardDTO dto : list){ %>
      <tr bgcolor="#ffffcc" align="center">
         <td><%=dto.getSeq() %></td>
         <td><a href="#" id="subjectA" onclick="isLogin(<%=dto.getSeq()%>)">
         <%=dto.getSubject() %></a></td>
         <td><%=dto.getName() %></td>
          <td><%=dto.getLogtime() %></td>
         <td><%=dto.getHit() %></td>
      </tr>
   <%} %>
   </table>
   
   <%if(session.getAttribute("memID") == null) { %>
   <a href="../member/LoginForm.jsp">로그인</a>
   <%} else { %>
   	<a href="boardWriteForm.jsp">글쓰기</a>
   <%} %>
</form>
</body>
</html>

<!-- 
   list = dao.boardList(startNum, endNum);
   
   int[] seq = new int[5];
   String[] name = new String[5];
   String[] Subject = new String[5];
   int[] hit = new int[5];
   String[] logtime = new String[5];
   
   for(int i=startNum-1; i<endNum; i++){
      seq[i] = list.get(i).getSeq();
      name[i] = list.get(i).getName();
      Subject[i] = list.get(i).getSubject();
      hit[i] = list.get(i).getHit();
      logtime[i] = list.get(i).getLogtime();
   }
 -->