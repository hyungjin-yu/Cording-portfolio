package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 목록
	public List<BoardDTO> boardList(int startNum, int endNum) {
		// 매개변수가 여러개일 경우에는 Map 클래스에 저장해서 사용함
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.boardMapper.boardList", map);
	}
	
	// 총 데이터 갯수 구하기
	public int getTotalA() {
	return sqlSession.selectOne("mybatis.boardMapper.getTotalA");
	}
		
	// 상세보기
	public BoardDTO boardView(int seq) {
		return sqlSession.selectOne("mybatis.boardMapper.boardView", seq);
	}
		
	// insert : 글 저장
	public int boardWrite(BoardDTO dto) {
		return  sqlSession.insert("mybatis.boardMapper.boardWrite", dto);
	}
		
	// 글 삭제
	public int boardDelete(int seq) {
		return sqlSession.delete("mybatis.boardMapper.boardDelete", seq);
	}
		
	// 조회수 증가하기
	public int updateHit(int seq) {
		return sqlSession.selectOne("mybatis.boardMapper.updateHit", seq);
	}
}
