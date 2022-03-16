package test01;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcExample2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		
		GoodsService goodsService = (GoodsService) context.getBean("goodsService");
		
		// 1. 글 삭제 기능 테스트 : code = "p0001"
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0001");
		
		int result = goodsService.deleteGoods(vo);
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		// 2. 글 목록 기능 테스트
		List<GoodsVO> list = goodsService.getGoodsList();
		for(GoodsVO goodsVO : list) {
			System.out.println(goodsVO.toString());
		}
		
		context.close();
	}
}
