package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import profile.bean.ProfileDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/memberListJson.do")
	public ModelAndView memberListJson(HttpServletRequest request) throws Exception {
		// 1. 데이터 처리 코드
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		List<ProfileDTO> list = memberService.memberList(startNum, endNum);
		
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
				ProfileDTO dto = list.get(i);
				JSONObject temp = new JSONObject();
				temp.put("user_id", dto.getUser_id());
				temp.put("user_pwd", dto.getUser_pwd());
				temp.put("user_name", dto.getUser_name());
				temp.put("user_phone", dto.getUser_phone());
				temp.put("user_email", dto.getUser_email());
				temp.put("user_addr1", dto.getUser_addr1());
				temp.put("user_addr2", dto.getUser_addr2());
				temp.put("user_joindate", dto.getUser_joindate());
				temp.put("user_gender", dto.getUser_gender());
				temp.put("user_birth", dto.getUser_birth());
				
				items.put(i, temp);
			}
			
			json.put("items", items);
		}
		
		// json 데이터 확인
		//System.out.println("json : " + json);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("memberListJson.jsp");
		return modelAndView;
	}
	
	
	// memberList
	@RequestMapping(value = "/member/memberList.do")
	public ModelAndView memberList(HttpServletRequest request) {
		/* 데이터 처리 */
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		/* 페이징 처리 */
		int totalA = memberService.getTotalProfile(); // 총 회원수 구하기
		int totalP = (totalA + 4) / 5; // 총페이지수 구하기
		if (pg > totalP)
			pg = totalP;

		/* 목록보기 */
		// 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<ProfileDTO> list = memberService.memberList(startNum, endNum);

		// 3블럭 : 표시할 숫자를 3개만 사용
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		// endPage 값 보정
		if (endPage > totalP)
			endPage = totalP;

		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("req", "../member/memberList.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/member/memberListSearchByNameJson.do")
	public ModelAndView memberListSearchByNameJson(HttpServletRequest request) throws Exception {
		// 1. 데이터 처리 코드
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		String user_name = request.getParameter("user_name");
		
		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		List<ProfileDTO> list = memberService.memberListSearchByName(String.valueOf(startNum), String.valueOf(endNum), user_name);
		
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
				ProfileDTO dto = list.get(i);
				JSONObject temp = new JSONObject();
				temp.put("user_id", dto.getUser_id());
				temp.put("user_pwd", dto.getUser_pwd());
				temp.put("user_name", dto.getUser_name());
				temp.put("user_phone", dto.getUser_phone());
				temp.put("user_email", dto.getUser_email());
				temp.put("user_addr1", dto.getUser_addr1());
				temp.put("user_addr2", dto.getUser_addr2());
				temp.put("user_joindate", dto.getUser_joindate());
				temp.put("user_gender", dto.getUser_gender());
				temp.put("user_birth", dto.getUser_birth());
				
				items.put(i, temp);
			}
			
			json.put("items", items);
		}
		
		// json 데이터 확인
		//System.out.println("json : " + json);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("memberListSearchByNameJson.jsp");
		return modelAndView;
	}
	
	
	// memberList
	@RequestMapping(value = "/member/memberListSearchByName.do")
	public ModelAndView memberListSearchByName(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		/* 데이터 처리 */
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		String user_name = request.getParameter("user_name");
		System.out.println(user_name);
		/* 페이징 처리 */
		int totalA = memberService.getTotalProfileSearchByName(user_name); // 총 회원수 구하기
		int totalP = (totalA + 4) / 5; // 총페이지수 구하기
		if (pg > totalP)
			pg = totalP;

		/* 목록보기 */
		// 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<ProfileDTO> list = memberService.memberListSearchByName(String.valueOf(startNum), String.valueOf(endNum), user_name);

		// 3블럭 : 표시할 숫자를 3개만 사용
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		// endPage 값 보정
		if (endPage > totalP)
			endPage = totalP;

		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("user_name", user_name);
		modelAndView.addObject("req", "../member/memberListSearchByName.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}
	
	
	// memberView
	@RequestMapping(value = "/member/memberView.do")
	public ModelAndView memberView(HttpServletRequest request) {
		/* 데이터 처리 */
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// 상세보기용 1줄 데이터 얻어오기
		ProfileDTO dto = memberService.memberView(seq);

		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("dto", dto);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("req", "../member/memberView.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
		
		
	
	
}
