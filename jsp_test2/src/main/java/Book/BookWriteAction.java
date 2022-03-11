package Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookWriteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		String book_num = request.getParameter("book_num");
		String book_name = request.getParameter("book_name");
		String  book_writer = request.getParameter("book_writer");
		String publisher = request.getParameter("publisher");
	    int price = Integer.parseInt(request.getParameter("price"));
	    String book_date = request.getParameter("book_date");
	    
	    //DB
	    BookBean bean = new BookBean();
	    bean.setBook_num(book_num);
	    bean.setBook_name(book_name);
	    bean.setBook_writer(book_writer);
	    bean.setPublisher(publisher);
	    bean.setPrice(price);
	    bean.setBook_date(book_date);
	    
	    BookDAO dao = new BookDAO();
	    int result = dao.write(bean);
	    
	    // 2. 데이터 공유
	    request.setAttribute("result", result);
	    
	    // 3. view 처리 파일 리턴
	    request.setAttribute("ref", "write.jsp");
		return "index.jsp";
	}

}
