<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW Mypage</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="../script/MypageScript.js"></script>
<script type="text/javascript">
	$(function(){
		// 탈퇴 버튼
		$(".withdrawal_btn").click(function(){
			location.href="../mypage/withdrawalForm.do";			
		});
	});
</script>
<link rel="stylesheet" href="../css/mypage.css">
</head>
<body id="mypage_body">
	<form action="../mypage/mypage.do" method="post" name="form" id="form"
		onsubmit="check(); return false;">
		
	<h1 class="heading is-1 " data-test="lblMyDetails" style="text-align: center;">MY INFORMATION</h1>
	
	<div class="allMypage">
	<div id="mypage_container" style="text-align: left;">
		<div data-form-fieldset="generic">
			<div class="heading-block-has-thin-separator-title">
				<h3>PROFILE</h3>
				<h5>You must enter "Current Password" to modify the information.</h5>
			</div>
			
			<div class="field ">
				<div class="label-mypage js-label-mypage is-ready">
					<label class="label-mypage__label" for="mypage-Name">Name</label>
					<input class="label-input__input " type="text" name="user_name" disabled />
				</div>
			</div>

			<div class="field ">
				<div class="label-input js-label-input is-ready">
					<label class="label-input__label" for="register-Id" >ID</label>
					<input class="label-input__input " type="text" name="user_id" disabled/>
				</div>
			</div>

			<div id="878c90d4-7723-428a-9ac3-f70da7ef75c0"
				class="nike-unite-date-input dateOfBirth nike-unite-component empty">
				<label for="84725b08-1442-4758-85e0-8fb7eb08b164">Date of
					Birth</label><br> 
					<input class="label-input__input " type="text" name="user_birth" disabled/>
			</div>

			<div id="f6961be2-c044-4fd2-95ef-fe630a3394f3"
				class="nike-unite-gender-buttons gender nike-unite-component">
				<label for="5c341b7c-13ae-4e4b-95ed-a61dec34c81a">Gender</label>
				<input class="label-input__input " type="text" name="user_gender" disabled/>
			</div>
			<div class="field has-no-margin is-relative">
				<div class="label-input js-label-input is-ready">
					<label class="label-input__label"
						data-screenset-element-id="label_register-password"
						data-screenset-element-id-publish="true"
						data-screenset-roles="instance" for="register-password"
						id="label_register-password">Current Password*</label> <input
						class="label-input__input " type="password"
						autocomplete="new-password" aria-describedby="password-help"
						name="user_pwd1" 	title="Enter your Current Password."
						value="" pattern="(?=^\S*$)(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,255}"
						placeholder="Enter your Current Password" data-required="true"
						aria-required="true" data-test="txtPasswordField_Register"
						data-toggle="register-password" autocorrect="off"
						autocapitalize="off" spellcheck="false"
						data-screenset-element-id="register-password"
						data-screenset-element-id-publish="true"
						data-screenset-roles="instance" data-gigya-name="password"
						data-original-value="" id="register-password">
				</div>
			</div>

			<div class="field has-no-margin is-relative">
				<div class="label-input js-label-input is-ready">
					<label class="label-input__label"
						data-screenset-element-id="label_register-password"
						data-screenset-element-id-publish="true"
						data-screenset-roles="instance" for="register-password"
						id="label_register-password">New Password</label> <input
						class="label-input__input " type="password"
						autocomplete="new-password" aria-describedby="password-help"
						name="user_pwd"
						title="Your password must contain 8 characters minimum and the following 3 character types: uppercase, lowercase and numbers"
						value="" pattern="(?=^\S*$)(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,255}"
						placeholder="Enter your New Password" data-required="true"
						aria-required="true" data-test="txtPasswordField_Register"
						data-toggle="register-password" autocorrect="off"
						autocapitalize="off" spellcheck="false"
						data-screenset-element-id="register-password"
						data-screenset-element-id-publish="true"
						data-screenset-roles="instance" data-gigya-name="password"
						data-original-value="" id="register-password">
				</div>
			</div>

			<div class="fields-block phone-number-block ">
				<div class="field">
					<div class="label-input js-label-input is-ready">
						<label class="label-input__label" for="registrationPhone">Phone
							Number </label> <input
							class="label-input__input js-phone-field js-phone-number"
							placeholder="Enter your Phone Number" required="" type="tel"
							aria-required="true" autocomplete="tel-national"
							name="user_phone" data-type="tel"
							data-phone-pattern="wc-billing-phone"
							pattern="^(010|011|016|017|018|019)[0-9\s]*$"
							title="Mobile phone number input format : 01000000000 (- Exclude)"
							data-screenset-element-id="registrationPhone"
							data-screenset-element-id-publish="true"
							data-screenset-roles="instance" id="registrationPhone">
					</div>
				</div>
			</div>

			<div class="field ">
				<div class="label-input js-label-input is-ready">
					<label class="label-input__label" for="register-email">Email</label>
					<input class="label-input__input" type="email"
						autocomplete="email" maxlength="255" name="user_email"
						placeholder="Enter your Email"
						pattern="\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}\b"
						title="Email - e.g.: name@mail.com" value="" data-required="true"
						aria-required="true" data-test="txtEmailIDField_Register"
						data-screenset-element-id="register-email"
						data-screenset-element-id-publish="true"
						data-screenset-roles="instance" data-gigya-name="email"
						data-original-value="" id="user_email">
				</div>
			</div><br>

			<div class="form-buttons is-left is-last js-search-btn ">
				<div class="form-buttons__item cta-button">
					<button type="button" onClick="goPopup();" value="팝업_domainChk"
						class="button-is-secondary-daumSearchButton" id="js-searchaddress" aria-live="polite">
						<span class="button__wrapper_a"> <span> Search Address</span>
						</span>
					</button>
					<input type="text" class="label-input__input"  id="roadFullAddr" name="roadFullAddr" placeholder="Search the Address"/>
					<input type="text" class="label-input__input"  id="addrDetail" name="addrDetail" placeholder="Enter detailed Address"/>
				</div>
			</div><br>

			<div class="form-buttons__item"
						data-test="btnContinueShippingOptions">
						<button type="submit" class="button-is-primary-is-block" style="cursor: pointer;">
							<span class="button__wrapper">
							<span> Profile Update</span>
							</span>
						</button>
					</div><br><br>
					
			<section class="customer__content is-xnarrow text-box">
			    <div class="delete-account">
			      <div class="heading-block has-thin-separator has-margin-bottom-sm">
			        <h2 class="heading is-5">NAW Membership Withdrawal</h2>
			      </div>
			      <p>NAW 회원 탈퇴 시 패션, 슈즈, 악세사리 등의 온라인 및 오프라인 회원 정보 및 구매 정보 등 모든 정보가 삭제 됩니다.</p>
			      <button type="button" class="button-is-primary-is-block" style="cursor: pointer;">
							<span class="button__wrapper"><span class="withdrawal_btn"> NAW Membership Withdrawal</span></span>
						</button>
			    </div>
			</section>
			</div>
		</div>
	</div>
	</form>
</body>
</html>