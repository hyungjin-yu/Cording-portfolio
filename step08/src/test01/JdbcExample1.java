package test01;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcExample1 {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		
		GoodsService goodsService = (GoodsService) context.getBean("goodsService");
		
		// 1. 글 등록 기능 테스트
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0001");
		vo.setName("JAVA");
		vo.setPrice(20000);
		vo.setMaker("달님 출판사");
		
		int result = goodsService.insertGoods(vo);
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
		
		// 2. 글 목록 기능 테스트
		List<GoodsVO> list = goodsService.getGoodsList();
		for(GoodsVO goodsVO : list) {
			System.out.println(goodsVO.toString());
		}
		
		context.close();
	}
}
