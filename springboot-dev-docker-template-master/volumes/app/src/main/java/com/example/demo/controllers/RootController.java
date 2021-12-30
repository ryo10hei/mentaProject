package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entitys.Inquiry2Entity;

import com.example.demo.forms.InquiryForm;
import com.example.demo.forms.InquiryForm2;
import com.example.demo.services.InquiryService;
import com.example.demo.services.InquiryService2;


@Controller
@RequestMapping("/")
public class RootController {

//各オブジェクトをインスタンス化して変数に代入
	@Autowired
	InquiryService inquiryService;
	@Autowired
	InquiryService2 inquiryService2;
	
	@GetMapping
	public String index() {

		return "root/index";
	}
	
	//InquiryFormクラスを引数に持たせて、viewのformでInqueiryFormのフィールドを操作できる状態でformを返す
	@GetMapping("/form")
	public String form(InquiryForm inquiryForm) {
		return "root/form";
	}
	
	@GetMapping("/form2")
	public String form2(InquiryForm2 inquiryForm2) {
		return "root/form2";
	}

//	viewから入力情報を取得し、エラーチェック後、テーブルに保存
	@PostMapping("/form")
	public String form(@Validated InquiryForm inquiryForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/form";
		}
		// RDBと連携できることを確認しておきます。
		//入力された値をデータベースに保存	
		inquiryService.save(inquiryForm);
		inquiryForm.clear();
		model.addAttribute("message", "お問い合わせを受け付けました。");
		return "root/form";
	}
		
//	viewから入力情報を取得し、エラーチェック後、テーブルに保存
	@PostMapping("/form2")
	public String form2(@Validated InquiryForm2 inquiryForm2, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/form2";
		}
		inquiryService2.save(inquiryForm2);
		inquiryForm2.clear();
		model.addAttribute("message", "お問い合わせを受け付けました。");
		return "root/form2";
	}
	
}