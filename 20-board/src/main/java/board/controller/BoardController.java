package board.controller;

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

import board.action.Action;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 요청명령어와 데이터처리 클래스를 쌍으로 저장할 Map 객체 생성
	private Map<String, Object> map = new HashMap<String, Object>();
	
    public BoardController() {
        super();
    }
    
    // properties 파일에 설정된대로 요청명령어와 데이터 처리 클래스를 쌍으로 map객체에 저장
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// 1. properties 파일 읽어오기
    	// "property" 폴더 위치 찾기
    	String realFolder = config.getServletContext().getRealPath("property");
    	String realPath = realFolder + "/command.properties";
    	
    	// Properties 객체 생성
    	Properties properties = new Properties();
    	FileInputStream fis = null;
    	try {
			fis = new FileInputStream(realPath);
			properties.load(fis);	// 파일 읽어오기
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
    		String command = (String) iterator.next();	// "=" 왼쪽값 읽기
    		String className = properties.getProperty(command);	// "=" 오른쪽값 읽기
    		
    		try {
				Class<?> commandClass = Class.forName(className);	// 클래스가 있는 지 확인
				Object object = commandClass.newInstance();		// 객체 생성
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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProccess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProccess(request, response);
	}
	
	protected void doProccess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1. 요청 정보 확인
		String command = request.getServletPath();
		
		// 2. 데이터 처리 클래스 선택
		String view = null;
		Action action = null;
		
		action = (Action)map.get(command);
		
		// 3. 데이터 처리 및 view 처리파일명 리턴
		if(action != null){
			try {
				view = action.execute(request, response);
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



























