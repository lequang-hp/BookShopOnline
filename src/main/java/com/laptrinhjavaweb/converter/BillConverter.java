package com.laptrinhjavaweb.converter;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BillDTO;
import com.laptrinhjavaweb.entity.BillEntity;

@Component
public class BillConverter {
	public BillDTO toDTO (BillEntity item) {
		BillDTO dto = new BillDTO();
		dto.setId(item.getId());
		dto.setUserId(item.getUser().getId());
		dto.setTotal(item.getTotal());
		dto.setCreatedBy(item.getCreatedBy());
		dto.setCreatedDate((Timestamp) item.getCreatedDate());
		dto.setDeliveryAddress(item.getDeliveryAddress());
		return dto;
	}
}
