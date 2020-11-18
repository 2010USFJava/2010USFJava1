package com.reavture.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Account;
import com.revature.bean.Customer;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDao
{
	List<Account> acctList = new ArrayList<>();
	public static ConnFactory cf = ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();	

	@Override
	public List<Account> getAcctsByCustId(int id) 
	{
		try 
		{
				String sql = "select bank_account_id, acct_type, balance from account\n"
						+ "where cust_id =?\n"
						+ "order by bank_account_id asc;";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					acctList.add(new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
				}
				return acctList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return acctList;			
	}

	@Override
	public double getBalanceById(int id) throws SQLException 
	{
		String sql = "select balance from account where bank_account_id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
			
		double balance = 0;
		while(rs.next())
		{
			balance = rs.getDouble(1);
		}
		
		return balance;	
	}

	@Override
	public void updateBalance(double b, int id) 
	{
		try 
		{
			String sql = "update account set balance = ? where Bank_account_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, b);
			ps.setDouble(2, id);
			ps.executeUpdate();
	
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void addAccount(int id, String type)
	{
		String t;
		
		if(type.equalsIgnoreCase("c"))
		{
			t = "checking";
		}else
		{
			t = "savings";
		}
		
		try 
		{
			String sql = "insert into account values(default, ?, 0, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t);
			ps.setInt(2, id);
			ps.executeUpdate();
	
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		
	}

	@Override
	public void createNewAccount(Customer c, String t) 
	{
		String type;
		
		if(t.equalsIgnoreCase("c"))
		{
			type = "checking";
		}else
		{
			type = "savings";
		}
		
		try 
		{
			String sql = "insert into account values(default, ?, 0, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ps.setInt(2, c.getId());
			ps.executeUpdate();
	
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}				
	}

	@Override
	public void deleteAccount(int id) 
	{
		try
		{
			String sql = "delete from account where bank_account_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}
}