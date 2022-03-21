package java_test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BookDAO {
	private SqlSession sqlSession;
	
	public BookDAO() {
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
	}
	
	public int insertBook(BookVO vo) {
		return sqlSession.insert("mybatis.bookMapper.insertBook", vo);
	}
	
	public List<BookVO> getBookList() {
		return sqlSession.selectList("mybatis.bookMapper.getBookList");
	}
}
