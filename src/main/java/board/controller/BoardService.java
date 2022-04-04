package board.controller;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	public List<BoardDTO> boardList(int startNum, int endNum);
	public int getTotalA();
	public BoardDTO boardView(int seq);
	public int boardWrite(BoardDTO dto);
	public int boardDelete(int seq);
	public int updateHit(int seq);
}
