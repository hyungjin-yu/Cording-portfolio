package admin;

import java.sql.Connection;
import java.util.List;

import apply.ApplyDTO;

public interface Admin {
	public Connection getConnection();		// db와 연결
	public void close();					// db와 연결 끊기
	public int isEmpty(String get_date);	// 해당 날짜 칸이 빈 칸인지 확인
	public List<AdminDTO> allWorkdays();	// 알바 등록이 된 모든 날짜들
	public int insert(AdminDTO dto);		// 알바 정보 입력
	public int edit(AdminDTO dto);			// 알바 정보 수정
	public int delete(String date);			// 알바 정보 삭제
	public List<AdminDTO> adminList(String get_date);	// 하는 일 상세정보
	public List<ApplyDTO> applyList(String get_date);	// 신청자 목록
	public int status(String date, String id, int applyStatus, int approveStatus);	// 승인 or 거절
}
