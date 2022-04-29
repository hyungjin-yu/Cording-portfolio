package notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import notice.bean.NoticeDTO;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 공지목록 보기
	public List<NoticeDTO> noticeList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSession.selectList("mybatis.noticeMapper.noticeList", map);
	}
	
	// 가장 최근 공지내용 보기
	public NoticeDTO noticeLatestView() {
		return sqlSession.selectOne("mybatis.noticeMapper.noticeLatestView");
	}
	
	// 공지내용 보기
	public NoticeDTO noticeView(int seq) {
		return sqlSession.selectOne("mybatis.noticeMapper.noticeView", seq);
	}
	
	// 총 데이터 개수 구하기
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.noticeMapper.getTotalA");
	}
	
	// 공지글 쓰기
	public int noticeWrite(NoticeDTO dto) {
		return sqlSession.insert("mybatis.noticeMapper.noticeWrite", dto);
	}
	
	// 공지글 수정
	public int noticeModify(NoticeDTO dto) {
		return sqlSession.update("mybatis.noticeMapper.noticeModify", dto);
	}
	
	// 공지글 삭제
	public int noticeDelete(int seq) {
		return sqlSession.delete("mybatis.noticeMapper.noticeDelete", seq);
	}
}
