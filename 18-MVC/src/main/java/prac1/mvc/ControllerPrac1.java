package prac1.mvc;

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

import exam2.message1.Action;

@WebServlet("/ControllerPrac1")
public class ControllerPrac1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> map = new HashMap<String, Object>();
       
    public ControllerPrac1() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String realFolder = config.getServletContext().getRealPath("./property");
    	String realPath = realFolder + "/commandPrac1.properties";
    	
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
    	//System.out.println("realFolder = "  + realFolder);
    	//System.out.println("realPath = "  + realPath);
    	//System.out.println("properties = "  + properties);
    	
    	Iterator<?> iterator = properties.keySet().iterator();
    	
    	while(iterator.hasNext()) {
    		String command = (String) iterator.next();
    		String className = properties.getProperty(command);
    		
    		//System.out.println("command = " + command);
    		//System.out.println("className = " + className);
    		
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
    	System.out.println(map.toString());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command == null) {
			command = "none";
		}
		System.out.println("command = " + command);
		Action action = (Action)map.get(command);	// 문자열을 넣으면 안된다
		System.out.println("action = " + action);
		
		String view = null;
		
		if(action != null) {
			try {
				view = action.process(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("view = " + view);
		if(view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

}
