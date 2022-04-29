package profile.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.System.Logger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import profile.bean.ProfileDTO;
import profile.dao.ProfileDAO;

@Controller
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	// profileMain
	@RequestMapping(value = "/signin/profileMain.do")
	public ModelAndView profileMain() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req", "../signin/profileMain.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// 회원가입폼 registerForm
	/*
	@RequestMapping(value = "/signin/registerForm.do")
	public ModelAndView registerForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req", "../signin/registerForm.jsp");
		modelAndView.setViewName("../signin/profileMain.jsp");

		return modelAndView;
	}
	*/
	
	// 회원가입 register
	@RequestMapping(value = "/signin/register.do")
	public ModelAndView register(HttpServletRequest request) throws  IOException {
		// 데이터 처리
		request.setCharacterEncoding("utf-8");

		// DB
		ProfileDTO dto = new ProfileDTO();
		dto.setUser_id(request.getParameter("user_id"));
		dto.setUser_pwd(request.getParameter("user_pwd"));
		dto.setUser_name(request.getParameter("user_name"));
		dto.setUser_phone(request.getParameter("user_phone"));
		dto.setUser_email(request.getParameter("user_email"));
		dto.setUser_addr1(request.getParameter("roadFullAddr"));
		dto.setUser_addr2(request.getParameter("addrDetail"));
		dto.setUser_gender(request.getParameter("user_gender_val"));
		dto.setUser_birth(request.getParameter("user_birth"));
		
		//System.out.println(dto.getUser_gender());
		
		int result = profileService.register(dto);

		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../signin/register.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// 로그인폼 signinForm
	/*
	@RequestMapping(value = { "/signin/signinForm.do" }, method = { RequestMethod.POST })
	public ModelAndView loginForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../signin/signinForm.jsp");

		return modelAndView;
	}
	*/
	
	// 로그인 signin
	@RequestMapping(value = "/signin/signin.do")
	public ModelAndView signin(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		/* 데이터 처리 */
		request.setCharacterEncoding("utf-8");	
		
		// 브라우저로부터 전달된 데이터 읽기
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		// DB처리
		String user_name = profileService.signin(user_id, user_pwd);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		
		if(user_name != null){ //로그인성공
			HttpSession session = request.getSession();
			
			session.setAttribute("login_name", user_name);	// 세션 이름과 회원 이름 구분짓기
			session.setAttribute("login_id", user_id);		// 세션 아이디와 회원 아이디 구분짓기
			
			modelAndView.setViewName("../main/index.jsp");
		} else {	//로그인실패
			modelAndView.setViewName("../signin/signinFail.jsp");
		}
		return modelAndView;
	}

	// 로그아웃 logout
	@RequestMapping(value = "/signin/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		/* 데이터 처리 */
		HttpSession session = request.getSession();
		session.removeAttribute("login_name");
		session.removeAttribute("login_id");

		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../signin/logout.jsp");

		return modelAndView;
	}
	
	// 아이디 중복여부 체크 checkId
	//@RequestMapping(value = "/signin/checkId.do")
	//public ModelAndView checkId(HttpServletRequest request) {
		/* 데이터 처리 */
		//String user_id = request.getParameter("user_id");

		// DB : id가 있는 지 검사
		//boolean exist = profileService.isExistId(user_id); // true: id가 존재함, false: id가 존재하지 않음

		/* 화면 네비게이션 */
		//ModelAndView modelAndView = new ModelAndView();

		//modelAndView.addObject("user_id", user_id);
		//modelAndView.addObject("exist", exist);
		//modelAndView.setViewName("../signin/checkId.jsp");

		//return modelAndView;
	//}

	// 마이페이지 수정폼 mypageForm
	@RequestMapping(value = "/mypage/mypageForm.do")
	public ModelAndView mypageForm(HttpServletRequest request) {
		/* 데이터 처리 */
		// 회원 1명에 대한 데이터 읽어오기
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("login_id");

		ProfileDTO dto = profileService.getMember(user_id);

		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req", "../mypage/mypageForm.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// 마이페이지 회원정보 수정 mypage
		@RequestMapping(value = "/mypage/mypage.do")
		public ModelAndView mypage(HttpServletRequest request) throws IOException {
			/* 데이터 처리 */
			request.setCharacterEncoding("utf-8");
			// 브라우저로부터 전달된 데이터 읽기
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("login_id");
			String user_pwd = request.getParameter("user_pwd");
			String user_name = request.getParameter("user_name");
			String user_phone = request.getParameter("user_phone");
			String user_email = request.getParameter("user_email");
			String user_addr1 = request.getParameter("roadFullAddr");
			String user_addr2 = request.getParameter("addrDetail");
			String user_gender = request.getParameter("user_gender");
			String user_birth = request.getParameter("user_birth");

			// DB처리
			ProfileDTO dto = new ProfileDTO();
			dto.setUser_id(user_id);
			dto.setUser_pwd(user_pwd);
			dto.setUser_name(user_name);
			dto.setUser_phone(user_phone);
			dto.setUser_email(user_email);
			dto.setUser_addr1(user_addr1);
			dto.setUser_addr2(user_addr2);
			dto.setUser_gender(user_gender);
			dto.setUser_birth(user_birth);

			int result = profileService.mypage(dto);

			/* 화면 네비게이션 */
			ModelAndView modelAndView = new ModelAndView();

			modelAndView.addObject("result", result);
			modelAndView.addObject("req", "../mypage/mypage.jsp");
			modelAndView.setViewName("../main/index.jsp");
			return modelAndView;
		}
		
		
	// 회원탈퇴 withdrawalForm
		@RequestMapping(value = "/mypage/withdrawalForm.do")
	public ModelAndView withdrawalForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req", "../mypage/withdrawalForm.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// 회원탈퇴 withdrawal
	@RequestMapping(value = "/mypage/withdrawal.do")
	public ModelAndView withdrawal(HttpServletRequest request) {

		/* 데이터 처리 */
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("login_id");

		// DB에서 데이터 삭제
		int result = profileService.withdrawal(user_id);

		// 세션 삭제
		if (result > 0) {
			session.removeAttribute("login_name");
			session.removeAttribute("login_id");
		}

		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../mypage/withdrawal.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}

	// 아이디/ 비번 찾기 폼
	@RequestMapping(value = "/forgetprofile/findMain.do")
	public ModelAndView findMain() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req", "../forgetprofile/findMain.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;	
	}
	
	
	// 아이디찾기 폼 findIdForm
	@RequestMapping(value = "/forgetprofile/findIdForm.do")
	public ModelAndView findIdForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req", "../forgetprofile/findIdForm.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}
	
	// 아이디찾기 findId
	@RequestMapping(value = "/forgetprofile/findId.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/* 데이터 처리 */
		request.setCharacterEncoding("utf-8");
		
		// 브라우저로부터 전달된 데이터 읽기
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");

		// DB처리
		String user_id = profileService.findId(user_name, user_email);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		
		// 페이지 이동
		if (user_id != null) {
			modelAndView.addObject("user_id", user_id);
			modelAndView.setViewName("../forgetprofile/findId.jsp");
		} else { // 일치정보 없음
			modelAndView.setViewName("../forgetprofile/FindIdFail.jsp");
		}
		return modelAndView;
	}

	 //비밀번호찾기 폼 findPwdForm
	 @RequestMapping(value="/forgetprofile/findPwdForm.do")
	 public ModelAndView findPwdForm() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("req", "../forgetprofile/findPwdForm.jsp");
			modelAndView.setViewName("../main/index.jsp");

			return modelAndView;
		}
	 
	 //비밀번호찾기 findPwd
	 @RequestMapping(value="/forgetprofile/findPwd.do")
	 public ModelAndView findPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
			/* 데이터 처리 */
			request.setCharacterEncoding("utf-8");

			// 브라우저로부터 전달된 데이터 읽기
			String user_id = request.getParameter("user_id");
			String user_name = request.getParameter("user_name");
			String user_email = request.getParameter("user_email");

			// DB처리
			boolean result = profileService.findPwd(user_id, user_name, user_email);
			//System.out.println("result = " + result);
			
			/* 화면 네비게이션 */
			ModelAndView modelAndView = new ModelAndView();
			
			// 일치정보 있을경우
			if(result) {
				modelAndView.addObject("user_id", user_id);
				modelAndView.addObject("req", "../forgetprofile/findPwd.jsp");
				modelAndView.setViewName("../main/index.jsp");
			} else { // 일치정보 없음			
				modelAndView.setViewName("../forgetprofile/FindPwdFail.jsp");
			}
			return modelAndView;
	 }

	// findPwdReset 비밀번호 초기화
	 @RequestMapping(value = "/forgetprofile/findPwdReset.do")
			public ModelAndView findPwdReset(HttpServletRequest request) throws IOException {
				/* 데이터 처리 */
				request.setCharacterEncoding("utf-8");
				String user_id = request.getParameter("user_id");
				String user_pwd = request.getParameter("user_pwd");
		
				// DB처리
				ProfileDTO dto = new ProfileDTO();
				dto.setUser_pwd(user_pwd);
				dto.setUser_id(user_id);

				int result = profileService.findPwdReset(dto);
				
				/* 화면 네비게이션 */
				ModelAndView modelAndView = new ModelAndView();

				modelAndView.addObject("result", result);

				modelAndView.setViewName("../forgetprofile/findPwdReset.jsp");
				return modelAndView;
			}
			
}