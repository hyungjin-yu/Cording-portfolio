package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import notice.bean.NoticeDTO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/notice/noticeListJson.do")
	public ModelAndView noticeListJson(HttpServletRequest request) throws Exception {
		// 1. 데이터 처리 코드
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		List<NoticeDTO> list = noticeService.noticeList(startNum, endNum);
		
		// JSON으로 결과값 반환
		String rt = null;	// rt : result
		int total = list.size();
		
		if(total > 0) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("total", total);
		
		if(total > 0) {
			JSONArray items = new JSONArray();
			
			for(int i=0; i<list.size(); i++) {
				NoticeDTO dto = list.get(i);
				JSONObject temp = new JSONObject();
				//temp.put("notice_seq", dto.getNotice_seq());
				temp.put("notice_date", dto.getNotice_date());
				temp.put("notice_title", dto.getNotice_title());
				temp.put("notice_content", dto.getNotice_content());
				
				items.put(i, temp);
			}
			
			json.put("items", items);
		}
		
		// json 데이터 확인
		//System.out.println("json : " + json);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("noticeListJson.jsp");
		return modelAndView;
	}
	
	// noticeList
	@RequestMapping(value = "/notice/noticeList.do")
	public ModelAndView noticeList(HttpServletRequest request) {
		// 세션에 저장된 데이터 받기
		HttpSession session = request.getSession();
		String sessionName = (String)session.getAttribute("login_name");
		String sessionId = (String)session.getAttribute("login_id");
		
		/* 데이터 처리 */
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		/* 페이징 처리 */
		int totalA = noticeService.getTotalA(); // 총글수 구하기
		int totalP = (totalA + 4) / 5; // 총페이지수 구하기
		if (pg > totalP)
			pg = totalP;
		
		/* 목록보기 */
		// 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<NoticeDTO> list = noticeService.noticeList(startNum, endNum);
		// 3블럭 : 표시할 숫자를 3개만 사용
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		// endPage 값 보정
		if (endPage > totalP)
			endPage = totalP;
		
		// 가장 최근 공지글 데이터 얻어오기
		//NoticeDTO nlvDTO = noticeService.noticeLatestView();
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("sessionId", sessionId);
		modelAndView.addObject("sessionName", sessionName);
		
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("req", "../notice/noticeList.jsp");
		
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}

	// noticeWriteForm
	@RequestMapping(value = "/notice/noticeWriteForm.do")
	public ModelAndView noticeWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../notice/noticeWriteForm.jsp");

		return modelAndView;
	}
	
	// noticeWrite
	@RequestMapping(value="/notice/noticeWrite.do")
	public ModelAndView noticeWrite(HttpServletRequest request) throws IOException {
		/* 데이터 처리 */
		request.setCharacterEncoding("utf-8");
		
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content").replace("\r\n","<br>");
		// 세션에 저장된 데이터 받기
		HttpSession session = request.getSession();
		String admin_name = (String)session.getAttribute("login_name");
		String admin_id = (String)session.getAttribute("login_id");

		// DB 처리
		NoticeDTO dto = new NoticeDTO();
		dto.setNotice_title(notice_title);
		dto.setNotice_content(notice_content);
		
		int result = noticeService.noticeWrite(dto);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("result", result);
		//modelAndView.addObject("req", "../notice/noticeList.jsp");
		//modelAndView.addObject("req_notice", "../notice/noticeWrite.jsp");
		modelAndView.setViewName("../notice/noticeWrite.jsp");
		return modelAndView;
	}
	
	// noticeLatestView
	@RequestMapping(value = "/notice/noticeLatestView.do")
	public ModelAndView noticeLatestView(HttpServletRequest request) {
		
		// 가장 최근 공지글 데이터 얻어오기
		NoticeDTO dto = noticeService.noticeLatestView();
		//System.out.println("dto:"+dto.getNotice_title());
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("../notice/noticeLatestView.jsp");
		
		return modelAndView;
	}
	
	// noticeView
	@RequestMapping(value = "/notice/noticeView.do")
	public ModelAndView noticeView(HttpServletRequest request) {
		/* 데이터 처리 */
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		// 상세보기용 1줄 데이터 얻어오기
		NoticeDTO dto = noticeService.noticeView(seq);

		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("dto", dto);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("req", "../notice/noticeList.do");
		modelAndView.addObject("req_notice", "../notice/noticeView.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// noticeModifyForm
	@RequestMapping(value="/notice/noticeModifyForm.do")
	public ModelAndView noticeModifyForm(HttpServletRequest request) {
		/* 데이터 처리 */
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// noticeModifyForm.jsp에 보여줄 데이터 필요
		NoticeDTO dto = noticeService.noticeView(seq);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req", "../notice/noticeModifyForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// noticeModify
	@RequestMapping(value="/notice/noticeModify.do")
	public ModelAndView noticeModify(HttpServletRequest request) throws IOException {
		/* 데이터 처리 */
		request.setCharacterEncoding("utf-8");

		int seq = Integer.parseInt(request.getParameter("seq"));
		//int pg = Integer.parseInt(request.getParameter("pg"));
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content").replace("\r\n","<br>");
		
		// DB처리
		NoticeDTO dto = new NoticeDTO(); 	
		dto.setNotice_seq(seq);
		dto.setNotice_title(notice_title);
		dto.setNotice_content(notice_content);
		
		int result = noticeService.noticeModify(dto);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();	
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../notice/noticeModify.jsp");
		
		return modelAndView;
	}
	
	// noticeDelete
	@RequestMapping(value="/notice/noticeDelete.do")
	public ModelAndView noticeDelete(HttpServletRequest request) {
		/* 데이터 처리 */
		int seq = Integer.parseInt(request.getParameter("seq"));
		//int pg = Integer.parseInt(request.getParameter("pg"));
		
		int result = noticeService.noticeDelete(seq);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("seq", seq);
		//modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../notice/noticeDelete.jsp");
		
		return modelAndView;
	}
	
	// bodyNotice
	@RequestMapping(value="/main/bodyNotice.do")
	public ModelAndView bodyNotice() {
		// 가장 최근 공지글 데이터 얻어오기
		NoticeDTO dto = noticeService.noticeLatestView();
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("../main/bodyNotice.jsp");
				
		return modelAndView;
	}
}
