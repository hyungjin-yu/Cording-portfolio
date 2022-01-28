package apply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplyDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ApplyDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
			//e.printStackTrace();
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
			//e.printStackTrace();
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
		String sql = "insert into apply values(?, ?, ?, ?)";
		int result = 0;
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getHour());
			pstmt.setString(2, dto.isApplyStatus());
			pstmt.setString(3, dto.isApproveStatus());
			pstmt.setString(4, null);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("저장 실패");
			//e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
