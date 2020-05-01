package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.BillConverter;
import com.laptrinhjavaweb.dao.IBillDAO;
import com.laptrinhjavaweb.dto.BillDTO;
import com.laptrinhjavaweb.entity.BillEntity;
import com.laptrinhjavaweb.repository.BillRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IBillService;

@Service
public class BillService implements IBillService{
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BillConverter billConverter;
	@Autowired
	private IBillDAO billDAO;
	
	@Override
	public void InsertBill(String username, float total, String deliveryAddress) {
		BillEntity billEntity = new BillEntity();
		billEntity.setUser(userRepository.findOneByUserName(username));
		billEntity.setTotal(total);
		billEntity.setDeliveryAddress(deliveryAddress);
		billRepository.save(billEntity);
	}

	@Override
	public List<BillDTO> findAll() {
		List<BillEntity> entities = billRepository.findAll();
		List<BillDTO> model = new ArrayList<>();
		for(BillEntity item: entities) {
			BillDTO dto = billConverter.toDTO(item);
			model.add(dto);
		}
		return model;
	}

	@Override
	public Long findBillIdLatest() {
		long billId = billDAO.findBillIdLatest();
		return billId;
	}

}
