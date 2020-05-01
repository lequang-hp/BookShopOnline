package com.laptrinhjavaweb.converter;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDTO(UserEntity item) {
		UserDTO dto = new UserDTO();
		dto.setId(item.getId());
		dto.setUserName(item.getUserName());
		dto.setEmail(item.getEmail());
		dto.setAddress(item.getAddress());
		dto.setPhone(item.getPhone());
		dto.setCreatedDate((Timestamp) item.getCreatedDate());
		return dto;
	}
}
