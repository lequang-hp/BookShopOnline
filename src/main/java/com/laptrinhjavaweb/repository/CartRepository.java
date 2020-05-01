package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{
	List<CartEntity> findByUserId(Long userID);
}
