package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import apply.ApplyDTO;

public class AdminDAO implements Admin {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public AdminDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##dbexam";
		String password = "m1234";
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			//System.out.println("접속 성공");
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		return conn;
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
	
	// 해당 날짜 칸이 빈 칸인지
	public int isEmpty(String get_date) {	// 0이면 빈 칸, 1이면 채워진 칸
		String sql = "select workday from admin where workday = ?";
		conn = getConnection();
		String date="";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, get_date);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				date = rs.getString("workday");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		if(date.length()>0) return 1;
		else return 0;
	}
	
	// 어떤 날짜에 알바 등록이 되어있는지
	public List<AdminDTO> allWorkdays() {
		List<AdminDTO> list = new ArrayList<AdminDTO>();
		String sql = "select workday from admin";
		conn = getConnection();
		String date="";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				date = rs.getString("workday");
				
				AdminDTO dto = new AdminDTO(date);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	// *** 알바 정보 입력 ***
	public int insert(AdminDTO dto) {
		String sql = "insert into admin values (?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDate());
			pstmt.setInt(2, dto.getTime1());
			pstmt.setInt(3, dto.getTime2());
			pstmt.setString(4, dto.getLoc());
			pstmt.setString(5, dto.getJob());
			pstmt.setString(6, dto.getDetails());
			pstmt.setInt(7, dto.getWage());
			pstmt.setString(8, dto.getPayday());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(result);
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// *** 알바 정보 수정 ***
	public int edit(AdminDTO dto) {
		String sql = "update admin set time1 = ?, time2 = ?, loc = ?, job = ?, "
					+ "details = ?, wage = ?, payday = ? where workday = ?";
		int result = 0;
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getTime1());
			pstmt.setInt(2, dto.getTime2());
			pstmt.setString(3, dto.getLoc());
			pstmt.setString(4, dto.getJob());
			pstmt.setString(5, dto.getDetails());
			pstmt.setInt(6, dto.getWage());
			pstmt.setString(7, dto.getPayday());
			pstmt.setString(8, dto.getDate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// *** 알바 정보 삭제 ***
	public int delete(String date) {
		String sql = "delete admin where workday = ?";
		int result = 0;
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	
	// *** 하는 일 상세정보 ***
	public List<AdminDTO> adminList(String get_date) {	// search job details by date
		List<AdminDTO> list = new ArrayList<AdminDTO>();
		String sql = "select * from admin where workday = ?";
		conn = getConnection();
		
		String date = "";
		int time1 = 0;
		int time2 = 0;
		String loc = "";
		String job = "";
		String details = "";
		int wage = 0;
		String payday = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, get_date);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				date = rs.getString("workday");
				time1 = rs.getInt("time1");
				time2 = rs.getInt("time2");
				loc = rs.getString("loc");
				job = rs.getString("job");
				details = rs.getString("details");
				wage = rs.getInt("wage");
				payday = rs.getString("payday");
				
				AdminDTO dto = new AdminDTO(date, time1, time2, loc, job, details, wage, payday);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// *** 신청자 목록 ***
	public List<ApplyDTO> applyList(String get_date) {	// search alba by date
		List<ApplyDTO> list = new ArrayList<ApplyDTO>();
		String sql = "select * from apply where workday = ? and (applyStatus = 1 or approveStatus = 1)";
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, get_date);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String date = rs.getString("workday");
				String name = rs.getString("name");
				String id = rs.getString("id");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				int applyStatus = rs.getInt("applyStatus");
				int approveStatus = rs.getInt("approveStatus");
				
				ApplyDTO dto = new ApplyDTO(date, name, id, address, phone, applyStatus, approveStatus);
				list.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	// *** 승인 or 거절 ***
	public int status(String date, String id, int applyStatus, int approveStatus) {
		String sql = "update apply set applyStatus = ?, approveStatus = ? "
				+ "where workday = ? and id = ?";
		int result = 0;
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applyStatus);
			pstmt.setInt(2, approveStatus);
			pstmt.setString(3, date);
			pstmt.setString(4, id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	
}
