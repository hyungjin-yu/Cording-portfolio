package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.dao.MemberDAO;


@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/member/checkId.do")
	public ModelAndView checkId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");

		// DB : id가 있는 지 검사
		MemberDAO dao = new MemberDAO();
		boolean exist = dao.isExistId(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id",id);
		modelAndView.setViewName("checkId.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/delete.do")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("memId");
		
		// DB에서 데이터 삭제
		MemberDAO dao = new MemberDAO();
		int result = dao.delete(id);
		
		// 세션 삭제
		if(result>0) {
			session.removeAttribute("memName");
			session.removeAttribute("memId");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result",result);
		modelAndView.setViewName("delete.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/deleteForm.do")
	public ModelAndView deleteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("deleteForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		// 브라우저로부터 전달된 데이터 읽기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB처리	
		MemberDAO dao = new MemberDAO();
		String name = dao.login(id, pwd);
		
		// 페이지 이동
		if(name != null) {
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			
			response.sendRedirect("loginOk.do");
		} else {			// 로그인 실패
			response.sendRedirect("loginFail.do");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/loginFail.do")
	public ModelAndView loginFail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("loginFail.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("loginForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/loginOk.do")
	public ModelAndView loginOk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		// 3. 세션에 저장된 데이터 받기
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id",id);
		modelAndView.addObject("name",name);
		modelAndView.setViewName("loginOk.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		// 2. 세션 삭제
		session.removeAttribute("memName");
		session.removeAttribute("memId");
		
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("logout.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/memberList.do")
	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		String id = (String) session.getAttribute("memId");
		
		// 1페이지당 5개 목록 출력
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectList(startNum, endNum);
			
		// 페이징 처리
		int totalA = dao.getTotalMember();	// 총 회원수 구하기
		int totalP = (totalA + 4) / 5;		// 총 페이지수 구하기
			 
		// 3블럭씩 숫자 표시
		int startPage = (pg-1)/3*3 + 1;
		int endPage = startPage + 2;	
		if(endPage > totalP) endPage = totalP; // endPage값 보정

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("endNum",endNum);
		modelAndView.addObject("startNum",startNum);
		modelAndView.addObject("list",list);
		modelAndView.addObject("totalP",totalP);
		modelAndView.setViewName("memberList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/modify.do")
	public ModelAndView modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		// 브라우저로부터 전달된 데이터 읽기
		String id = (String)session.getAttribute("memId"); 
		String pwd = request.getParameter("pwd");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		
		// DB처리 
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		dto.setTel1(tel1);
		dto.setTel2(tel2);
		dto.setTel3(tel3);
		dto.setAddr(addr);
		
		//System.out.println(dto.toString());
		
		MemberDAO dao = new MemberDAO();
		int result = dao.modify(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dao",dao);
		modelAndView.addObject("dto",dto);
		modelAndView.setViewName("modify.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		// 회원 1명에 대한 데이터 읽어오기
		String id = (String) session.getAttribute("memId");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto",dto);
		modelAndView.setViewName("modifyForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/write.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 데이터 처리
		request.setCharacterEncoding("utf-8"); // 한글 인코딩 설정
		// 브라우저로부터 전달된 데이터 읽기
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		
		// DB 처리
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setGender(gender);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		dto.setTel1(tel1);
		dto.setTel2(tel2);
		dto.setTel3(tel3);
		dto.setAddr(addr);
		
		MemberDAO dao = new MemberDAO();
		int result = dao.write(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result",result);
		modelAndView.setViewName("write.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/writeForm.do")
	public ModelAndView writeForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
	
		modelAndView.setViewName("writeForm.jsp");
		return modelAndView;
	}
}
