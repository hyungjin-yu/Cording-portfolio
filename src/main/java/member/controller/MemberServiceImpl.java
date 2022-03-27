package member.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;
	
	@Override
	public int write(MemberDTO dto) {
		return dao.write(dto);
	}

	@Override
	public String login(String id, String pwd) {
		return dao.login(id, pwd);
	}

	@Override
	public boolean isExistId(String id) {
		return dao.isExistId(id);
	}

	@Override
	public MemberDTO getMember(String id) {
		return dao.getMember(id);
	}

	@Override
	public int modify(MemberDTO dto) {
		return dao.modify(dto);
	}

	@Override
	public List<MemberDTO> selectList(int startNum, int endNum) {
		return dao.selectList(startNum, endNum);
	}

	@Override
	public int getTotalMember() {
		return dao.getTotalMember();
	}

	@Override
	public int delete(String id) {
		return dao.delete(id);
	}

}
