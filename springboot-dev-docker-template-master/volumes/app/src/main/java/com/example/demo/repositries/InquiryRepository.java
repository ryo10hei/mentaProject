package com.example.demo.repositries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitys.InquiryEntity;

@Repository
public interface InquiryRepository extends JpaRepository<InquiryEntity, String>{
	Optional<InquiryEntity> findById(String id);
	List<InquiryEntity> findAll();
}