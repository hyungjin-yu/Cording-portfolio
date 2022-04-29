<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW-Welcome Back</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="../script/ProfileFindIdScript.js"></script>
<link rel="stylesheet" href="../css/profileFindId.css?after">
<body id="findId_body">
	<form action="../forgetprofile/findId.do" method="post" name="form" id="form"
		onsubmit="check(); return false;">
		<div id="findId_container">
		<div style="margin: auto;">
			<h4 style="text-align: center;">WELCOME BACK</h4>
			<h5 style="text-align: center;">You can find ID by entering your Name and Email !</h5>
			<div class="find_id">
				<div class="field">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label">Name</label> <input
							class="label-input__input " type="text" autocomplete="user_name"
							maxlength="60" name="user_name" placeholder="Enter your Name"
							data-required="true" required="true" aria-required="true"
							data-test="txtLastNameField_Find"
							data-screenset-element-id="find-Name"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="profile.Name"
							data-original-value="" id="user_name">
					</div>
				</div>

				<div class="field is-last is-relative">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label">Email</label> <input
							class="label-input__input " type="email" autocomplete="email"
							maxlength="255" name="user_email" placeholder="Enter your Email"
							pattern="\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}\b"
							title="Email - e.g.: name@mail.com" data-required="true"
							required="true" aria-required="true"
							data-test="txtEmailIDField_Find"
							data-screenset-element-id="find-email"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="email"
							data-original-value=""  id="user_email">
					</div>
				</div><br>

	
				<div class="form-buttons__item"
					data-test="btnContinueShippingOptions">
					<button type="submit" class="button-is-primary-is-block"
						aria-live="polite" id=""
						data-screenset-element-id="__gig_template_element_4_1649292160346"
						data-screenset-element-id-publish="false"
						data-screenset-roles="instance">
						<span class="button__wrapper"> <span> FIND ID </span>
						</span>					</button>
				</div>
			</div>
		</div>
		</div>
	</form>
</body>
</html>