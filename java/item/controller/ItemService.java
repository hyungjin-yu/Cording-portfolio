package item.controller;

import java.util.List;

import item.bean.ItemDTO;

public interface ItemService {
	public List<ItemDTO> itemList_category1(String item_category1);
	public List<ItemDTO> itemList_category2(String item_category1, String item_category2);
	public List<ItemDTO> itemList_category3(String item_category1, String item_category2, String item_category3);
	public ItemDTO itemView(String item_code);
	public List<ItemDTO> itemViewList(String item_code);
}
