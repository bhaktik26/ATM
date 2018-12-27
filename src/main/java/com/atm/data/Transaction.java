package com.atm.data;

public class Transaction {

	private long transactionID;
	private long amount;
	
	public Transaction(long transactionID, long amount) {
		this.transactionID = transactionID;
		this.amount = amount;
	}
	
	public long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
}
