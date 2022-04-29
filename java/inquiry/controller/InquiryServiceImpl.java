package inquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inquiry.bean.InquiryDTO;
import inquiry.dao.InquiryDAO;

@Service("inquiryService")
public class InquiryServiceImpl implements InquiryService {
	@Autowired
	private InquiryDAO dao;

	@Override
	public List<InquiryDTO> getInquiryList(int startNum, int endNum) {
		return dao.getInquiryList(startNum, endNum);
	}

	@Override
	public int getTotalA() {
		return dao.getTotalA();
	}

	@Override
	public InquiryDTO viewInquiry(int inquiry_code) {
		return dao.viewInquiry(inquiry_code);
	}

	@Override
	public int insertInquiry(InquiryDTO dto) {
		return dao.insertInquiry(dto);
	}

	@Override
	public int insertReply1(int re_ref, int re_seq) {
		return dao.insertReply1(re_ref, re_seq);
	}

	@Override
	public int insertReply2(InquiryDTO dto) {
		return dao.insertReply2(dto);
	}

	@Override
	public int modifyInquiry(String inquiry_subject, String inquiry_content, int inquiry_code) {
		return dao.modifyInquiry(inquiry_subject, inquiry_content, inquiry_code);
	}

	@Override
	public int plusHit(int inquiry_code) {
		return dao.plusHit(inquiry_code);
	}

	@Override
	public int deleteInquiry(int inquiry_code) {
		return dao.deleteInquiry(inquiry_code);
	}
}
