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
			Class.forName("");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
			//e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "";
		String name = "";
		String password = "";
		
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
	
	
}
