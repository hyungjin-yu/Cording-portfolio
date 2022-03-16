package test01;

import java.util.List;

public interface GoodsService {
	public int insertGoods(GoodsVO vo);

	public int updateGoods(GoodsVO vo);

	public int deleteGoods(GoodsVO vo);

	public GoodsVO getGoods(GoodsVO vo);

	public List<GoodsVO> getGoodsList();
}
