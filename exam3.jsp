<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 사용 설정
	prefix="c" : 접미사 설정
	uri="http://java.sun.com/jsp/jstl/core" : 사용 네임스페이스 설정
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>** 변수 설정 **</h3>
	<c:set var="name">홍길동</c:set> 	<!-- jstl 변수 설정 방법 1 -->
	<c:set var="age" value="25"/>	<!-- jstl 변수 설정 방법 2 -->
	나의 이름은 ${name}입니다.<br>
	나의 나이는 ${age}살 입니다.<br>
	나의 키는 ${height} 입니다.<br>
	
	<h3>** 변수 삭제 **</h3>
	<c:remove var="name"/>
	나의 이름은 ${name}입니다.<br>
	나의 나이는 ${age}살 입니다.<br>
	나의 키는 ${height} 입니다.<br>
	
	<h3>** forEach : 일반 for문 대체 **</h3>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i } &nbsp;&nbsp;
		<c:set var="sum" value="${sum + i}"/>
	</c:forEach>
	<br>
	1~10 까지의 합 = ${sum }
	
	<h3>** 확장 for문 대체 **</h3>
	<c:set var="arr" value="10, 20, 30, 40, 50"/>
	<c:forEach var="data" items="${arr }">		<!-- for(int data : arr) -->
		${data } &nbsp;&nbsp;
	</c:forEach>
	
	<h3>** if **</h3>
	<c:set var="age" value="15"/>
	<c:if test="${age>=20 }">
		성인
	</c:if>
	<c:if test="${age<20 }">
		청소년
	</c:if>
	
	<h3>** 다중 선택 **</h3>
	<c:set var="color" value="red"/>
	<c:choose>
		<c:when test="${color== 'red' }">빨강</c:when>
		<c:when test="${color== 'green' }">초록</c:when>
		<c:when test="${color== 'blue' }">파랑</c:when>
		<c:when test="${color== 'magenta' }">보라</c:when>
		<c:otherwise>하늘</c:otherwise>
	</c:choose>
</body>
</html>