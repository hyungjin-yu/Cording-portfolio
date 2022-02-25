package exam4.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class ControllerURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();
       
    public ControllerURI() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	String realFolder = config.getServletContext().getRealPath("./property");
    	String realPath = realFolder + "/commandURI.properties";
    	
    	// 1. properties 파일 읽기
    	Properties properties = new Properties();
    	FileInputStream fis = null;
    	try {
			fis = new FileInputStream(realPath);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
    	// 2. properties 파일에 설정된 대로 command와 객체를 Map 객체에 저장
    	Iterator<?> iterator = properties.keySet().iterator();
    	
    	while(iterator.hasNext()) {
    		String command = (String) iterator.next();
    		String className = properties.getProperty(command);
    		
    		try {
				Class<?> commandClass = Class.forName(className);
				Object object = commandClass.newInstance();
				
				map.put(command, object);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
    	}
    	
    	// map 객체에 저장된 내용 확인
    	System.out.println(map.toString());
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 정보 확인
		String command = request.getRequestURI();
		// command = /18-MVC/exam4/message.do
		System.out.println("command = " + command);
		
		// 프로젝트명 추출
		// contextPath = /18-MVC
		String contextPath = request.getContextPath();
		System.out.println("contextPath = " + contextPath);
		
		// 문자열 길이 구하기
		int length = contextPath.length();		
		
		// command 변수값 수정
		// => command = /exam4/message.do
		command = command.substring(length);
		System.out.println("command = " + command);
		
		// 2. 요청 작업 처리
		Action action = (Action)map.get(command);
		
		// 3. 데이터 처리 + view 처리 파일 선택
		String view = null;
		if(action != null) {
			try {
				view = action.process(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 4. view 처리 파일 이동
		if(view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}
