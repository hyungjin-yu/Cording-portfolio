package member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import profile.bean.ProfileDTO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 회원 목록
	public List<ProfileDTO> memberList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.adminMapper.memberList", map);
	}
	
	// 회원 목록
	public List<ProfileDTO> memberListSearchByName(String startNum, String endNum, String user_name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("user_name", user_name);
		return sqlSession.selectList("mybatis.adminMapper.memberListSearchByName", map);
	}
	
	
	// 회원 상세정보
	public ProfileDTO memberView(int seq) {
		return sqlSession.selectOne("mybatis.adminMapper.memberView", seq);
	}
	
	
	// 총 데이터 개수 구하기(총 회원수)
	public int getTotalProfile() {
		return sqlSession.selectOne("mybatis.adminMapper.getTotalProfile");
	}
	
	
	// 총 데이터 개수 구하기(총 회원수)
	public int getTotalProfileSearchByName(String user_name) {
		return sqlSession.selectOne("mybatis.adminMapper.getTotalProfileSearchByName", user_name);
	}
		
	
}
