package test01;

import java.util.List;

public class GoodsServiceImpl implements GoodsService{
	private GoodsDAO dao;

	@Override
	public int insertGoods(GoodsVO vo) {
		return dao.insertGoods(vo);
	}

	@Override
	public int updateGoods(GoodsVO vo) {
		return dao.updateGoods(vo);
	}

	@Override
	public int deleteGoods(GoodsVO vo) {
		return dao.deleteGoods(vo);
	}

	@Override
	public GoodsVO getGoods(GoodsVO vo) {
		return dao.getGoods(vo);
	}

	@Override
	public List<GoodsVO> getGoodsList() {
		return dao.getGoodsList();
	}

	public GoodsDAO getDao() {
		return dao;
	}

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
}
