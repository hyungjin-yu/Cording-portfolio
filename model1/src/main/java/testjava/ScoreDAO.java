package testjava;

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

public class ScoreDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	public ScoreDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
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
			System.out.println("접속 끊기에 실패했습니다.");
			//e.printStackTrace();	// 일반 커넥션 사용
		}
	}
	
	public int ScoreWrite(Scorebean bean) {
		int result = 0;
		String sql = "insert into score values(seq_num.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getHak());
			pstmt.setString(2, bean.getStuname());
			pstmt.setInt(3, bean.getKor());
			pstmt.setInt(4, bean.getEng());
			pstmt.setInt(5, bean.getMath());
			pstmt.setInt(6, bean.getSumscore());
			pstmt.setInt(7, bean.getAvgscore());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public List<Scorebean> scoreList(int startNum, int endNum) {
		List<Scorebean> list = new ArrayList<Scorebean>();
		String sql = "select * from(select rownum rn, tt. * from\r\n"
				+ "(select * from score order by seq asc)tt)\r\n"
				+ "where rn>=? and rn<=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			 while (rs.next()) {
				 Scorebean bean = new Scorebean();
				 bean.setHak(rs.getString("hak"));
				 bean.setStuname(rs.getString("stuname"));
				 bean.setKor(rs.getInt("kor"));
				 bean.setEng(rs.getInt("eng"));
				 bean.setMath(rs.getInt("math"));
				 bean.setSumscore(rs.getInt("sumscore"));
				 bean.setAvgscore(rs.getInt("avgscore"));

	              list.add(bean);
	           }

		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("저장 실패");
		} finally {
			close();
		}
		return list;
	}
	
	public int getTotalA() {
		int total = 0;
		String sql = "select count(*) as cnt from score";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// insert, update, delete는 리턴값이 정수, select는 무조건 문자열
			// 그래서 select는 resultSet로 받는다.
			// 나머지는 result로 받는다.
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
}
