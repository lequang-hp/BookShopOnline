package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DB.DBConnection;
import com.laptrinhjavaweb.dao.IBillDAO;

@Repository
public class BillDAO implements IBillDAO{

	@Override
	public Long findBillIdLatest() {
		String sql = "SELECT id FROM bill ORDER BY id DESC LIMIT 1";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		long id = 0;
		try {
			connection = DBConnection.CreateConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				id = resultSet.getLong("id");
			}
		}catch(Exception e) {
			return null;
		}
		return id;
	}

}
