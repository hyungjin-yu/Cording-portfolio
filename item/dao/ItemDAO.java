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
	
	// 상품 목록
	public List<ItemDTO> itemList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.itemMapper.itemList", map);
	}
	
	// 상품 총 개수 구하기
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.itemMapper.getTotalA");
	}
	
	// 상품 등록
	public int itemWrite(ItemDTO dto) {
		return sqlSession.insert("mybatis.itemMapper.itemWrite", dto);
	}
	
	// 상품 상세보기
	public ItemDTO itemView(int seq) {
		return sqlSession.selectOne("mybatis.itemMapper.itemView", seq);
	}
}
