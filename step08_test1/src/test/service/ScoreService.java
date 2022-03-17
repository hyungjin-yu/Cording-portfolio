package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	public int insertScore(ScoreVO vo);
	public List<ScoreVO> getScoreList();
	public ScoreVO getScore(ScoreVO vo);
	public int updateScore(ScoreVO vo);
	public int deleteScore(ScoreVO vo);
}
