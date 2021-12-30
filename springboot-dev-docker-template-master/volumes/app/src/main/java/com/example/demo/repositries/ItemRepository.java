package com.example.demo.repositries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitys.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String>{
	Optional<ItemEntity> findById(long id);
	List<ItemEntity> findAll();
}