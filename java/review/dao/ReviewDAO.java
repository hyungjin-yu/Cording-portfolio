package review.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import review.bean.ReviewDTO;

@Repository
public class ReviewDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/* 목록보기 */
	/*public List<ReviewDTO> getReviewList(int startNum, int endNum, String item_code) {
		String startNum_str = String.format("%d", startNum);
		String endNum_str = String.format("%d", endNum);
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", startNum_str);
		map.put("endNum", endNum_str);
		map.put("item_code", item_code);
		
		return sqlSession.selectList("mybatis.reviewMapper.getReviewList", map);
	}*/
	
	public List<ReviewDTO> getReviewList(String item_code) {
		return sqlSession.selectList("mybatis.reviewMapper.getReviewList", item_code);
	}
	
	/* 상세 데이터 1줄 뽑기 */
	public ReviewDTO getReviewDetail(int review_code) {
		return sqlSession.selectOne("mybatis.reviewMapper.getReviewDetail", review_code);
	}
	
	/* 특정 상품의 전체 리뷰글 수 구하기 */
	public int getTotalA(String item_code) {
		return sqlSession.selectOne("mybatis.reviewMapper.getTotalA", item_code);
	}
	
	/* 리뷰글 등록 */
	public int insertReview(ReviewDTO dto) {
		return sqlSession.insert("mybatis.reviewMapper.insertReview", dto);
	}
	
	/* 리뷰글 수정 */
	public int modifyReview(String review_content, int review_star, int review_code) {
		String review_star_str = String.format("%d", review_star);
		String review_code_str = String.format("%d", review_code);
		Map<String, String> map = new HashMap<String, String>();
		map.put("review_content", review_content);
		map.put("review_star", review_star_str);
		map.put("review_code", review_code_str);
		
		return sqlSession.update("mybatis.reviewMapper.modifyReview", map);
	}
	
	/* 리뷰글 삭제 */
	public int deleteReview(int review_code) {
		return sqlSession.delete("mybatis.reviewMapper.deleteReview", review_code);
	}
}
