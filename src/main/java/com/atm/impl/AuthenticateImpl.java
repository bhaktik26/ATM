package com.atm.impl;

import com.atm.data.Customer;
import com.atm.intf.IAuthenticate;

public class AuthenticateImpl implements IAuthenticate {

	public AuthenticateImpl() {

	}

	public Customer validateCard(int cardID) {
		// iterate over all customers to check if the entered cardId matches
		// that of any customer
		for (Customer c : Customer.values()) {
			if (c.getCardId() == cardID) {
				return c;
			}
		}
		return null;
	}

	public boolean checkPIN(int pin, Customer c) {
		// check if the entered pin is correct
		if (pin == c.getPin())
			return true;
		return false;
	}

}
