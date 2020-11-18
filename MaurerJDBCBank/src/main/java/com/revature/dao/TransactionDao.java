package com.revature.dao;

import java.util.List;


import com.revature.bean.Transaction;

public interface TransactionDao
{
	public List<Transaction> getTransactions(int id);
	public void makeDeposit(double d, double b, int id);
	public void makeWithdrawal(double w, double b, int id);
}