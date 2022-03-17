package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	ScoreDAOSpring dao;

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

}
