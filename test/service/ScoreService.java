package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	// 입력
	public int insertScore(ScoreVO vo);

	// 출력
	public List<ScoreVO> getScoreList();

	// 검색
	public ScoreVO getScore(ScoreVO vo);

	// 수정
	public int updateScore(ScoreVO vo);

	// 삭제
	public int deleteScore(ScoreVO vo);
}
