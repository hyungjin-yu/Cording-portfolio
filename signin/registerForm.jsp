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
<script type="text/javascript" src="../script/ProfileRegisterScript.js"></script>
<link rel="stylesheet" href="../css/profileRegister.css">
<script type="text/javascript">
	$(function(){
		$(".button-gender").click(function(){
			var user_gender = $(this).val();
			$("#user_gender_hidden").attr("value", user_gender);	
		});
	});
</script>
<body id="profileRegisterBody">
	<form action="register.do" method="post" name="form" id="form"
		onsubmit="check(); return false;">
		<div id="registerForm_container">
		<div id="register-second-title" style="text-align: center;">
			<h4>BECOME A NAW MEMBER</h4>
			<h5>Create an account and benefit from a more personal shopping
				experience, and quicker online checkout. All fields are mandatory !</h5>
		</div>

		<div id="register-insert" style="text-align: left;">
			<div data-form-fieldset="generic">

				<div class="field ">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label" for="register-Name">Name</label>
						<input class="label-input__input " type="text"
							autocomplete="username" maxlength="60" name="user_name"
							placeholder="Enter your Name" 
							data-required="true" required="true"
							aria-required="true" 
							data-test="txtLastNameField_Register"
							data-screenset-element-id="register-Name"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="profile.Name"
							data-original-value="" id="user_name">
					</div>
				</div>

				<div class="field ">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label" for="register-Id">ID</label> <input
							class="label-input__input " type="text"
							pattern="^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$"
							autocomplete="id" maxlength="255" name="user_id"
							placeholder="Enter your ID" 
							data-required="true" required="true"
							aria-required="true"  data-test="txtIdField_Register"
							data-screenset-element-id="register-id"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="id"
							data-original-value="" id="user_id">
					</div>
				</div>

				<div class="field has-no-margin is-relative">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label"
							data-screenset-element-id="label_register-password"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" for="register-password"
							id="label_register-password">Password</label> <input
							class="label-input__input" type="password"
							autocomplete="new-password" aria-describedby="password-help"
							name="user_pwd"
							title="Your password must contain 8 characters minimum and the following 3 character types: uppercase, lowercase and numbers" 
							pattern="(?=^\S*$)(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,255}"
							placeholder="Enter your Password" 
							data-required="true" required="true"
							aria-required="true"  data-test="txtPasswordField_Register"
							data-toggle="register-password" autocorrect="off"
							autocapitalize="off" spellcheck="false"
							data-screenset-element-id="register-password"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="password"
							data-original-value="" id="user_pwd">
					</div>
				</div>

				<div class="fields-block phone-number-block ">
					<div class="field">
						<div class="label-input js-label-input is-ready">
							<label class="label-input__label" for="registrationPhone">Phone
								Number </label> <input
								class="label-input__input js-phone-field js-phone-number"
								placeholder="Enter your Phone Number (ex. 01012345678)" 
								data-required="true" required="true"
								aria-required="true" 
								autocomplete="tel-national" name="user_phone" data-type="tel"
								data-phone-pattern="wc-billing-phone"
								pattern="^(010|011|016|017|018|019)[0-9\s]*$"
								title="휴대폰 번호 입력 형식 – 01000000000(- 제외)"
								data-screenset-element-id="registrationPhone"
								data-screenset-element-id-publish="true"
								data-screenset-roles="instance" id="user_phone">
						</div>
					</div>
				</div>


				<div class="field ">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label" for="register-email">Email</label>
						<input class="label-input__input " type="email"
							autocomplete="email" maxlength="255" name="user_email"
							placeholder="Enter your Email"
							pattern="\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}\b"
							title="Email - e.g.: name@mail.com"  
							data-required="true" required="true"
							aria-required="true"  data-test="txtEmailIDField_Register"
							data-screenset-element-id="register-email"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" data-gigya-name="email"
							data-original-value="" id="user_email">
					</div>
				</div>
				<br>

				<div class="form-buttons is-left is-last js-search-btn ">
					<div class="form-buttons__item cta-button">
						<button type="button" onClick="goPopup();" value="팝업_domainChk"
							class="button-is-secondary-daumSearchButton"
							id="js-searchaddress" aria-live="polite">
							<span class="button__wrapper_a"> <span> Search
									Address</span>
							</span>
						</button>
						<input type="text" class="label-input__input" id="roadFullAddr"
							name="roadFullAddr" placeholder="Search the Address" />
						<input type="text" class="label-input__input" id="addrDetail"
							name="addrDetail" placeholder="Enter detailed Address" 
							data-required="true" required="true" aria-required="true" />
					</div>
				</div>
				<br>

				<div id="878c90d4-7723-428a-9ac3-f70da7ef75c0"
					class="nike-unite-date-input dateOfBirth nike-unite-component empty">
					<div class="shim"></div>
					<div class="error"></div>
					<label for="84725b08-1442-4758-85e0-8fb7eb08b164">Date of
						Birth</label><br> <input id="" class="label-input__input" type="date"
						placeholder="Date of Birth" name="user_birth" data-required="true" required="true" 
						aria-required="true"  data-componentname="dateOfBirth" autocomplete="off"
						autocorrect="off" autocapitalize="off" spellcheck="false"
						data-ddlabel="dd" data-mmlabel="mm" data-yyyylabel="yyyy">
				</div>

				<div id="f6961be2-c044-4fd2-95ef-fe630a3394f3"
					class="nike-unite-gender-buttons gender nike-unite-component">
					<label for="5c341b7c-13ae-4e4b-95ed-a61dec34c81a">Gender</label><br>
					<input style="display: inline-block;" type="button"
						class="button-gender" id="male" value="Male" name="user_gender">
					<input style="display: inline-block;" type="button"
						class="button-gender" id="F" value="female"
						name="user_gender">
					<!-- 히든으로 값 보내기 -->
					<input type="hidden" name="user_gender_val" id="user_gender_hidden">
				</div>

				<p class="is-privacy-text">
					By providing my information, I agree to NAW's <a href="#"
						target="_blank" class="link is-underline" tabindex="0"><span>Privacy
							Policy</span></a> and <a href="#" target="_blank" class="link is-underline"
						tabindex="0"><span>Legal Statement</span></a>
				</p>

				<div class="field is-not-spaced  is-hidden">
					<span> <input type="checkbox"
						data-gigya-name="preferences.privacy.us_pii_usage.isConsentGranted"
						data-error-before="true"
						name="preferences.privacy.us_pii_usage.isConsentGranted"
						checked="true" data-type="privacy" data-required="true"
						required="true" aria-required="true"
						data-test="chkbxPrivacyPolicyCheckbox" value=""
						data-screenset-element-id="register-terms-checkbox"
						data-screenset-element-id-publish="true"
						data-screenset-roles="instance" data-original-value="true"
						id="register-terms-checkbox"> <label id=""
						for="register-terms-checkbox">I agree to the <a
							href="https://services.chanel.com/en_US/policies/privacy/"
							target="_blank" class="link is-underline" type="button"
							tabindex="0"><span>Privacy Policy</span></a></label>
					</span>
				</div>
			</div>

			<div class="gigya-captcha-wrapper gigya-register-captcha">
				<div class="gigya-captcha gigya-reset"
					data-screenset-element-id="__gig_template_element_9_1649649243791"
					data-screenset-element-id-publish="false"
					data-screenset-roles="instance">
					<div id="gig_captcha_2_1649649246658">
						<div class="grecaptcha-badge" data-style="bottomright"
							style="width: 256px; height: 60px; display: block; transition: right 0.3s ease 0s; position: fixed; bottom: 14px; right: -186px; box-shadow: gray 0px 0px 5px; border-radius: 2px; overflow: hidden;">
							<div class="grecaptcha-logo">
								<iframe title="reCAPTCHA"
									src="https://www.google.com/recaptcha/api2/anchor?ar=1&amp;k=6Le88JwcAAAAAJ6wFD4vgnmLtWFE6tspJQcfP-KS&amp;co=aHR0cHM6Ly93d3cuY2hhbmVsLmNvbTo0NDM.&amp;hl=en&amp;v=Y-cOIEkAqcfDdup_qnnmkxIC&amp;theme=white&amp;size=invisible&amp;cb=zhvjz4imjdhl"
									width="256" height="60" role="presentation"
									name="a-hzz2s4ou4ol9" frameborder="0" scrolling="no"
									sandbox="allow-forms allow-popups allow-same-origin allow-scripts allow-top-navigation allow-modals allow-popups-to-escape-sandbox"></iframe>
							</div>

							<div class="grecaptcha-error"></div>
							<textarea id="g-recaptcha-response-2" name="g-recaptcha-response"
								class="g-recaptcha-response"
								style="width: 250px; height: 40px; border: 1px solid rgb(193, 193, 193); margin: 10px 25px; padding: 0px; resize: none; display: none;"></textarea>
						</div>
						<iframe style="display: none;"></iframe>
					</div>
				</div>
				<span class="gigya-error-msg" data-bound-to="captchaText"
					data-screenset-element-id="__gig_template_element_6_1649649243789"
					data-screenset-element-id-publish="false"
					data-screenset-roles="instance" aria-atomic="true"></span>
			</div>

			<br>
			<div class="form-buttons__item"
				data-test="btnContinueShippingOptions">
				<button type="submit" class="button-is-primary-is-block"
					data-screenset-element-id="__gig_template_element_8_1649649243791"
					data-screenset-element-id-publish="false"
					data-screenset-roles="instance">
					<span class="button__wrapper"> <span> Create Account</span>
					</span>
				</button>
			</div>
			
		</div>
		</div>
	</form>
</body>
</html>