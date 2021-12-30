package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Inquiry2Entity;
import com.example.demo.forms.InquiryForm2;
import com.example.demo.repositries.InquiryRepository2;

@Service
public class InquiryService2 {

	@Autowired
	InquiryRepository2 repository2;
	
	/*
	 * 入力された値をテーブルに保存
	 */
	public void save(InquiryForm2 inquiryForm2) {
		Inquiry2Entity inquiry2Entity = new Inquiry2Entity();
		inquiry2Entity.setId(inquiryForm2.getId());
		inquiry2Entity.setName(inquiryForm2.getName());
		inquiry2Entity.setMail(inquiryForm2.getMail());
		inquiry2Entity.setContent(inquiryForm2.getContent());
		repository2.saveAndFlush(inquiry2Entity);
	}
	
}
