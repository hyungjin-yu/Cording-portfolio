package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

    public DispatcherServlet() {
    	super();
    }
    
    @Override
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 정보 추출
		String uri = request.getServletPath();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("uri = " + uri); 
		System.out.println("path = " + path); 
		
		// 2. 데이터 처리 클래스 선택
		Controller controller = handlerMapping.getController(path);
		
		// 3. 데이터 처리 함수 호출
		String viewName = controller.handleRequest(request, response);
		
		// 4. ViewResolver클래스를 통해 view 처리 파일 이름 완성
		String viewPage = null;
		if(viewName != null) {
			viewPage = viewResolver.getView(viewName);
		}
		
		// 5. view 처리 파일로 이동
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
