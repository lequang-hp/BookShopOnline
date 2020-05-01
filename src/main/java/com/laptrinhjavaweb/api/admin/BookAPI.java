package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.BookDTO;
import com.laptrinhjavaweb.service.IBookService;

@RestController(value = "bookAPIOfAdmin")
public class BookAPI {

	@Autowired
	private IBookService bookService;
	
	@PostMapping("api/book")
	public BookDTO createBook(@RequestBody BookDTO dto) {
		return bookService.save(dto);
	}
	
	@PutMapping("/api/book")
	public BookDTO updateBook(@RequestBody BookDTO dto) {
		return bookService.save(dto);
	}
}
