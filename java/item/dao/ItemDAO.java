package item.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import item.bean.ItemDTO;

@Repository
public class ItemDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 상품 목록 : 카테고리1
	public List<ItemDTO> itemList_category1(String item_category1) {
		return sqlSession.selectList("mybatis.itemMapper.itemList_category1", item_category1);
	}
	
	// 상품 목록 : 카테고리2
	public List<ItemDTO> itemList_category2(String item_category1, String item_category2) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("item_category1", item_category1);
		map.put("item_category2", item_category2);
		return sqlSession.selectList("mybatis.itemMapper.itemList_category2", map);
	}
	
	// 상품 목록 : 카테고리2
	public List<ItemDTO> itemList_category3(String item_category1, String item_category2, String item_category3) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("item_category1", item_category1);
		map.put("item_category2", item_category2);
		map.put("item_category3", item_category3);
		return sqlSession.selectList("mybatis.itemMapper.itemList_category3", map);
	}
		
	// 상품 상세보기
	public ItemDTO itemView(String item_code) {
		return sqlSession.selectOne("mybatis.itemMapper.itemView", item_code);
	}
	
	// 상품 1줄 리스트로 가져오기
	public List<ItemDTO> itemViewList(String item_code) {
		return sqlSession.selectList("mybatis.itemMapper.itemView", item_code);
	}
}
