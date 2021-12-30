package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entitys.ItemEntity;
import com.example.demo.forms.ItemForm;
import com.example.demo.services.ItemService;


@Controller
@RequestMapping("/item")
public class ItemController {

//各オブジェクトをインスタンス化して変数に代入

	@Autowired
	ItemService itemService;
	


	@GetMapping("/form")
	public String ItemForm(ItemForm itemForm) {
		return "root/itemForm";
	}
	
//	itemテーブルから全件取得し、viewのitemListに一覧で表示
	@GetMapping("/list")
	public String ItemList(Model model) {
		List<ItemEntity> items = itemService.findAll();
		model.addAttribute("items",items);
		return "root/itemList";
	}
	
//	viewからidを受け取り、該当のエンティティをテーブルから取得し、viewのeditに表示
	@GetMapping("/edit")
	public String edit(@RequestParam long id, Model model, ItemForm itemForm) {
		ItemEntity item = itemService.findById(id);
		model.addAttribute("item",item);
		return "root/edit";
	}

//	viewから入力情報を取得し、エラーチェック後、テーブルに保存
	@PostMapping("/itemForm")
	public String itemForm(@Validated ItemForm itemForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/itemForm";
		}
//		itemサービスのsaveメソッドを呼び出す
		itemService.save(itemForm);
		itemForm.clear();
		model.addAttribute("message", "商品を登録しました。");
		return "root/itemForm";
	}
	
//	viewからidの値を受け取り、該当のエンティティをテーブルから取得し、削除
	@PostMapping("/delete")
	  public String delete(@RequestParam long id, Model model) {
		itemService.deleteItem(id);
		model.addAttribute("message","商品を削除しました。");
	    return "root/message";
	}
	
//	viewからidと入力情報を受け取り、受け取ったidの値のまま、入力情報だけを更新
	@PostMapping("/editForm")
	public String editForm(@Validated  ItemForm itemForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/edit";
		}
		itemService.save(itemForm);
		model.addAttribute("message", "商品を更新しました。");
		return "root/message";
	}
	
	
}