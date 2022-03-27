package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// insert : 글저장
	public int boardWrite(BoardDTO dto) {
		return sqlSession.insert("mybatis.boardMapper.boardWrite", dto);
	}

	// 목록 보기
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.boardMapper.boardList", map);
	}

	// 상세보기
	public BoardDTO boardView(int seq) {
		return sqlSession.selectOne("mybatis.boardMapper.boardView", seq);
	}

	// 조회수 증가하기
	public int updateHit(int seq) {
		return sqlSession.update("mybatis.boardMapper.updateHit", seq);
	}

	// 글삭제
	public int boardDelete(int seq) {
		return sqlSession.delete("mybatis.boardMapper.boardDelete", seq);
	}

	// 총 데이터 갯수 구하기
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.boardMapper.getTotalA");
	}

	// 글 수정
	public int boardModify(BoardDTO dto) {
		return sqlSession.selectOne("mybatis.boardMapper.boardModify", dto);
	}
}
