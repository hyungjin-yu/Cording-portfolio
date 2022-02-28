package board.dao;

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

import board.bean.BoardBean;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public BoardDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// insert : 글 등록
	public int insertArticle(BoardBean boardbean) {
		int result = 0;
		String sql = "insert into board2 values(seq_num.nextval, ?, ?, ?, ?, ?, seq_num.currval, 0, 0, 0, sysdate )";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardbean.getBoard_name());
			pstmt.setString(2, boardbean.getBoard_pass());
			pstmt.setString(3, boardbean.getBoard_subject());
			pstmt.setString(4, boardbean.getBoard_content());
			pstmt.setString(5, boardbean.getBoard_file());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// 총 데이터 개수
		public int getTotalA() {
			int total = 0;
			String sql = "select count(*) as cnt from board2";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				if(rs.next()) {
					total = rs.getInt("cnt");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return total;
		}
		
		public List<BoardBean> boardList(int startNum, int endNum) {
			List<BoardBean> list = new ArrayList<BoardBean>();
			String sql = "sselect * from(select rownum rn, tt. * from\r\n"
					+ "(select * from board2 order by seq desc)tt)\r\n"
					+ "where rn>=? and rn<=?";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startNum);
				pstmt.setInt(2, endNum);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardBean bean = new BoardBean(); 
					bean.setBoard_num(rs.getInt("board_num"));
					bean.setBoard_name(rs.getString("board_name"));
					bean.setBoard_pass(rs.getString("board_pass"));
					bean.setBoard_subject(rs.getString("board_subject"));
					bean.setBoard_content(rs.getString("board_content"));
					bean.setBoard_file(rs.getString("board_file"));
					bean.setBoard_re_ref(rs.getInt("board_re_ref"));
					bean.setBoard_re_lev(rs.getInt("board_re_lev"));
					bean.setBoard_re_seq(rs.getInt("board_re_seq"));
					bean.setBoard_readcount(rs.getInt("board_readcount"));
					bean.setBoard_date(rs.getString("board_date"));
		              
		            list.add(bean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return list;
		}
	
}
