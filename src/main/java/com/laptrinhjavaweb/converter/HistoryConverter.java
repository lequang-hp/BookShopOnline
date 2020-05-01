package com.laptrinhjavaweb.converter;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.HistoryDTO;
import com.laptrinhjavaweb.entity.HistoryEntity;
import com.laptrinhjavaweb.repository.BookRepository;

@Component
public class HistoryConverter {
	@Autowired
	private BookRepository bookRepository;
	
	public HistoryDTO toDTO(HistoryEntity item) {
		HistoryDTO dto = new HistoryDTO();
		dto.setId(item.getId());
		dto.setUser_id(item.getUser().getId());
		dto.setBook_id(item.getBookEntity().getId());
		dto.setTitle(bookRepository.findOne(dto.getBook_id()).getTitle());
		dto.setImg(bookRepository.findOne(dto.getBook_id()).getImg());
		dto.setCount(item.getCount());
		dto.setBillId(item.getBill().getId());
		dto.setCreatedDate((Timestamp)item.getCreatedDate());
		dto.setCreatedBy(item.getCreatedBy());
		dto.setPrice(item.getCount()*item.getBookEntity().getPrice()*(1 - item.getBookEntity().getDiscount()/100));
		return dto;
	}
}