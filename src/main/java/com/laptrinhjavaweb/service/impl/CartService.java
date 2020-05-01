package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.entity.CartEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.BookRepository;
import com.laptrinhjavaweb.repository.CartRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICartService;

@Service
public class CartService implements ICartService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public boolean InsertCart(String username, Long bookID, int count) {
		int t = 0;
		UserEntity userEntity = userRepository.findOneByUserName(username);
		
		List<CartEntity> entities = cartRepository.findByUserId(userEntity.getId());
		for(CartEntity item: entities) {
			if(item.getBookEntity().getId() == bookID){ 
				cartRepository.delete(item.getId()); // Neu co san pham trong gi thi xoa di ghi cai moi 
			 }
		}
		 
		if(t == 0) {
			CartEntity cartEntity = new CartEntity();
			cartEntity.setUser(userEntity);
			cartEntity.setBookEntity(bookRepository.findOne(bookID));
			cartEntity.setCount(count);
			cartRepository.save(cartEntity);
			t = 1;
		}
		
		if(t == 1)
			return true;
		else
			return false;
	}

	@Override
	public List<CartDTO> findByUserId(String username) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		List<CartEntity> entities = cartRepository.findByUserId(userEntity.getId());
		List<CartDTO> model = new ArrayList<>();
		for(CartEntity item: entities) {
			CartDTO dto = new CartDTO();
			dto.setId(item.getId());
			dto.setUser_id(item.getUser().getId());
			dto.setBook_id(item.getBookEntity().getId());
			dto.setTitle(bookRepository.findOne(dto.getBook_id()).getTitle());
			dto.setCount(item.getCount());
			dto.setCreatedDate((Timestamp)item.getCreatedDate());
			dto.setPrice(item.getCount()*item.getBookEntity().getPrice()*(1 - item.getBookEntity().getDiscount()/100));
			model.add(dto);
		}
		return model;
	}

	@Override
	public void deleteCart(long[] ids) {
		for(long id: ids) {
			cartRepository.delete(id);
		}
	}

	@Override
	public int countItemByUserId(String username) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		List<CartEntity> cartEntity = cartRepository.findByUserId(userEntity.getId());		
		return cartEntity.size();
	}

	@Override
	public float totalPriceByUserId(String username) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		List<CartEntity> cartEntity = cartRepository.findByUserId(userEntity.getId());	
		float total = 0;
		for(CartEntity item:cartEntity) {
			CartDTO dto = new CartDTO();
			dto.setPrice(item.getCount()*item.getBookEntity().getPrice()*(1 - item.getBookEntity().getDiscount()/100));
			total = total + dto.getPrice();
		}
		return total;
	}

	@Override
	public void deleteCart(String username) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		List<CartEntity> entities = cartRepository.findByUserId(userEntity.getId());
		for(CartEntity item: entities) {
			cartRepository.delete(item.getId());
		}
	}
}
