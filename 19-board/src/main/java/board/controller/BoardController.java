package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoardListAction;
import board.action.BoardWriteProAction;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 	// 한글 인코딩 설정
		
		// 1. 요청 정보 확인
		String command = request.getServletPath();
		// "boardWriteForm.do"
		// System.out.println("command = " + command);
		
		// 2. 요청 작업 처리 클래스 선택
		String forward = null;
		Action action = null;
		if(command.equals("/boardWriteForm.do")) {
			forward = "/board/boardWriteForm.jsp";
		} else if(command.equals("/boardWritePro.do")) {
			action = new BoardWriteProAction();
		} else if(command.equals("/boardList.do")) {
			action = new BoardListAction();
		}
		
		// 3. 요청 작업 처리
		if(action != null) {
			try {
				forward = action.exeute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 4. 화면 이동
		if(forward != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		}
	}
}
