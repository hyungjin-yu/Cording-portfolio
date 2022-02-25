package exam2.message1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
