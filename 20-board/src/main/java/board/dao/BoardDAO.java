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
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insert(BoardBean bean) {
		int result = 0;
		String sql = "insert into board2 values "
				+ " (seq_num.nextval, ?, ?, ?, ?, ?, seq_num.currval, 0, 0, 0, sysdate)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getBoard_name());
			pstmt.setString(2, bean.getBoard_pass());
			pstmt.setString(3, bean.getBoard_subject());
			pstmt.setString(4, bean.getBoard_content());
			pstmt.setString(5, bean.getBoard_file());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	// 목록보기
	public List<BoardBean> boardList(int startNum, int endNum) {
		List<BoardBean> list = new ArrayList<BoardBean>();
		String sql = "select * from(select rownum rn, tt. * from"
				+ "(select * from board2 order by board_num desc)tt)"
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
	// 상세보기
	public BoardBean boardView(int board_num) {
		BoardBean bean = null;
		String sql = "select * from board2 where board_num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bean = new BoardBean();
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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bean;
	}
	
	// 조회 수 증가
	public int updateReadcount(int board_num) {
		int result = 0;
		String sql = "update board2 set board_readcount = board_readcount + 1 where board_num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	// 삭제
	public int boardDelete(int board_num) {
		int result = 0;
		String sql = "delete board2 where board_num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// 글쓴이가 맞는지 확인
	public boolean isBoardWriter(int board_num, String board_pass) {
		boolean result = false;
		String sql = "select * from board2 where board_num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(board_pass.equals(rs.getString("board_pass"))) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	// 수정
	public int check(BoardBean bean) {
		int result = 0;
		String sql = "update board2 set board_name=?, board_subject=?, board_content=? where board_num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getBoard_name());
			pstmt.setString(2, bean.getBoard_subject());
			pstmt.setString(3, bean.getBoard_content());
			pstmt.setInt(4, bean.getBoard_num());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
