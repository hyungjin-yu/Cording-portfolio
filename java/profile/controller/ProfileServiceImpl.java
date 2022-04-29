package profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import profile.bean.ProfileDTO;
import profile.dao.ProfileDAO;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileDAO dao;

	@Override
	public boolean isExistId(String user_id) {
		return dao.isExistId(user_id);
	}

	@Override
	public int register(ProfileDTO dto) {
		return dao.register(dto);
	}

	@Override
	public String signin(String user_id, String user_pwd)  {
			return dao.signin(user_id, user_pwd);
	}

	@Override
	public String findId(String user_name, String user_email) {
		return dao.findId(user_name, user_email);
	}

	@Override
	public boolean findPwd(String user_id, String user_name, String user_email) {
		return dao.findPwd(user_id, user_name, user_email);
	}
	
	@Override
	public int findPwdReset(ProfileDTO dto) {
		return dao.findPwdReset(dto);
	}

	@Override
	public int mypage(ProfileDTO dto) {
		return dao.mypage(dto);
	}

	@Override
	public int withdrawal(String user_id) {
		return dao.withdrawalProfile(user_id);
	}

	@Override
	public ProfileDTO getMember(String user_id) {
		return dao.getMember(user_id);
	}
}
