package com.reavture.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bean.Customer;
import com.revature.dao.CustomerDao;
import com.revature.util.ConnFactory;

public class CustomerDaoImpl implements CustomerDao
{
	public static ConnFactory cf = ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();	

	@Override
	public Customer getCustomerByUserName(String email) throws SQLException 
	{
		//Connection conn = cf.getConnection();
		String sql = "select * from customer where email=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		
		Customer c = null;
		
		while(rs.next())
		{
			c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6),
					rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10));
		}
		
		return c;
	}

	@Override
	public void createCustomer(Customer c) 
	{
		try 
		{
			String sql = "insert into customer values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getfName());
			ps.setString(4, c.getlName());
			ps.setString(5, c.getSsn());
			ps.setString(6, c.getAddress());
			ps.setString(7, c.getCity());
			ps.setString(8, c.getState());
			ps.setString(9, c.getZip());
			ps.executeUpdate();
	
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}			
	}
}