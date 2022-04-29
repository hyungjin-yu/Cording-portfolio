package review.controller;

import java.util.List;

import review.bean.ReviewDTO;

public interface ReviewService {
	public List<ReviewDTO> getReviewList(String item_code);
	public ReviewDTO getReviewDetail(int review_code);
	public int getTotalA(String item_code);
	public int insertReview(ReviewDTO dto);
	public int modifyReview(String review_content, int review_star, int review_code);
	public int deleteReview(int review_code);
}
