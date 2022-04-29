<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW-Welcome Back</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="../script/ProfileFindMainScript.js"></script>
<link rel="stylesheet" href="../css/profileFindMain.css">
</head>
<body id="profileMainBody">
	<div id="profileMain_container">
		<div class="allFindMain">
			<div class="context" style="text-align: center;">
				<h1 class="heading is-1 has-text-centered"
					data-test="lblWelcomeMessage_Register">Forgot Account </h1>
			</div>

			<div id="findMain_container">
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1">FIND ID</li>
					<li class="tab-link" data-tab="tab-2">FIND PASSWORD</li>
				</ul>

				<div id="tab-1" class="tab-content current">
					<jsp:include page="findIdForm.jsp"></jsp:include>
				</div>

				<div id="tab-2" class="tab-content">
					<jsp:include page="findPwdForm.jsp"></jsp:include>
				</div>
				
			</div>	
		</div>
	</div>
</body>
</html>