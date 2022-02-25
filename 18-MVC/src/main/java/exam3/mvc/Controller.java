package exam3.mvc;

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

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 요청정보와 데이터 처리 클래스를 쌍으로 저장할 Map 객체
	private Map<String, Object> map = new HashMap<String, Object>();
       
    public Controller() {
        super();
    }
    
    // init() 함수는 서블릿이 구동될 때 제일 먼저 호출되는 함수이다.
    // => 초기화 작업을 함
    // command.properties 파일에 등록된 요청정보와 그 요청정보에 동작되는 클래스를 생성하여 Map 객체에 저장한다.
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// command.properties 파일 위치 확인
    	String realFolder = config.getServletContext().getRealPath("./property");
    	String realPath = realFolder + "/command.properties";
    	
    	// properties을 관리하는 객체 생성
    	Properties properties = new Properties();
    	FileInputStream fis = null;
    	try {
			fis = new FileInputStream(realPath);
			properties.load(fis);						// command.properties 파일의 내용을 읽어와서 저장함
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
    	
    	// Iterator 객체 얻어오기
    	// properties.keySet() : command.properties 파일의 "=" 왼쪽의 문자열을 Set 객체로 읽어옴
    	Iterator<?> iterator = properties.keySet().iterator();
    	
    	// 1) "=" 왼쪽의 문자열과 "=" 오른쪽의 문자열을 추가하기
    	// 2) "=" 오른쪽의 문자열의 클래스 이름으로 객체 생성
    	// 3) Map 객체에 저장 : map.put(key, data) => map.put("요청문자열", 데이터처리 객체)
    	while(iterator.hasNext()) {
    		// 1) "=" 왼쪽의 문자열과 "=" 오른쪽의 문자열을 추가하기
    		String command = (String) iterator.next();			// "=" 왼쪽의 문자열
    		String className = properties.getProperty(command);	// "=" 오른쪽의 문자열 
    		// 동작 확인
    		System.out.println("command = " + command);
    		System.out.println("className = " + className);
    		
    		// 2) "=" 오른쪽의 문자열의 클래스 이름으로 객체 생성
    		// 3) Map 객체에 저장 : map.put(key, data) => map.put("요청문자열", 데이터처리 객체)
    		try {
    			// 클래스가 존재하는지 검사하고, 존재하면 그 클래스 정보를 저장한 Class 객체 리턴
				Class<?> commandClass = Class.forName(className);
				// 객체 생성
				Object object = commandClass.newInstance();
				// map 객체에 저장
	    		map.put(command, object);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
    		System.out.println(map.toString());
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 정보 확인
		String command = request.getParameter("command");
		
		// 2. 요청 작업 처리
		// => 데이터 처리 클래스 선택
		Action action = (Action)map.get(command);
		
		// 3. 데이터 처리 + view 처리 파일 선택
		String view = null;
		try {
			view = action.process(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 4. view 처리 파일로 이동
		if(view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}
