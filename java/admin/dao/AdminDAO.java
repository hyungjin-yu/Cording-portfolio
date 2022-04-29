package admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import admin.bean.AdminDTO;
import item.bean.ItemDTO;
import order.bean.OrderDTO;
import profile.bean.ProfileDTO;
import sales.bean.SalesDTO;

@Repository
public class AdminDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// ------------ item ------------
	
	// 상품 등록
	public int itemWrite(ItemDTO dto) {
		return sqlSession.insert("mybatis.adminMapper.itemWrite", dto);
	}
	
	// 상품 수정
	public int itemModify(ItemDTO dto) {
		return sqlSession.update("mybatis.adminMapper.itemModify", dto);
	}
	
	// 상품 삭제
	public int itemDelete(String code) {
		return sqlSession.delete("mybatis.adminMapper.itemDelete", code);
	}
	
	// ------------ sales ------------
	
	// 총 회원수 구하기
	public int getTotalNumberOfOrders() {
		return sqlSession.selectOne("mybatis.adminMapper.getTotalNumberOfOrders");
	}
	
	// 매출 목록
	public List<SalesDTO> salesList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.adminMapper.salesList", map);
	}
	
	// 총 매출액
	public int totalSales() {
		return sqlSession.selectOne("mybatis.adminMapper.totalSales");
	}
	
	
	// 날짜별
	public List<SalesDTO> salesListByYear(int startNum, int endNum, String year) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("year", year);
		return sqlSession.selectList("mybatis.adminMapper.salesListByYear", map);
	}
	
	public int salesByYear() {
		return sqlSession.selectOne("mybatis.adminMapper.salesByYear");
	}
	
	public List<SalesDTO> salesListByMonth(int startNum, int endNum, String year, String month) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("year", year);
		map.put("month", month);
		return sqlSession.selectList("mybatis.adminMapper.salesListByMonth", map);
	}
	
	public int salesByMonth() {
		return sqlSession.selectOne("mybatis.adminMapper.salesByMonth");
	}
	
	public List<SalesDTO> salesListByDay(int startNum, int endNum, String year, String month, String day) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("year", year);
		map.put("month", month);
		map.put("day", day);
		return sqlSession.selectList("mybatis.adminMapper.salesListByDay", map);
	}
	
	public int salesByDay() {
		return sqlSession.selectOne("mybatis.adminMapper.salesByDay");
	}
	
	// 상품 카테고리별
	public List<SalesDTO> salesListByCategory1(int startNum, int endNum, String item_category1) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("item_category1", item_category1);
		return sqlSession.selectList("mybatis.adminMapper.salesListByCategory1", map);
	}
	
	public int salesByCategory1() {
		return sqlSession.selectOne("mybatis.adminMapper.salesByCategory1");
	}
	
	public List<SalesDTO> salesListByCategory2(int startNum, int endNum, String item_category1, String item_category2) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("item_category1", item_category1);
		map.put("item_category2", item_category2);
		return sqlSession.selectList("mybatis.adminMapper.salesListByCategory2", map);
	}
	
	public int salesByCategory2() {
		return sqlSession.selectOne("mybatis.adminMapper.salesByCategory2");
	}
	
	public List<SalesDTO> salesListByCategory3(int startNum, int endNum, String item_category1, String item_category2, String item_category3) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("item_category1", item_category1);
		map.put("item_category2", item_category2);
		map.put("item_category3", item_category3);
		return sqlSession.selectList("mybatis.adminMapper.salesListByCategory3", map);
	}
	
	public int salesByCategory3() {
		return sqlSession.selectOne("mybatis.adminMapper.salesByCategory3");
	}
	
	// 성별
	public List<SalesDTO> salesListByGender(int startNum, int endNum, String user_gender) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("user_gender", user_gender);
		return sqlSession.selectList("mybatis.adminMapper.salesListByGender", map);
	}
	
	public int salesByGender() {
		return sqlSession.selectOne("mybatis.adminMapper.salesByGender");
	}
	
	// 연령별
	public List<SalesDTO> salesListByAgegroup(int startNum, int endNum, String user_agegroup) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("user_birth", user_agegroup);
		return sqlSession.selectList("mybatis.adminMapper.salesListByAgegroup", map);
	}
	
	public int salesByAgegroup() {
		return sqlSession.selectOne("mybatis.adminMapper.salesByAgegroup");
	}
	
	// 성별+연령별
	public List<SalesDTO> salesListByGenderAgegroup(int startNum, int endNum, String user_gender, String user_agegroup) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("user_gender", user_gender);
		map.put("user_birth", user_agegroup);
		return sqlSession.selectList("mybatis.adminMapper.salesListByGenderAgegroup", map);
	}
	
	public int salesByGenderAgegroup() {
		return sqlSession.selectOne("mybatis.adminMapper.salesByGenderAgegroup");
	}
	
	
	
/*	
	salesList
	totalSales
	salesListByYear
	salesByYear
	salesListByMonth
	salesByMonth
	salesListByDay
	salesByDay
	salesListByCategory1
	salesByCategory1
	salesListByCategory2
	salesByCategory2
	salesListByCategory3
	salesByCategory3
	salesListByGender
	salesByGender
	salesListByAgegroup
	salesByAgegroup
	salesListByGenderAgegroup
	salesByGenderAgegroup
	
	getTotalNumberOfOrders
	
*/
	
	
	
}
