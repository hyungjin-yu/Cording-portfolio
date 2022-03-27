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
		// 상세보기는 로그인 상태에서만 확인
		if(${memId == null}) {
			alert("먼저 로그인 하세요");
		} else {
			location.href = "boardView.do?seq=" + seq + "&pg=" + ${pg};
		}
	}
</script>
<style type="text/css">
#subjectA:link {color:black; text-decoration: none;}
#subjectA:visited {color:black; text-decoration: none;}
#subjectA:hover {color:green; text-decoration: underline;}
#subjectA:active {color:black; text-decoration: none;}

.paging {color: blue; text-decoration: none;}
.currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>	
<div style="height:170px;">
   <table border="1" width="540" align="center">
      <tr bgcolor="#ffff00">
         <th width="70">글번호</th>  <!-- <th> 태그 : 문자열을 굵고 가운데 배치 -->
         <th>제목</th>
         <th width="100">작성자</th>
         <th width="100">작성일</th>
         <th width="70">조회수</th>
      </tr>
      <c:forEach var="dto" items="list">
	       <tr bgcolor="#ffffdd" align="center">
	         <td>${dto.seq}</td>
	         <td><a id="subjectA" href="#" onclick="isLogin(${dto.seq})">
	         	${dto.subject}</a></td>
	         <td>${dto.name}</td>
	         <td>${dto.logtime}</td>
	         <td>${dto.hit}</td>
	      </tr>
      </c:forEach>
   </table>	
</div>  
<!-- 페이지 표시 -->
<div style="text-align: center;">
	<c:if test="${startPage > 3}">
		[<a class="paging" href="boardList.do?pg=${startPage - 1}">이전</a>]
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
		<c:if test="${pg==i}">
			[<a class="currentPaging" href="boardList.do?pg=${i}">${i}</a>]
		</c:if>
		<c:if test="${pg!=i}">
			[<a class="paging" href="boardList.do?pg=${i}">${i}</a>]
		</c:if>	
	</c:forEach>
	<c:if test="${endPage <totalP}">
		[<a class="paging" href="boardList.do?pg=${endPage + 1}">다음</a>]
	</c:if>
</div> 
   
  	<a href="../main/index.do">메인</a> 
  	<c:if test="${memId == null}">
  		<a href="../member/loginForm.do">로그인</a>
  	</c:if>
  	<c:if test="${memId != null}">
  		<a href="boardWriteForm.do">글쓰기</a>
  	</c:if>
</body>
</html>
