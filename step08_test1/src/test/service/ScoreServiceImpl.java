package test.service;

import java.util.List;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;

public class ScoreServiceImpl implements ScoreService{
	private ScoreDAOSpring dao;

	@Override
	public int insertScore(ScoreVO vo) {
		return dao.insertScore(vo);
	}

	@Override
	public List<ScoreVO> getScoreList() {
		return dao.getScoreList();
	}

	@Override
	public ScoreVO getScore(ScoreVO vo) {
		return dao.getScore(vo);
	}

	@Override
	public int updateScore(ScoreVO vo) {
		return dao.updateScore(vo);
	}

	@Override
	public int deleteScore(ScoreVO vo) {
		return dao.deleteScore(vo);
	}

	public ScoreDAOSpring getDao() {
		return dao;
	}

	public void setDao(ScoreDAOSpring dao) {
		this.dao = dao;
	}

}
