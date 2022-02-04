package apply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

import admin.AdminDTO;

public class ApplyDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ApplyDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
			// e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String name = "C##dbexam";
		String password = "m1234";

		try {
			conn = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			System.out.println("접속 실패");
			// e.printStackTrace();
		}
		return conn;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 입력
	public int insert(ApplyDTO dto) {
		String sql = "insert into apply values(?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDate());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getLoc());
			pstmt.setString(5, dto.getPhone());
			pstmt.setInt(6, dto.getHour());
			pstmt.setString(7, "0");
			pstmt.setString(8, "0");

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("apply저장 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	// 상세내용 검색
	public String detail(String a) {
		String sql = "select * from admin where workday = ?";
		conn = getConnection();
		String details = "";
		int wage = 0;
		String payday = "";
		String str = "";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				details = rs.getString("details");
				wage = rs.getInt("wage");
				payday = rs.getString("payday");
				AdminDTO dto = new AdminDTO(details, wage, payday);
				str = dto.getDetails() + "\n" + dto.getWage() + "\n" + dto.getPayday();
			}
		} catch (SQLException e) {
			System.out.println("sql저장 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return str;
	}
	

public List<ApplyDTO> status(String get_id, String get_date) {
      List<ApplyDTO> list = new ArrayList<ApplyDTO>();
      String sql = "select * from apply where id = ? and workday = ?"; 
      conn = getConnection();
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, get_id);
         pstmt.setString(2, get_date);
         
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            String id = rs.getString("id");
            String date = rs.getString("workday");
            int applyStatus = rs.getInt("applyStatus");
            int approveStatus = rs.getInt("approveStatus");
            
            ApplyDTO dto = new ApplyDTO(id, date, applyStatus, approveStatus);
            list.add(dto);
         }
         
      } catch (SQLException e) {
         System.out.println("저장 실패");
         e.printStackTrace();
      } finally {
         close();
      }
      
      return list;
   }

}
