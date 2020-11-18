package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bean.Account;
import com.revature.bean.Customer;

public interface AccountDao 
{
	public List<Account> getAcctsByCustId(int id);
	public double getBalanceById(int id) throws SQLException;
	public void updateBalance(double b, int id);
	public void addAccount(int id, String type);
	public void createNewAccount(Customer c, String t);
	public void deleteAccount(int id);
}