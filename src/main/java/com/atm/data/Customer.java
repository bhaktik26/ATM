package com.atm.data;

public enum Customer {
	A("A", "Z", 123456, 5678, 400000), B("B", "Y", 234567, 6789, 550000), C("C", "X", 345678, 7890, 300000), D("D", "W",
			456789, 8901, 800000), E("E", "V", 567890, 9012, 900000);

	private String name;
	private String surname;
	private int cardId;
	private int pin;
	private long balance;

	private Customer(String name, String surname, int cardId, int pin, long balance) {
		this.name = name;
		this.surname = surname;
		this.cardId = cardId;
		this.pin = pin;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getCardId() {
		return cardId;
	}

	public int getPin() {
		return pin;
	}

	public long getBalance() {
		return balance;
	}

}
