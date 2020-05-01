package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.BillDTO;

public interface IBillService {
	void InsertBill(String username,float total,String deliveryAddress);
	List<BillDTO> findAll();
	Long findBillIdLatest();
}
