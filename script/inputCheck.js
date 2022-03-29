$(function() {
	// id가 join인 <form>태그의 submit 버튼을 누른 경우
	$("#join").submit(function() {
		// 아이디 입력 검사
		var user_id = $("input[name='user_id']").val();
		if(!user_id) {
			alert("아이디를 입력하세요");
			$("input[name='user_id']").focus();
			return false; // submit 무효화
		}
		
		// 비밀번호 검사
		if(!$("input[name='user_pw']").val()) {
			alert("비밀번호를 입력하세요");
			$("input[name='user_pw']").focus();
			return false; // submit 무효화
		}
		
		// 주민번호 검사
		if(!$("input[name='user_no']").val()) {
			alert("주민 번호를 입력하세요");
			$("input[name='user_no']").focus();
			return false; // submit 무효화
		}
		
		// 성별 검사
		if(!$("input[name='gender']").is(":checked")) {
			alert("성별을 고르세요");
			$("input[name='gender']:eq(0)").focus();
			return false; // submit 무효화
		}
		
		// 이메일 주소 검사
		if(!$("input[name='email']").val()) {
			alert("이메일을 입력하세요");
			$("input[name='email']").focus();
			return false; // submit 무효화
		}
		
		// URL 검사
		if(!$("input[name='url']").val()) {
			alert("URL을 입력하세요");
			$("input[name='url']").focus();
			return false; // submit 무효화
		}

		// 핸드폰 번호 검사
		if(!$("input[name='hpno']").val()) {
			alert("핸드폰 번호를 입력하세요");
			$("input[name='hpno']").focus();
			return false; // submit 무효화
		}
		
		// 취미 검사
		if(!$("input[name='hobby']").is(":checked")) {
			alert("취미를 고르세요");
			$("input[name='hobby']:eq(0)").focus();
			return false; // submit 무효화
		}
		
		// 직업 검사
		if($("select[name='job'] > option:selected").index() < 1) {
			alert("직업을 고르세요");
			$("input[name='job']").focus();
			return false; // submit 무효화
		}
		
		/** 입력 내용을 읽어와서 body에 출력하기 **/
		var user_id = $("input[name='user_id']").val();
		var user_pw = $("input[name='user_pw']").val();
		var user_no = $("input[name='user_no']").val();
		var gender = $("input[name='gender']:checked");
		var email = $("input[name='email']").val();
		var url = $("input[name='url']").val();
		var hpno = $("input[name='hpno']").val();
		// 체크박스는 다중선택을 하기 때문에 선택된 태그를 읽어와서, 그 태그의 값을 읽어옴
		var hobby = $("input[name='hobby']:checked");
		var select_hobby = "";
		// each(function(){}) : 체크박스의 선택된 개수만큼 반복적으로 function()이 호출된다.
		// => 확장 for문 역할을 함
		hobby.each(function(){
			// $(this) : 현재 선택되어진 태그를 나타냄
			select_hobby += $(this).val() + " ";
		});
		var job = $("select[name='job'] > option:selected").val();
		
		// 출력할 문자열 태그 만들기
		var result = "<ul>";
		result += "<li>아이디 : " + user_id + "<li>";
		result += "<li>비밀번호 : " + user_pw + "<li>";
		result += "<li>주민 번호 : " + user_no + "<li>";
		result += "<li>성별 : " + gender + "<li>";
		result += "<li>이메일 주소 : " + email + "<li>";
		result += "<li>URL : " + url + "<li>";
		result += "<li>핸드폰 번호 : " + hpno + "<li>";
		result += "<li>취미 : " + select_hobby + "<li>";
		result += "<li>직업 : " + job + "<li>";
		result += "</ul>";
		
		$("body").html(result);
		
		return false;	// 연습이므로 화면이 안바뀌도록 submit을 무효화 시킴
	});
});