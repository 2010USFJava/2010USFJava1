package com.reavture.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Account;
import com.revature.bean.Transaction;
import com.revature.dao.TransactionDao;
import com.revature.util.ConnFactory;

public class TransactionDaoImpl implements TransactionDao
{
	public List<Transaction> transList = new ArrayList<>();
	public static ConnFactory cf = ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();	

	@Override
	public List<Transaction> getTransactions(int id) 
	{
		try 
		{
			//Connection conn = cf.getConnection();
			
			String sql = "select transaction_id, deposit, withdrawal, new_balance\n"
				+ "from transactions\n"
				+ "where bank_account_id =?\n"
				+ "order by transaction_id desc;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			transList.add(new Transaction(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4)));
		}
		return transList;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return transList;	
		
	}

	@Override
	public void makeDeposit(double d, double b, int id) 
	{
		try 
		{
			//Connection conn = cf.getConnection();
			String sql = "insert into transactions values(default, ?, 0, ?,  ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, d);
			ps.setDouble(2, b);
			ps.setInt(3, id);
			ps.executeUpdate();
	
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void makeWithdrawal(double w, double b, int id) 
	{
		try 
		{
			String sql = "insert into transactions values(default, 0, ?, ?,  ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, w);
			ps.setDouble(2, b);
			ps.setInt(3, id);
			ps.executeUpdate();
	
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}

}
