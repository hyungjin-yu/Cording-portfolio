package Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public BookDAO() {
		Context context;
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// db 접속 끊기
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	// 데이터 저장
	public int write(BookBean bean) {
		int result = 0;
		String sql = "insert into book2 values(seq_num2.nextval, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getBook_num());
			pstmt.setString(2, bean.getBook_name());
			pstmt.setString(3, bean.getBook_writer());
			pstmt.setString(4, bean.getPublisher());
			pstmt.setInt(5, bean.getPrice());
			pstmt.setString(6, bean.getBook_date());
				
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public List<BookBean> memberList(int startNum, int endNum){
		List<BookBean> list = new ArrayList<BookBean>();
		String sql = "select * from "
				+ " (select rownum rn, tt.* from "
				+ " (select * from book2 order by book_num asc) tt) "
				+ " where rn>=? and rn<=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookBean bean = new BookBean();
				bean.setBook_num(rs.getString("book_num"));
				bean.setBook_name(rs.getString("book_name"));
				bean.setBook_writer(rs.getString("book_writer"));
				bean.setPublisher(rs.getString("publisher"));
				bean.setPrice(rs.getInt("price"));
				bean.setBook_date(rs.getString("date"));
				
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public int getTotalA() {
		int total = 0;
		String sql = "select count(*) as cnt from book2";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return total;		
	}
}

