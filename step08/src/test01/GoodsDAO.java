package test01;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GoodsDAO {
	// sqlSession 객체의 함수들의 동작
	// => xml에 설정한 sql문을 읽어와서 sql문을 완성시킴
	// => db 서버에 sql문을 실행해달라고 요청함
	// => 응답 대기
	// => db 서버에서 응답을 처리함
	private SqlSession sqlSession;
	
	public GoodsDAO() {
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
	}
	
	public int insertGoods(GoodsVO vo) {
		return sqlSession.insert("mybatis.goodsMapper.insertGoods", vo);
	}
	
	public int updateGoods(GoodsVO vo) {
		return sqlSession.update("mybatis.goodsMapper.updateGoods", vo);
	}
	
	public int deleteGoods(GoodsVO vo) {
		return sqlSession.update("mybatis.goodsMapper.deleteGoods", vo);
	}
	
	public GoodsVO getGoods(GoodsVO vo) {
		return (GoodsVO) sqlSession.selectOne("mybatis.goodsMapper.getGoods", vo);
	}
	
	public List<GoodsVO> getGoodsList() {
		return sqlSession.selectList("mybatis.goodsMapper.getGoodsList");
	}
}
