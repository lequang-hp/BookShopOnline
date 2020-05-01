package com.laptrinhjavaweb.dao;

public interface IUserDAO {
	boolean CheckAccount(String email);
	boolean InsertAccount(String username,String password,String email,String address,String phone);
	void CreateRoleUser(Long userID);
	void CreateRoleAdmin(Long userID);
}
