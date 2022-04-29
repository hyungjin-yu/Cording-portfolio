<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NAW-Welcome Back</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="../script/ProfileSigninScript.js"></script>
<script type="text/javascript">
	$();
</script>
<link rel="stylesheet" href="../css/profileSignin.css">
<body id="signinFormBody">
	<form action="signin.do" method="post" name="form" id="form"
		onsubmit="check(); return false;">
		<div id="signinForm_container">
			<h4>WELCOME BACK</h4>
			<h5>Sign in with your id and password.</h5>
			<div class="insert_id_pw">
				<div class="field">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label" for="Signin-id">ID</label><br>
						<input class="label-input__input" type="text"
							data-test="txtIdField_Signin" maxlength="255" name="user_id"
							placeholder="Enter your ID" data-required="true" required="true"
							aria-required="true" data-screenset-element-id="Signin-id"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="SigninID"
							data-original-value="" id="user_id" aria-invalid="true">
					</div>
				</div>

				<div class="field is-last is-relative">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label" for="Signin-password">Password</label><br>
						<input class="label-input__input" type="password"
							placeholder="Enter your PW"
							data-test="txtRegisteredUserPassword_ShowPassword"
							autocomplete="current-password" name="user_pwd"
							data-required="true" required="true" aria-required="true"
							data-toggle="Signin-password" autocorrect="off"
							autocapitalize="off" spellcheck="false"
							data-screenset-element-id="Signin-password"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="password"
							data-original-value="" id="Signin-password"> <span
							class="password-eye-toggle is-invisible"
							data-screenset-element-id="password-eye-toggle_Signin-password"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance"
							id="user_pwd"><br> </span>
					</div>
				</div>
				
				<div id="">
				<a href="../forgetprofile/findMain.do">*Forgot Password? > </a><br>
				</div>
				<p></p><br>

				<div class="form-footer remember-me" data-remember-me="false">
					<div class="field is-not-spaced">
						<span class="checkbox"> <input type="checkbox"
							data-test="chkbxRememberMe" name="remember" value=""
							data-screenset-element-id="Signin-remember"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="remember"
							data-original-value="false" id="Signin-remember"
							aria-required="false"> <label id="" for="Signin-remember">Remember
								me (optional)</label>
						</span>
						<div class="form-footer has-margin-bottom-xl">
							<p class="is-privacy-text">
								By providing my information, I agree to NAW's <a href="#"
									target="_blank" class="link is-underline" tabindex="0"> <span>Privacy
										Policy</span>
								</a> and <a href="#" target="_blank" class="link is-underline"
									tabindex="0"><span>Legal Statement</span></a>
							</p>
						</div>
						<div class="form-buttons__item"
							data-test="btnContinueShippingOptions">
							<button type="submit" class="button-is-primary-is-block"
								aria-live="polite" id=""
								data-screenset-element-id="__gig_template_element_4_1649292160346"
								data-screenset-element-id-publish="false"
								data-screenset-roles="instance" style="cursor: pointer;">
								<span class="button__wrapper"> <span> Sign in </span>
								</span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
