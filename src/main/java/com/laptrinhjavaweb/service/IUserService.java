package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {
	boolean InsertAccountUser(String username,String password,String email,String address,String phone);
	boolean InsertAccountAdmin(String username,String password,String email,String address,String phone);
	UserDTO findUserByUserName(String username);
	List<UserDTO> findAllUser();
	List<UserDTO> findAllAdmin();
}
