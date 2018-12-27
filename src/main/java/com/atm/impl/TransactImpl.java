package com.atm.impl;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

import com.atm.data.Customer;
import com.atm.data.Transaction;
import com.atm.intf.ITransact;

public class TransactImpl implements ITransact {
	private long transactionId;
	private static EnumMap<Customer, Long> balanceMap = new EnumMap<Customer, Long>(Customer.class);
	private static EnumMap<Customer, List<Transaction>> transactionMap = new EnumMap<Customer, List<Transaction>>(
			Customer.class);
	List<Transaction> customersTransactions = new ArrayList<Transaction>();
	Random rand = new Random();

	public void initializeBalanceMap() {
		balanceMap.put(Customer.A, Customer.A.getBalance());
		balanceMap.put(Customer.B, Customer.B.getBalance());
		balanceMap.put(Customer.C, Customer.C.getBalance());
		balanceMap.put(Customer.D, Customer.D.getBalance());
		balanceMap.put(Customer.E, Customer.E.getBalance());
	}

	public void initializeTransactionMap() {
		transactionMap.put(Customer.A, customersTransactions);
		transactionMap.put(Customer.B, customersTransactions);
		transactionMap.put(Customer.C, customersTransactions);
		transactionMap.put(Customer.D, customersTransactions);
		transactionMap.put(Customer.E, customersTransactions);
	}

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
		balanceMap.put(c, balance);
	}

	public void maintainTransactionStatus(long transactionID, Customer c, long amount) {
		customersTransactions.add(new Transaction(transactionID, amount));
		transactionMap.put(c, customersTransactions);
	}

	public void printTransactionStatus(Customer c) {
		System.out.println("Your transaction details are: ");
		System.out.println("-----------------------------------");
		List<Transaction> list = transactionMap.get(c);
		for (Transaction t : list) {
			System.out.println("Transaction id: " + t.getTransactionID() + " Amount: " + t.getAmount());
		}
	}

}
