package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.HistoryDTO;

public interface IHistoryService {
	void InsertHistory(String username,Long bookID,int count,long billId);
	List<HistoryDTO> findByUserId(String username);
	int countItemByUserId(String username); // 1 nguoi mua bn san pham 
	List<HistoryDTO> findByBillId(Long billId);
}
