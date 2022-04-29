package profile.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import profile.bean.ProfileDTO;

@Repository
public class ProfileDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// id가 있는 지 검사
	public boolean isExistId(String user_id) {
		ProfileDTO profileDTO = sqlSession.selectOne("mybatis.profileMapper.isExistId", user_id);
		boolean result = false;   // true : id있음, false : id 없음
		if(profileDTO != null) {  // 데이터가 있으면 => id가 존재함을 의미함
				result = true;
		}		
		return result;
	}

	// (회원가입) 데이터 저장하기 joinProfile
	public int register(ProfileDTO dto) {
		return sqlSession.insert("mybatis.profileMapper.register", dto);
	}

	// (로그인) 로그인
	public String signin(String user_id, String user_pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_pwd", user_pwd);
		return sqlSession.selectOne("mybatis.profileMapper.signin", map);
	}

	// (로그인) 아이디 찾기 findId
	public String findId(String user_name, String user_email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_name", user_name);
		map.put("user_email", user_email);
		return sqlSession.selectOne("mybatis.profileMapper.findId", map);
	}

	// (로그인) 비밀번호 찾기 findPwd
	public boolean findPwd(String user_id, String user_name, String user_email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_name", user_name);
		map.put("user_email", user_email);
		
		ProfileDTO profileDTO = sqlSession.selectOne("mybatis.profileMapper.findPwd", map);
		boolean result = false;   // true : id있음, false : id 없음
		if(profileDTO != null) {  // 데이터가 있으면 => id가 존재함을 의미함
			result = true;
		}		
		return result;
	}


	// (로그인) 비밀번호찾기 정보일치 확인 후 비밀번호 초기화
	public int findPwdReset(ProfileDTO dto) {
		return sqlSession.update("mybatis.profileMapper.findPwdReset", dto);
		}
		
	// 회원 1명의 데이터 읽어오기
	public ProfileDTO getMember(String user_id) {		
		return sqlSession.selectOne("mybatis.profileMapper.getMember", user_id);
	}
		
	// (마이페이지) 회원정보수정 modifyProfile
	public int mypage(ProfileDTO dto) {
		return sqlSession.update("mybatis.profileMapper.mypage", dto);
	}

	// (마이페이지) 회원탈퇴 withdrawalProfile
	public int withdrawalProfile(String user_id) {
		return sqlSession.delete("mybatis.profileMapper.withdrawal", user_id);
	}
}
