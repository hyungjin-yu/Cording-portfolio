package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import board.bean.BoardDTO;

public class BoardDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "C##dbexam";
	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public BoardDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
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
	
	// 목록
	public List<BoardDTO> boardList(int startNum, int endNum) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select seq, id, name, subject, content, hit, to_char(logtime, 'YYYY.MM.DD') as logtime from\r\n"
				+ "	 (select rownum rn, tt. * from\r\n"
				+ "	 (select * from board order by seq desc)tt)\r\n"
				+ "	 where rn>=? and rn<=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			 while (rs.next()) {
	              BoardDTO dto = new BoardDTO();
	              dto.setSeq(rs.getInt("seq"));
	              dto.setId(rs.getString("id"));
	              dto.setName(rs.getString("name"));
	              dto.setSubject(rs.getString("subject"));
	              dto.setContent(rs.getString("content"));
	              dto.setHit(rs.getInt("hit"));
	              dto.setLogtime(rs.getString("logtime"));

	              list.add(dto);
	           }

		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("저장 실패");
		} finally {
			close();
		}
		return list;
	}
	
	// 총 데이터 갯수 구하기
		public int getTotalA() {
			int total = 0;
			String sql = "select count(*) as cnt from board";
			
			try {
				conn = getConnection();
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
		public BoardDTO boardView(int seq) {
			BoardDTO dto = null;
			String sql = "select * from board where seq=?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dto = new BoardDTO();
					dto.setSeq(rs.getInt("seq"));
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setHit(rs.getInt("hit"));
					dto.setLogtime(rs.getString("logtime"));
				}
				} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return dto;
		}
		
		// insert : 글 저장
		public int boardWrite(BoardDTO dto) {
			int result= 0;
			String sql = "insert into board values(seq_board.nextval, ?, ?, ?, ?, 0, sysdate)";
			//conn = getConnection();
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getName());
				pstmt.setString(3, dto.getSubject());
				pstmt.setString(4, dto.getContent());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("저장 실패");
			} finally {
				close();
			}
			return result;
		}
		
		// 글 삭제
		public int boardDelete(int seq) {
			int result = 0;
			String sql = "delete board where seq=?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return result;
		}
		
		// 조회수 증가하기
		public int updateHit(int seq) {
			int result = 0;
			String sql = "update board set hit = hit+1 where seq=?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				
				result = pstmt.executeUpdate();		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return result;
		}
}
