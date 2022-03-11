package Book;

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
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> map = new HashMap<String, Object>();
	
    public BookController() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	String realFolder = config.getServletContext().getRealPath("properties");
    	String realPath = realFolder + "/command.properties";
    	
    	// Properties 객체 생성
    	Properties properties = new Properties();
    	FileInputStream fis = null;
    	try {
			fis = new FileInputStream(realPath);
			properties.load(fis);   // 파일 읽어오기
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
    	// 2. 요청명령어와 데이터처리 객체를 생성해서 map 객체에 저장하기
    	Iterator<?> iterator = properties.keySet().iterator();
    	
    	while(iterator.hasNext()) {
    		String command = (String) iterator.next();
    		String className = properties.getProperty(command);
    		//System.out.println("command = " + command);
    		//System.out.println("className = " + className);
    			
    		try {
				Class<?> commandClass = Class.forName(className); 
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
    	}
    	// map 객체 확인
    	//System.out.println(map.toString());
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 1. 요청 정보 확인
		String command = request.getServletPath();
		System.out.println("command2 = " + command);
				
		// 2. 데이터 처리 클래스 선택
		String view = null;
		Action action = null;
				
		action = (Action)map.get(command);		// 오류 부분
		System.out.println("action = " + action);
		
		// 3. 데이터 처리 및 view 처리파일명 리턴
		if(action != null) {
			try {
				view = action.execute(request, response);
				System.out.println("view = " + view);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		// 4. 화면 이동
		if(view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}
