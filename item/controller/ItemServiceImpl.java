package item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import item.bean.ItemDTO;
import item.dao.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDAO dao;

	@Override
	public List<ItemDTO> itemList() {
		return dao.itemList();
	}

	@Override
	public int getTotalA() {
		return dao.getTotalA();
	}

	@Override
	public ItemDTO itemView() {
		return dao.itemView();
	}

}
