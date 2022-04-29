<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW-Welcome Back</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="../script/ProfileFindPwdScript.js"></script>
<link rel="stylesheet" href="../css/profileFindPwd.css">
<body id="forgetPwdBody">
	<form action="../forgetprofile/findPwd.do" method="post" name="form" id="form"
		onsubmit="check(); return false;">
		<div id="findPwd_container">
		<div id="find-pwd-title" style="text-align: center;">
			<h4>RESET YOUR NEW PASSWORD</h4>
			<h5>You can find ID by entering your Name and Email !</h5>
		</div>

		<div id="find-insert" style="text-align: left;">
			<div data-form-fieldset="generic">

				<div class="field ">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label">Name</label> <input
							class="label-input__input " type="text" autocomplete="username"
							maxlength="60" name="user_name" placeholder="Enter your Name"
							data-required="true" required="true" aria-required="true"
							data-test="txtLastNameField_Find"
							data-screenset-element-id="find-Name"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="profile.Name"
							data-original-value="" id="find-Name">
					</div>
				</div>

				<div class="field ">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label" for="find-Id">ID</label> <input
							class="label-input__input " type="text"
							pattern="^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$"
							autocomplete="id" maxlength="255" name="user_id"
							placeholder="Enter your ID" data-required="true" required="true"
							aria-required="true" data-test="txtIdField_FInd"
							data-screenset-element-id="find-id"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="id"
							data-original-value="" id="find-id">
					</div>
				</div>

				<div class="field ">
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
							data-original-value="" id="find-email">
					</div>
				</div><br>

				<div class="form-buttons__item"
					data-test="btnContinueShippingOptions">
					<button type="submit" class="button-is-primary-is-block"
						data-screenset-element-id="__gig_template_element_8_1649649243791"
						data-screenset-element-id-publish="false"
						data-screenset-roles="instance">
						<span class="button__wrapper"> <span> FIND PASSWORD</span>
						</span>
					</button>
				</div>
			</div>
		</div>
		</div>
	</form>
</body>
</html>