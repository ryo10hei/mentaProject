package com.example.demo.repositries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitys.Inquiry2Entity;
@Repository
public interface InquiryRepository2 extends JpaRepository<Inquiry2Entity, String>{
	Optional<Inquiry2Entity> findById(String id);
	List<Inquiry2Entity> findAll();
}