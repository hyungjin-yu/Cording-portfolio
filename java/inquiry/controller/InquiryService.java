package inquiry.controller;

import java.util.List;

import inquiry.bean.InquiryDTO;

public interface InquiryService {
	public List<InquiryDTO> getInquiryList(int startNum, int endNum);
	public int getTotalA();
	public InquiryDTO viewInquiry(int inquiry_code);
	public int insertInquiry(InquiryDTO dto);
	public int insertReply1(int re_ref, int re_seq);
	public int insertReply2(InquiryDTO dto);
	public int modifyInquiry(String inquiry_subject, String inquiry_content, int inquiry_code);
	public int plusHit(int inquiry_code);
	public int deleteInquiry(int inquiry_code);
}
