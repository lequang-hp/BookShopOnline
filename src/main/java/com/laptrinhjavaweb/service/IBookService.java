package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.BookDTO;

public interface IBookService {
	List<BookDTO> findAll();
	List<BookDTO> findByCategoryId(long categoryID);
	List<BookDTO> findByTitle(String searchValue);
	BookDTO findById(long id);
	BookDTO save(BookDTO dto);
	int getTotalItem();
	List<BookDTO> findAll(Pageable pageable);
}
