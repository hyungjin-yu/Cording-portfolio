<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="../css/profileFindPwd.css">
<body id="forgetPwdBody">
<form action="../forgetprofile/findPwdReset.do" method="post" name="form" id="form">
		<div id="findMain_container">
			<div id="findMain_container_inner">
				<div class="reset-password">
				<h3>새로 변경하실 비밀번호를 입력해주세요.</h3>
				<h3>Please enter a New password !</h3>
				
				<div class="reset-is-ready">
					<label id="reset-password">New Password</label> 
					<input type="password" name="user_pwd"
						title="Your password must contain 8 characters minimum and the following 3 character types: uppercase, lowercase and numbers"
						pattern="(?=^\S*$)(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,255}"
						placeholder="Enter your New Password" data-required="true"
						required="true" aria-required="true" id="user_pwd">
					<input type="hidden" name="user_id" value="${user_id }">
				</div>
				<div class="form-buttons__item">
					<button type="submit" class="button-is-primary-is-block">
					<span class="button__wrapper"> <span> 비밀번호 변경</span></span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>