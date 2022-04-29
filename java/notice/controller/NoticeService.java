package notice.controller;

import java.util.List;

import notice.bean.NoticeDTO;

public interface NoticeService {
	public List<NoticeDTO> noticeList(int startNum, int endNum);	// 공지목록 보기
	public NoticeDTO noticeLatestView();	// 가장 최근 공지내용 보기
	public NoticeDTO noticeView(int seq);	// 공지내용 보기
	public int getTotalA();					// 총 데이터 개수 구하기
	public int noticeWrite(NoticeDTO dto);	// 공지글 쓰기
	public int noticeModify(NoticeDTO dto);	// 공지글 수정
	public int noticeDelete(int seq);		// 공지글 삭제
}
