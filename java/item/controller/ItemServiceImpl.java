package item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cart.dao.CartDAO;
import item.bean.ItemDTO;
import item.dao.ItemDAO;
import review.dao.ReviewDAO;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDAO dao;

	@Override
	public List<ItemDTO> itemList_category1(String item_category1) {
		return dao.itemList_category1(item_category1);
	}
	
	@Override
	public List<ItemDTO> itemList_category2(String item_category1, String item_category2) {
		return dao.itemList_category2(item_category1, item_category2);
	}
	
	@Override
	public List<ItemDTO> itemList_category3(String item_category1, String item_category2, String item_category3) {
		return dao.itemList_category3(item_category1, item_category2, item_category3);
	}
	
	@Override
	public ItemDTO itemView(String item_code) {
		return dao.itemView(item_code);
	}

	@Override
	public List<ItemDTO> itemViewList(String item_code) {
		return dao.itemViewList(item_code);
	}
	
}
