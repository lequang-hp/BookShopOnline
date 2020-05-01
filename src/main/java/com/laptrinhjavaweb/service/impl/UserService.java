package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserDAO userDAO;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public boolean InsertAccountUser(String username, String password, String email, String address, String phone) {
		if(userRepository.findOneByEmail(email) == null && userRepository.findOneByUserName(username) == null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setUserName(username);
			userEntity.setPassword(password);
			userEntity.setEmail(email);
			userEntity.setAddress(address);
			userEntity.setPhone(phone);
			userRepository.save(userEntity);
			userEntity = userRepository.findOneByEmail(email);
			userDAO.CreateRoleUser(userEntity.getId());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public UserDTO findUserByUserName(String username) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		UserDTO dto = new UserDTO();
		if(userEntity == null) {
			throw new UsernameNotFoundException("User not found"); // tra ve file security.xml
		}
		
		else {
			dto = userConverter.toDTO(userEntity);
		}
		return dto;
	}

	@Override
	public List<UserDTO> findAllUser() {
		List<UserEntity> entities = userRepository.findAll();
		List<UserDTO> model = new ArrayList<>();
		for(UserEntity item: entities) {
			if(item.getRoles().size() == 2 || item.getRoles().get(0).getId() == 2) {
				UserDTO dto = userConverter.toDTO(item);
				model.add(dto);
			}
		}
		return model;
	}
	
	@Override
	public List<UserDTO> findAllAdmin(){
		List<UserEntity> entities = userRepository.findAll();
		List<UserDTO> model = new ArrayList<>();
		for(UserEntity item: entities) {
			if(item.getRoles().size() == 2 || item.getRoles().get(0).getId() == 1) {
				UserDTO dto = userConverter.toDTO(item);
				model.add(dto);
			}
		}
		return model;
	}

	@Override
	public boolean InsertAccountAdmin(String username, String password, String email, String address, String phone) {
		if(userRepository.findOneByEmail(email) == null && userRepository.findOneByUserName(username) == null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setUserName(username);
			userEntity.setPassword(password);
			userEntity.setEmail(email);
			userEntity.setAddress(address);
			userEntity.setPhone(phone);
			userRepository.save(userEntity);
			userEntity = userRepository.findOneByEmail(email);
			userDAO.CreateRoleAdmin(userEntity.getId());
			return true;
		}else {
			return false;
		}
	}
}
