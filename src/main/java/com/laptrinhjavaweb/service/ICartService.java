package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CartDTO;

public interface ICartService {
	boolean InsertCart(String username,Long bookID,int count);
	List<CartDTO> findByUserId(String username);
	void deleteCart(long [] ids);
	int countItemByUserId(String username); // 1 nguoi mua bn san pham
	float totalPriceByUserId(String username); 
	void deleteCart(String username);
}
