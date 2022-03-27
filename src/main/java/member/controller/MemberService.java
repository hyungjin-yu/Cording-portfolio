package member.controller;

import java.util.List;

import member.bean.MemberDTO;

public interface MemberService {
	public int write(MemberDTO dto);
	public String login(String id, String pwd);
	public boolean isExistId(String id);
	public MemberDTO getMember(String id);
	public int modify(MemberDTO dto);
	public List<MemberDTO> selectList(int startNum, int endNum);
	public int getTotalMember();
	public int delete(String id);
}
