package com.atm.intf;

import com.atm.data.Customer;

public interface IAuthenticate {

	// checks if the card no entered by user is valid
	public Customer validateCard(int cardID);

	// checks if the pin matches that in the records
	public boolean checkPIN(int pin, Customer customer);
}
