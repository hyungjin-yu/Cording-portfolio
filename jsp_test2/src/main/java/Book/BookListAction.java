package Book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int pg = 0;

		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		} else {
			pg = 1;
		}

		// 1) 목록 : 10개
		int endNum = 10 * pg;
		int startNum = endNum - 9;

		BookDAO dao = new BookDAO();
		List<BookBean> list = dao.memberList(startNum, endNum);

		// 2) 페이징
		int totalA = dao.getTotalA();
		int totalP = (totalA + 9) / 10;

		// 3블럭
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;

		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		request.setAttribute("ref", "list.jsp");
		return "index.jsp";
	}

}
