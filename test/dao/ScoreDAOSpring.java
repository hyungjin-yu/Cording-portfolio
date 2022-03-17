package test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository("dao")
public class ScoreDAOSpring {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 입력
	public int insertScore(ScoreVO vo) {
		return sqlSession.insert("mybatis.scoreMapper.insertScore", vo);
	}

	// 출력
	public List<ScoreVO> getScoreList() {
		return sqlSession.selectList("mybatis.scoreMapper.getScoreList");
	}

	// 검색
	public ScoreVO getScore(ScoreVO vo) {
		return sqlSession.selectOne("mybatis.scoreMapper.getScore", vo);
	}

	// 수정
	public int updateScore(ScoreVO vo) {
		return sqlSession.update("mybatis.scoreMapper.updateScore", vo);
	}

	// 삭제
	public int deleteScore(ScoreVO vo) {
		return sqlSession.delete("mybatis.scoreMapper.deleteScore", vo);
	}
}
