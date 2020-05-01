package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DB.DBConnection;
import com.laptrinhjavaweb.dao.IUserDAO;

@Repository
public class UserDAO implements IUserDAO{

	@Override
	public boolean CheckAccount(String email) {
		List<Long> ids = new ArrayList<Long>();
		Connection conn = DBConnection.CreateConnection();
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "SELECT id FROM user WHERE email='" + email+"'" ;
		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				Long id = rs.getLong("id");
				ids.add(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(ids.size() == 0) return true;
		else return false;
	}
	
	
	@Override
	public boolean InsertAccount(String username, String password, String email, String address, String phone) {
		Connection conn = DBConnection.CreateConnection();
		PreparedStatement ptmt = null;
		String sql = "insert into user(username,password,email,address,phone) values(?,?,?,?,?)";
		
		try {
			ptmt = conn.prepareStatement(sql);
	
			ptmt.setString(1, username);
			ptmt.setString(2, password);
			ptmt.setString(3, email);
			ptmt.setString(4, address);
			ptmt.setString(5, phone);
			ptmt.executeUpdate();
			ptmt.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public void CreateRoleUser(Long userID) {
		Connection conn = DBConnection.CreateConnection();
		PreparedStatement ptmt = null;
		String sql = "insert into user_role(userid,roleid) values(?,?)";
		
		
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setLong(1, userID);
			ptmt.setLong(2, 2);
			ptmt.executeUpdate();
			ptmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	@Override
	public void CreateRoleAdmin(Long userID) {
		Connection conn = DBConnection.CreateConnection();
		PreparedStatement ptmt = null;
		String sql = "insert into user_role(userid,roleid) values(?,?)";
		
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setLong(1, userID);
			ptmt.setLong(2, 1);
			ptmt.executeUpdate();
			ptmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
