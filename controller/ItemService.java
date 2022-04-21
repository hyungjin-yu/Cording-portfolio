package item.controller;

import java.util.List;

import item.bean.ItemDTO;

public interface ItemService {
	public List<ItemDTO> itemList(int startNum, int endNum);
	public int getTotalA();
	public ItemDTO itemView(int seq);
}
