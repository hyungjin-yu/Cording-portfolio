package imageboard.dao;

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

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public ImageboardDAO() {
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
	
	// insert
	public int imageboardWrite(ImageboardDTO dto) {
		int result = 0;
		String sql = "insert into imageboard values (seq_imageboard.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getImageId());
			pstmt.setString(2, dto.getImageName());
			pstmt.setInt(3, dto.getImagePrice());
			pstmt.setInt(4, dto.getImageQty());
			pstmt.setString(5, dto.getImageContent());
			pstmt.setString(6, dto.getImage1());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	//int startNum, int endNum
	public List<ImageboardDTO> boardList() {
		List<ImageboardDTO> list = new ArrayList<ImageboardDTO>();
		String sql = "select * from imageboard order by seq";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			 while (rs.next()) {
				  ImageboardDTO dto = new ImageboardDTO();
	              dto.setSeq(rs.getInt("seq"));
	              dto.setImageId(rs.getString("imageId"));
	              dto.setImageName(rs.getString("imageName"));
	              dto.setImagePrice(rs.getInt("ImagePrice"));
	              dto.setImageQty(rs.getInt("ImageQty"));
	              dto.setImageContent(rs.getString("ImageContent"));
	              dto.setImage1(rs.getString("Image1"));
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
	
	// 총 데이터 개수
	public int getTotalA() {
		int total = 0;
		String sql = "select count(*) as cnt from imageboard";
		
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
	
	public List<ImageboardDTO> imageboardList(int startNum, int endNum) {
		List<ImageboardDTO> list = new ArrayList<ImageboardDTO>();
		String sql = "select seq, imageId, imageName, imagePrice, imageQty, imageContent, image1, to_char(logtime, 'YYYY.MM.DD') as logtime from\r\n"
				+ "(select rownum rn, tt. * from\r\n"
				+ "(select * from imageboard order by seq desc)tt)\r\n"
				+ "where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ImageboardDTO dto = new ImageboardDTO(); 
				  dto.setSeq(rs.getInt("seq"));
	              dto.setImageId(rs.getString("imageId"));
	              dto.setImageName(rs.getString("imageName"));
	              dto.setImagePrice(rs.getInt("ImagePrice"));
	              dto.setImageQty(rs.getInt("ImageQty"));
	              dto.setImageContent(rs.getString("ImageContent"));
	              dto.setImage1(rs.getString("Image1"));
	              dto.setLogtime(rs.getString("logtime"));
	              
	              list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	// 상세보기
	public ImageboardDTO ImageView(int seq) {
		ImageboardDTO dto = null;
		String sql = "select * from imageboard where seq=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new ImageboardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setImageId(rs.getString("imageId"));
				dto.setImageName(rs.getString("imageName"));
	            dto.setImagePrice(rs.getInt("ImagePrice"));
	            dto.setImageQty(rs.getInt("ImageQty"));
	            dto.setImageContent(rs.getString("ImageContent"));
	            dto.setImage1(rs.getString("Image1"));
	            dto.setLogtime(rs.getString("logtime"));
			}
			} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	// 데이터 삭제
	public int imageDelete(int seq) {
		int result = 0;
		String sql = "delete imageboard where seq=?";
		
		try {
			conn = ds.getConnection();
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
	
	public int checkModify(ImageboardDTO dto) {
		int result = 0;
		String sql = "";
		if(dto.getImage1() == null) {
			sql = "update imageboard set imageId=? ,imageName=?,imagePrice=? ,imageQty=? , imageContent=?, where seq=?";
		} else {
			sql = "update imageboard set imageId=? ,imageName=?,imagePrice=? ,imageQty=? , imageContent=?, image1=? where seq=?";
		}
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getImageId());
			pstmt.setString(2, dto.getImageName());
			pstmt.setInt(3, dto.getImagePrice());
			pstmt.setInt(4, dto.getImageQty());
			pstmt.setString(5, dto.getImageContent());
			if(dto.getImage1() == null) {
				pstmt.setInt(6, dto.getSeq());
			} else {
				pstmt.setString(6, dto.getImage1());
				pstmt.setInt(7, dto.getSeq());
			}
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
