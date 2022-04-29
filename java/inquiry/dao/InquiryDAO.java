package inquiry.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inquiry.bean.InquiryDTO;

@Repository
public class InquiryDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/* 목록보기 */
	public List<InquiryDTO> getInquiryList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSession.selectList("mybatis.inquiryMapper.getInquiryList", map);
	}
	
	/* 문의글 수 구하기 */
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.inquiryMapper.getTotalA");
	}
	
	/* 상세 데이터 1줄 불러오기 */
	public InquiryDTO viewInquiry(int inquiry_code) {
		return sqlSession.selectOne("mybatis.inquiryMapper.viewInquiry", inquiry_code);
	}
	
	/* 문의글 저장 */
	public int insertInquiry(InquiryDTO dto) {
		return sqlSession.insert("mybatis.inquiryMapper.insertInquiry", dto);
	}
	
	/* 기존 글의 re_seq값 정리 */
	public int insertReply1(int re_ref, int re_seq) {	
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("re_ref", re_ref);
		map.put("re_seq", re_seq);
		
		return sqlSession.update("mybatis.inquiryMapper.insertReply1", map);
	}
	
	/* 답글 저장 */
	public int insertReply2(InquiryDTO dto) {
		return sqlSession.insert("mybatis.inquiryMapper.insertReply2", dto);
	}
	
	/* 수정 */
	public int modifyInquiry(String inquiry_subject, String inquiry_content, int inquiry_code) {
		String inquiry_code_str = String.format("%d", inquiry_code);
		Map<String, String> map = new HashMap<String, String>();
		map.put("inquiry_subject", inquiry_subject);
		map.put("inquiry_content", inquiry_content);
		map.put("inquiry_code", inquiry_code_str);
		
		return sqlSession.update("mybatis.inquiryMapper.modifyInquiry", map);
	}
	
	/* 조회수 증가 */
	public int plusHit(int inquiry_code) {
		return sqlSession.update("mybatis.inquiryMapper.plusHit", inquiry_code);
	}
	
	/* 삭제 */
	public int deleteInquiry(int inquiry_code) {
		return sqlSession.delete("mybatis.inquiryMapper.deleteInquiry", inquiry_code);
	}
}
