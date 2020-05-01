package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.BookEntity;


public interface BookRepository extends JpaRepository<BookEntity, Long>{
	List<BookEntity> findByTitleContainingIgnoreCase(String searchValue);
	List<BookEntity> findByCategoryId(Long categoryId);
}
