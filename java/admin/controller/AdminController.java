package admin.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import item.bean.ItemDTO;
import profile.bean.ProfileDTO;
import sales.bean.SalesDTO;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	// itemWriteForm
	@RequestMapping(value = "/admin/itemWriteForm.do")
	public ModelAndView itemWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req", "../admin/itemWriteForm.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}
	
	// itemWrite
	@RequestMapping(value="/admin/itemWrite.do")
	public ModelAndView itemWrite(HttpServletRequest request, MultipartFile item_image1, MultipartFile item_image2) throws IOException {
		/* 데이터 처리 */
		request.setCharacterEncoding("utf-8");
		String filePath = request.getSession().getServletContext().getRealPath("/storage/");
		String fileName1 = item_image1.getOriginalFilename();
		String fileName2 = item_image2.getOriginalFilename();
		//System.out.println("image1: "+item_image1);
		//System.out.println("image2: "+item_image2);
		//System.out.println("filePath = " + filePath);
		//System.out.println("fileName1: "+fileName1);
		//System.out.println("fileName2: "+fileName2);
		
		File file1 = new File(filePath, fileName1);
		File file2 = new File(filePath, fileName2);
		
		//System.out.println("file1: "+file1);
		//System.out.println("file2: "+file2);
		
		try {
			FileCopyUtils.copy(item_image1.getInputStream(), new FileOutputStream(file1));
			FileCopyUtils.copy(item_image2.getInputStream(), new FileOutputStream(file2));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String item_code = request.getParameter("item_code");
		String item_category1 = request.getParameter("item_category1");
		String item_category2 = request.getParameter("item_category2");
		String item_category3 = request.getParameter("item_category3");
		String item_name = request.getParameter("item_name");
		String item_details = request.getParameter("item_details").replace("\r\n","<br>");
		int cart_qty = Integer.parseInt(request.getParameter("cart_qty"));
		String item_size = request.getParameter("item_size");
		String item_color = request.getParameter("item_color");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		
		// DB 처리
		ItemDTO dto = new ItemDTO();
		dto.setItem_code(item_code);
		dto.setItem_category1(item_category1);
		dto.setItem_category2(item_category2);
		dto.setItem_category3(item_category3);
		dto.setItem_name(item_name);
		dto.setItem_image1(fileName1);
		dto.setItem_image2(fileName2);
		dto.setItem_details(item_details);
		dto.setItem_size(item_size);
		dto.setItem_color(item_color);
		dto.setCart_qty(cart_qty);
		dto.setItem_price(item_price);
		
		int result = adminService.itemWrite(dto);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("result", result);
		//modelAndView.addObject("req_item", "../admin/itemWrite.jsp");	// itemView.jsp에 ${req_item} ?
		modelAndView.setViewName("itemWrite.jsp");
		return modelAndView;
	}
	
	
	// itemModifyForm
	@RequestMapping(value="/admin/itemModifyForm.do")
	public ModelAndView adminModifyForm(HttpServletRequest request) {
		/* 데이터 처리 */
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// itemModifyForm.jsp에 보여줄 데이터 필요
		//ItemDTO dto = adminService.itemView(seq);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		//modelAndView.addObject("dto", dto);
		modelAndView.addObject("req_item", "../admin/itemModifyForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// itemModify
	@RequestMapping(value="/admin/itemModify.do")
	public ModelAndView adminModify(HttpServletRequest request) throws IOException {
		/* 데이터 처리 */
		request.setCharacterEncoding("utf-8");

		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String item_code = request.getParameter("item_code");
		String item_category1 = request.getParameter("item_category1");
		String item_category2 = request.getParameter("item_category2");
		String item_category3 = request.getParameter("item_category3");
		String item_name = request.getParameter("item_name");
		String item_image1 = request.getParameter("item_image1");
		String item_image2 = request.getParameter("item_image2");
		String item_details = request.getParameter("item_details").replace("\r\n","<br>");
		String item_size = request.getParameter("item_size");
		String item_color = request.getParameter("item_color");
		int cart_qty = Integer.parseInt(request.getParameter("cart_qty"));
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		
		// DB처리
		ItemDTO dto = new ItemDTO(); 	
		dto.setItem_code(item_code);
		dto.setItem_category1(item_category1);
		dto.setItem_category2(item_category2);
		dto.setItem_category3(item_category3);
		dto.setItem_name(item_name);
		dto.setItem_image1(item_image1);
		dto.setItem_image2(item_image2);
		dto.setItem_details(item_details);
		dto.setItem_size(item_size);
		dto.setItem_color(item_color);
		dto.setCart_qty(cart_qty);
		dto.setItem_price(item_price);
		
		int result = adminService.itemModify(dto);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.addObject("req_item", "../admin/itemModify.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	
	// itemDelete
	@RequestMapping(value="/admin/itemDelete.do")
	public ModelAndView itemDelete(HttpServletRequest request) {
		/* 데이터 처리 */
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String code = request.getParameter("item_code");
		
		int result = adminService.itemDelete(code);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.addObject("req_item", "../admin/itemDelete.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	
	
	
	
	@RequestMapping(value="/sales/salesListJson.do")
	public ModelAndView salesListJson(HttpServletRequest request) throws Exception {
		// 1. 데이터 처리 코드
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		List<SalesDTO> list = adminService.salesList(startNum, endNum);
		int sales = adminService.totalSales();
		
		// JSON으로 결과값 반환
		String rt = null;	// rt : result
		int total = list.size();
		
		if(total > 0) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("total", total);
		json.put("sales", sales);
		
		if(total > 0) {
			JSONArray items = new JSONArray();
			
			for(int i=0; i<list.size(); i++) {
				//Map<String, Object> map = list.get(i);
				SalesDTO dto = list.get(i);
				JSONObject temp = new JSONObject();
				temp.put("sales_date", dto.getSales_date());
				temp.put("sales_gender", dto.getSales_gender());
				temp.put("sales_age", dto.getSales_age());
				temp.put("sales_code", dto.getSales_code());
				temp.put("sales_name", dto.getSales_name());
				temp.put("sales_category1", dto.getSales_category1());
				temp.put("sales_category2", dto.getSales_category2());
				temp.put("sales_category3", dto.getSales_category3());
				temp.put("sales_size", dto.getSales_size());
				temp.put("sales_color", dto.getSales_color());
				temp.put("sales_price", dto.getSales_price());
				temp.put("sales_qty", dto.getSales_qty());
				temp.put("sales_totalprice", dto.getSales_totalprice());
				
				items.put(i, temp);
			}
			
			json.put("items", items);
		}
		
		// json 데이터 확인
		//System.out.println("json : " + json);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("salesListJson.jsp");
		return modelAndView;
	}
	
	// salesList
	@RequestMapping(value = "/sales/salesList.do")
	public ModelAndView salesList(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		/* 데이터 처리 */
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		/* 페이징 처리 */
		int totalA = adminService.getTotalNumberOfOrders(); // 총 주문 횟수 구하기
		int totalP = (totalA + 4) / 5; // 총페이지수 구하기
		if (pg > totalP)
			pg = totalP;

		/* 목록보기 */
		// 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<SalesDTO> list = adminService.salesList(startNum, endNum);
		int sales = adminService.totalSales();
		
		// 3블럭 : 표시할 숫자를 3개만 사용
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		// endPage 값 보정
		if (endPage > totalP)
			endPage = totalP;

		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("sales", sales);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("req", "../sales/salesList.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}
	
	

}
