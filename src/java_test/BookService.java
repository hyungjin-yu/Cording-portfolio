package java_test;

import java.util.List;

public interface BookService {
	
	public int insertBook(BookVO vo);

	public List<BookVO> getBookList();
}
