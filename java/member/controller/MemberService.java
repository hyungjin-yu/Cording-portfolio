package member.controller;

import java.util.List;

import profile.bean.ProfileDTO;

public interface MemberService {
	// member
	public List<ProfileDTO> memberList(int startNum, int endNum);	// 회원 목록
	public ProfileDTO memberView(int seq);	// 회원 상세정보
	public int getTotalProfile();	// 총 데이터 개수 구하기(총 회원수)
	
	public List<ProfileDTO> memberListSearchByName(String startNum, String endNum, String user_name);
	public int getTotalProfileSearchByName(String user_name);
}
