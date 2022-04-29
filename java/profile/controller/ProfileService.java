package profile.controller;

import profile.bean.ProfileDTO;

public interface ProfileService {
	public boolean isExistId(String user_id); // (회원가입) ID중복 확인 isExistId
	public int register(ProfileDTO dto); // (회원가입) 데이터 저장하기 joinProfile
	public String signin (String user_id, String user_pwd); // (로그인) 로그인(ID&PW확인) signCheck
	public String findId(String user_name, String user_email);  // (로그인) 아이디 찾기 findId
	public boolean findPwd(String user_id, String user_name, String user_email); // (로그인) 비밀번호 찾기 findPwd
	public int findPwdReset(ProfileDTO dto); // (로그인) 비밀번호찾기 정보일치 확인 후 비밀번호 초기화
	public int mypage(ProfileDTO dto); // (마이페이지) 회원정보수정 modifyProfile
	public int withdrawal(String user_id);  // (마이페이지) 회원탈퇴 withdrawalProfile
	public ProfileDTO getMember(String user_id);	// 회원 1명 데이터 읽어오기
}
