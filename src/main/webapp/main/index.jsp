<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>*** 메인 화면 ***</h3>
	<br>
	<a href="../board/boardList.do?pg=1">목록</a><br>
	<c:if test="${memId == null}">
		<!-- 로그인 전 화면 -->
		<a href="../member/loginForm.do">로그인</a><br>
		<a href="../member/writeForm.do">회원가입</a><br>
	</c:if>
	<c:if test="${memId != null}">
		<!-- 로그인 후 화면 -->
		<a href="../board/boardWriteForm.do">글쓰기</a><br>
		<a href="../member/logout.do">로그아웃</a><br>
		<a href="../member/modifyForm.do">회원 정보 수정</a><br>
		<!-- 회원목록보기는 관리자 기능이기 때문에, 회원들에는 오픈하면 안됨 -->
		<a href="../member/memberList.do?pg=1">회원목록</a><br>
		<a href="../member/deleteForm.do">회원 탈퇴</a>
	</c:if> 
</body>
</html>