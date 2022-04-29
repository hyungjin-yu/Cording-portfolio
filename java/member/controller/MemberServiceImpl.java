package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.dao.MemberDAO;
import profile.bean.ProfileDTO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO dao;

	@Override
	public List<ProfileDTO> memberList(int startNum, int endNum) {
		return dao.memberList(startNum, endNum);
	}

	@Override
	public ProfileDTO memberView(int seq) {
		return dao.memberView(seq);
	}

	@Override
	public int getTotalProfile() {
		return dao.getTotalProfile();
	}

	@Override
	public List<ProfileDTO> memberListSearchByName(String startNum, String endNum, String user_name) {
		return dao.memberListSearchByName(startNum, endNum, user_name);
	}

	@Override
	public int getTotalProfileSearchByName(String user_name) {
		return dao.getTotalProfileSearchByName(user_name);
	}

}
