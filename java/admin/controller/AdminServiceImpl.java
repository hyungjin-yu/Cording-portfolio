package admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.dao.AdminDAO;
import item.bean.ItemDTO;
import profile.bean.ProfileDTO;
import sales.bean.SalesDTO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO dao;

	@Override
	public int itemWrite(ItemDTO dto) {
		return dao.itemWrite(dto);
	}

	@Override
	public int itemModify(ItemDTO dto) {
		return dao.itemModify(dto);
	}

	@Override
	public int itemDelete(String code) {
		return dao.itemDelete(code);
	}

	@Override
	public int getTotalNumberOfOrders() {
		return dao.getTotalNumberOfOrders();
	}

	@Override
	public List<SalesDTO> salesList(int startNum, int endNum) {
		return dao.salesList(startNum, endNum);
	}

	@Override
	public int totalSales() {
		return dao.totalSales();
	}

	@Override
	public List<SalesDTO> salesListByYear(int startNum, int endNum, String year) {
		return dao.salesListByYear(startNum, endNum, year);
	}

	@Override
	public int salesByYear() {
		return dao.salesByYear();
	}

	@Override
	public List<SalesDTO> salesListByMonth(int startNum, int endNum, String year, String month) {
		return dao.salesListByMonth(startNum, endNum, year, month);
	}

	@Override
	public int salesByMonth() {
		return dao.salesByMonth();
	}

	@Override
	public List<SalesDTO> salesListByDay(int startNum, int endNum, String year, String month, String day) {
		return dao.salesListByDay(startNum, endNum, year, month, day);
	}

	@Override
	public int salesByDay() {
		return dao.salesByDay();
	}

	@Override
	public List<SalesDTO> salesListByCategory1(int startNum, int endNum, String item_category1) {
		return dao.salesListByCategory1(startNum, endNum, item_category1);
	}

	@Override
	public int salesByCategory1() {
		return dao.salesByCategory1();
	}

	@Override
	public List<SalesDTO> salesListByCategory2(int startNum, int endNum, String item_category1, String item_category2) {
		return dao.salesListByCategory2(startNum, endNum, item_category1, item_category2);
	}

	@Override
	public int salesByCategory2() {
		return dao.salesByCategory2();
	}

	@Override
	public List<SalesDTO> salesListByCategory3(int startNum, int endNum, String item_category1, String item_category2,
			String item_category3) {
		return dao.salesListByCategory3(startNum, endNum, item_category1, item_category2, item_category3);
	}

	@Override
	public int salesByCategory3() {
		return dao.salesByCategory3();
	}

	@Override
	public List<SalesDTO> salesListByGender(int startNum, int endNum, String user_gender) {
		return dao.salesListByGender(startNum, endNum, user_gender);
	}

	@Override
	public int salesByGender() {
		return dao.salesByGender();
	}

	@Override
	public List<SalesDTO> salesListByAgegroup(int startNum, int endNum, String user_agegroup) {
		return dao.salesListByAgegroup(startNum, endNum, user_agegroup);
	}

	@Override
	public int salesByAgegroup() {
		return dao.salesByAgegroup();
	}

	@Override
	public List<SalesDTO> salesListByGenderAgegroup(int startNum, int endNum, String user_gender, String user_agegroup) {
		return dao.salesListByGenderAgegroup(startNum, endNum, user_gender, user_agegroup);
	}

	@Override
	public int salesByGenderAgegroup() {
		return dao.salesByGenderAgegroup();
	}

	

}
