package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.bean.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// insert : 저장
	public int write(MemberDTO dto) {
		return sqlSession.insert("mybatis.memberMapper.memberList", dto);
	}
	
	// 로그인 
	// select * from member where id='hong' and pwd='1234'
	// => 결과값중에서 이름만 리턴함
	public String login(String id, String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		return sqlSession.selectOne("mybatis.memberMapper.login", map);
	}
	
	// id가 있는 지 검사
	public boolean isExistId(String id) {
		return sqlSession.selectOne("mybatis.memberMapper.isExistId", id);
	}
	
	// 회원 1명의 데이터 읽어오기
	public MemberDTO getMember(String id) {
		return sqlSession.selectOne("mybatis.memberMapper.getMember", id);
	}
	
	// 데이터 수정
	public int modify(MemberDTO dto) {
		return sqlSession.selectOne("mybatis.memberMapper.modify", dto);
	} 
	
	// 5개씩 목록 데이터 구하기 
	public List<MemberDTO> selectList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.memberMapper.selectList", map);
	}
	
	// 총인원수 구하기
	public int getTotalMember() {
		return sqlSession.selectOne("mybatis.memberMapper.getTotalMember");
	}
	
	// 회원 탈퇴 => 삭제
	public int delete(String id) {
		return sqlSession.delete("mybatis.memberMapper.delete", id);
	}	
}






















