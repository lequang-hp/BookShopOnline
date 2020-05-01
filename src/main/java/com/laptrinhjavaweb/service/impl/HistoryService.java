package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.HistoryConverter;
import com.laptrinhjavaweb.dto.HistoryDTO;
import com.laptrinhjavaweb.entity.HistoryEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.BillRepository;
import com.laptrinhjavaweb.repository.BookRepository;
import com.laptrinhjavaweb.repository.HistoryRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IHistoryService;

@Service
public class HistoryService implements IHistoryService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HistoryRepository historyRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private HistoryConverter historyConverter;
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public void InsertHistory(String username, Long bookID, int count,long billId) {
		HistoryEntity historyEntity = new HistoryEntity();
		historyEntity.setUser(userRepository.findOneByUserName(username));
		historyEntity.setBookEntity(bookRepository.findOne(bookID));
		historyEntity.setCount(count);
		historyEntity.setBill(billRepository.findOne(billId));
		historyRepository.save(historyEntity);
	}

	@Override
	public List<HistoryDTO> findByUserId(String username) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		List<HistoryEntity> entities = historyRepository.findByUserId(userEntity.getId());
		List<HistoryDTO> model = new ArrayList<>();
		for(HistoryEntity item: entities) {
			HistoryDTO dto = historyConverter.toDTO(item);
			model.add(dto);
		}
		return model;
	}

	@Override
	public int countItemByUserId(String username) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		List<HistoryEntity> historyEntity = historyRepository.findByUserId(userEntity.getId());		
		return historyEntity.size();
	}

	@Override
	public List<HistoryDTO> findByBillId(Long billId) {
		List<HistoryEntity> entities = historyRepository.findByBillId(billId);
		List<HistoryDTO> model = new ArrayList<>();
		for(HistoryEntity item: entities) {
			HistoryDTO dto = historyConverter.toDTO(item);
			model.add(dto);
		}
		return model;
	}
}
