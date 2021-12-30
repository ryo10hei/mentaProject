package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.InquiryEntity;
import com.example.demo.forms.InquiryForm;
import com.example.demo.repositries.InquiryRepository;


@Service
public class InquiryService {

	@Autowired
	InquiryRepository repository;

	
	
	
	/*
	 * 入力された値をテーブルに保存
	 */
	public void save(InquiryForm inquiryForm) {
		InquiryEntity inquiryEntity = new InquiryEntity();
		inquiryEntity.setId(inquiryForm.getId());
		inquiryEntity.setName(inquiryForm.getName());
		inquiryEntity.setMail(inquiryForm.getMail());
		inquiryEntity.setContent(inquiryForm.getContent());
		repository.saveAndFlush(inquiryEntity);
	}
	
}
