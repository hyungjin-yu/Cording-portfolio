package inquiry.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import inquiry.bean.InquiryDTO;

@Controller
public class InquiryController {
	@Autowired
	private InquiryService inquiryService;
	
	@RequestMapping(value="/item/inquiryList.do")
	public ModelAndView inquiryList(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		// 페이징 처리
		int totalA = inquiryService.getTotalA();
		int totalP = (totalA + 9) / 10;
		if(pg > totalP) pg = totalP;
		
		// 목록 보기
		int endNum = pg * 10;
		int startNum = endNum - 9;
		
		List<InquiryDTO> list = inquiryService.getInquiryList(startNum, endNum);
		
		// 3블럭
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("req", "../item/inquiry.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}
	
	@RequestMapping(value="/item/inquiryView.do")
	public ModelAndView inquiryView(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		int inquiry_code = Integer.parseInt(request.getParameter("inquiry_code"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// 조회수 증가하기
		inquiryService.plusHit(inquiry_code);
		// 상세 데이터 1줄 가져오기
		InquiryDTO dto = inquiryService.viewInquiry(inquiry_code);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req", "../item/inquiryView.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/item/inquiryWrite.do")
	public ModelAndView inquiryWrite(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("login_id");		
		
		String inquiry_subject = request.getParameter("inquiry_subject");
		String inquiry_content = request.getParameter("inquiry_content");
		
		InquiryDTO dto = new InquiryDTO();
		dto.setUser_id(user_id);
		dto.setInquiry_subject(inquiry_subject);
		dto.setInquiry_content(inquiry_content);
		
		int result = inquiryService.insertInquiry(dto);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../item/inquiryWrite.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/item/inquiryModifyForm.do")
	public ModelAndView inquiryModifyForm(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		int inquiry_code = Integer.parseInt(request.getParameter("inquiry_code"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		InquiryDTO dto = inquiryService.viewInquiry(inquiry_code);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("inquiry_code", inquiry_code);
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req", "../item/inquiryModifyForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/item/inquiryModify.do")
	public ModelAndView inquiryModify(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		int inquiry_code = Integer.parseInt(request.getParameter("inquiry_code"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String inquiry_subject = request.getParameter("inquiry_subject");
		String inquiry_content = request.getParameter("inquiry_content");
		
		int result = inquiryService.modifyInquiry(inquiry_subject, inquiry_content, inquiry_code);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("inquiry_code", inquiry_code);
		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../item/inquiryModify.jsp");
		
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/item/inquiryDelete.do")
	public ModelAndView inquiryDelete(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		int inquiry_code = Integer.parseInt(request.getParameter("inquiry_code"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		int result = inquiryService.deleteInquiry(inquiry_code);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("inquiry_code", inquiry_code);
		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../item/inquiryDelete.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/item/inquiryReply.do")
	public ModelAndView inquiryReply(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		int inquiry_code = Integer.parseInt(request.getParameter("inquiry_code"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 답글 내용
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("login_id");
		
		String inquiry_subject = request.getParameter("inquiry_subject");
		String inquiry_content = request.getParameter("inquiry_content");
		
		// 기존글의 re_ref, re_lev, re_seq 값 가져오기 => +1해서 답글 저장
		InquiryDTO dto_origin = inquiryService.viewInquiry(inquiry_code);
		int re_ref = dto_origin.getRe_ref();
		int re_lev = dto_origin.getRe_lev();
		int re_seq = dto_origin.getRe_seq();
		
		// 기존글의 re_seq값 정리
		inquiryService.insertReply1(re_ref, re_seq);
		
		// 답글 저장
		InquiryDTO dto_reply = new InquiryDTO();
		dto_reply.setUser_id(user_id);
		dto_reply.setInquiry_subject(inquiry_subject);
		dto_reply.setInquiry_content(inquiry_content);
		dto_reply.setRe_ref(re_ref);
		dto_reply.setRe_lev(re_lev + 1);
		dto_reply.setRe_seq(re_seq + 1);
		
		int result = inquiryService.insertReply2(dto_reply);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("inquiry_code", inquiry_code);
		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../item/inquiryReply.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
}
