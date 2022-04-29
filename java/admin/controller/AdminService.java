package admin.controller;

import java.util.List;
import java.util.Map;

import item.bean.ItemDTO;
import profile.bean.ProfileDTO;
import sales.bean.SalesDTO;

public interface AdminService {
	// item
	public int itemWrite(ItemDTO dto);	// 상품 등록
	public int itemModify(ItemDTO dto);	// 상품 수정
	public int itemDelete(String code);	// 상품 삭제
	
	// sales
	public int getTotalNumberOfOrders();	// 총 주문 횟수 구하기
	public List<SalesDTO> salesList(int startNum, int endNum);
	public int totalSales();
	// 날짜별
	public List<SalesDTO> salesListByYear(int startNum, int endNum, String year);
	public int salesByYear();
	public List<SalesDTO> salesListByMonth(int startNum, int endNum, String year, String month);
	public int salesByMonth();
	public List<SalesDTO> salesListByDay(int startNum, int endNum, String year, String month, String day);
	public int salesByDay();
	// 상품 카테고리별
	public List<SalesDTO> salesListByCategory1(int startNum, int endNum, String item_category1);
	public int salesByCategory1();
	public List<SalesDTO> salesListByCategory2(int startNum, int endNum, String item_category1, String item_category2);
	public int salesByCategory2();
	public List<SalesDTO> salesListByCategory3(int startNum, int endNum, String item_category1, String item_category2, String item_category3);
	public int salesByCategory3();
	// 성별
	public List<SalesDTO> salesListByGender(int startNum, int endNum, String user_gender);
	public int salesByGender();
	// 연령별
	public List<SalesDTO> salesListByAgegroup(int startNum, int endNum, String user_agegroup);
	public int salesByAgegroup();
	// 성별+연령별
	public List<SalesDTO> salesListByGenderAgegroup(int startNum, int endNum, String user_gender, String user_agegroup);
	public int salesByGenderAgegroup();
	
}
