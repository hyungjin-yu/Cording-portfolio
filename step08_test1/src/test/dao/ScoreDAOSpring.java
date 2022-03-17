package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import test.bean.ScoreVO;

public class ScoreDAOSpring {
	private SqlSession sqlSession;
	
	public ScoreDAOSpring() {
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
	}
	
	public int insertScore(ScoreVO vo) {
		return sqlSession.insert("mybatis.scoreMapper.insertScore", vo);
	}
	
	public List<ScoreVO> getScoreList() {
		return sqlSession.selectList("mybatis.scoreMapper.getScoreList");
	}
	
	public int updateScore(ScoreVO vo) {
		return sqlSession.update("mybatis.scoreMapper.updateScore", vo);
	}
	
	public int deleteScore(ScoreVO vo) {
		return sqlSession.delete("mybatis.scoreMapper.deleteScore", vo);
	}
	
	public ScoreVO getScore(ScoreVO vo) {
		return (ScoreVO) sqlSession.selectOne("mybatis.scoreMapper.getScore", vo);
	}
}
