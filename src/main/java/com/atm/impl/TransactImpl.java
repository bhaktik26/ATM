package com.atm.impl;

import java.util.Random;

import com.atm.data.Customer;
import com.atm.intf.ITransact;

public class TransactImpl implements ITransact {
	private long transactionId;
	Random rand = new Random();

	public long generateTransactionId() {
		// generate a long random number
		transactionId = rand.nextLong();
		return transactionId;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public boolean checkBalance(Customer c, long amount) {
		// assuming no minimum balance expected to be saved in account
		if (c.getBalance() >= amount) {
			deductAmount(c, amount);
			return true;
		}
		return false;
	}

	private void deductAmount(Customer c, long amount) {
		long balance = c.getBalance();
		balance = balance - amount;

	}

	public void maintainTransactionStatus(long transactionID, Customer c) {

	}

	public void printTransactionStatus(Customer c) {

	}

}
