package java_test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class BookServiceImpl implements BookService{
	
	private BookDAO dao;

	@Override
	public int insertBook(BookVO vo) {
		return dao.insertBook(vo);
	}

	@Override
	public List<BookVO> getBookList() {
		return dao.getBookList();
	}

	public BookDAO getDao() {
		return dao;
	}

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	

}
