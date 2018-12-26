package com.atm.intf;

import com.atm.data.Customer;

public interface ITransact {

	// generate a random transaction id
	public long generateTransactionId();

	// check if user's balance is sufficient for withdrawal
	public boolean checkBalance(Customer c, long amount);

	// subtract the amount withdrawn from user's balance
	// public void deductAmount(Customer c, long amount);

	// store user's transactions
	//public void maintainTransactionStatus(long transactionID, Customer c);
	
	public void printTransactionStatus(Customer c);
}
