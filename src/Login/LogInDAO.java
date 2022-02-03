package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogInDAO {
	Connection conn = getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public LogInDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("등록 실패");
			//e.printStackTrace();
		}
	}

	private Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##dbexam";
		String password = "m1234";	
		
		try {
			conn = DriverManager.getConnection(url, username, password);
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

	public int insert(LogInDTO dto) {
		String sql = "insert into applylogin values(?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirth());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getMail());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	public List<LogInDTO> selectID(String s_id) {
		List<LogInDTO> list = new ArrayList<LogInDTO>();
		String sql = "select * from applylogin where id = ?";
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String password = rs.getString("Password");
				String name = rs.getString("Name");
				String birth = rs.getString("Birth");
				String phone = rs.getString("Phone");
				String address = rs.getString("address");
				String mail = rs.getString("Mail");
				String gender = rs.getString("Gender");

				LogInDTO dto = new LogInDTO(id, password, name, birth, phone, address, mail, gender);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public List<LogInDTO> selecMail(String s_mail) {
		List<LogInDTO> list = new ArrayList<LogInDTO>();
		String sql = "select * from applylogin where mail = ?";
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_mail);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String password = rs.getString("Password");
				String name = rs.getString("Name");
				String birth = rs.getString("Birth");
				String phone = rs.getString("Phone");
				String address = rs.getString("address");
				String mail = rs.getString("Mail");
				String gender = rs.getString("Gender");

				LogInDTO dto = new LogInDTO(id, password, name, birth, phone, address, mail, gender);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public List<LogInDTO> searchID(String s_name, String s_mail) {
		List<LogInDTO> list = new ArrayList<LogInDTO>();
		String sql = "select * from applylogin where name = ? and mail = ?";
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_name);
			pstmt.setString(2, s_mail);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String password = rs.getString("Password");
				String name = rs.getString("Name");
				String birth = rs.getString("Birth");
				String phone = rs.getString("Phone");
				String address = rs.getString("address");
				String mail = rs.getString("Mail");
				String gender = rs.getString("Gender");
				
				LogInDTO dto = new LogInDTO(id, password, name, birth, phone, address, mail, gender);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public List<LogInDTO> searchPW(String s_id, String s_mail) {
		List<LogInDTO> list = new ArrayList<LogInDTO>();
		String sql = "select * from applylogin where id = ? and mail = ?";
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			pstmt.setString(2, s_mail);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("ID");
				String password = rs.getString("Password");
				String name = rs.getString("Name");
				String birth = rs.getString("Birth");
				String phone = rs.getString("Phone");
				String address = rs.getString("address");
				String mail = rs.getString("Mail");
				String gender = rs.getString("Gender");
		
				LogInDTO dto = new LogInDTO(id, password, name, birth, phone, address, mail, gender);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public boolean LoginCheckApply(String s_id, String s_password) {
		boolean check = false;
		List<LogInDTO> list = new ArrayList<LogInDTO>();
		String sql = "select * from applylogin where id = ? and password = ?";
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			pstmt.setString(2, s_password);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String password = rs.getString("Password");
				String name = rs.getString("Name");
				String birth = rs.getString("Birth");
				String phone = rs.getString("Phone");
				String address = rs.getString("address");
				String mail = rs.getString("Mail");
				String gender = rs.getString("Gender");

				LogInDTO dto = new LogInDTO(id, password, name, birth, phone, address, mail, gender);
				list.add(dto);
			}
			if(list.size() > 0) {
				check = true;
			} else {
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return check;
	}
	
	public boolean LoginCheck(String s_id, String s_password) {
		boolean check = false;
		List<LogInDTO> list = new ArrayList<LogInDTO>();
		String sql = "select * from adminlogin where id = ? and password = ?";
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			pstmt.setString(2, s_password);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String password = rs.getString("Password");
		
				LogInDTO dto = new LogInDTO(id, password);
				list.add(dto);
			}
			if(list.size() > 0) {
				check = true;
			} else {
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return check;
	}

	public boolean sendMail(String s_mail, List<LogInDTO> s_list) {
		String strid = "";
		String strpw = "";
		for(int i=0; i<s_list.size(); i++) {
			strid = s_list.get(i).getId();
			strpw = s_list.get(i).getPassword();
		}
		LogInMail lm = new LogInMail();
		boolean check = lm.sendMail(s_mail, strid, strpw);
		return check;
	}
}
