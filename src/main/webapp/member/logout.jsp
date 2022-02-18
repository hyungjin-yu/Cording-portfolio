<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*	// 1.쿠키 삭제
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null) {
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("memName")) {
				cookies[i].setMaxAge(0);	// 쿠키 삭제
				response.addCookie(cookies[i]);
			} else if(cookies[i].getName().equals("memID")) {
				cookies[i].setMaxAge(0);	// 쿠키 삭제
				response.addCookie(cookies[i]);
			}
		}
	}
*/

	// 2. 세션 삭제
	session.removeAttribute("memName");
	session.removeAttribute("memID");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// <body onload = "함수명"> 와 동일함
	window.onload = function() {
		alert("로그아웃");
		location.href = "../main/index.jsp";
	}
</script>
</head>
<body>
</body>
</html>