package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.ItemEntity;
import com.example.demo.forms.ItemForm;
import com.example.demo.repositries.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	/*
	 * itemテーブルの全件を取得
	 */
	public List<ItemEntity> findAll(){
		List<ItemEntity> items = itemRepository.findAll();
		return items;
	}
	
	/*
	 * 指定されたidのレコードを取得
	 */
	public ItemEntity findById(Long id) {
		ItemEntity item = itemRepository.findById(id).get();
		return item;
	}
	
	/*
	 * 入力された値をデータベースに登録
	 */
	public void save(ItemForm itemForm) {
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setId(itemForm.getId());
		itemEntity.setName(itemForm.getName());
		itemEntity.setDescription(itemForm.getDescription());
		itemEntity.setPrice(itemForm.getPrice());
		itemRepository.saveAndFlush(itemEntity);
		itemForm.clear();
	}
	
	/*
	 * 指定されたレコードの削除
	 */
	public void deleteItem(long id) {
		ItemEntity item = itemRepository.findById(id).get();
		itemRepository.delete(item);
	}
	
}
