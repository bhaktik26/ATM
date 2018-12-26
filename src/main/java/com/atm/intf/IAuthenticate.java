package com.atm.intf;

import com.atm.data.Customer;

public interface IAuthenticate {
    public Customer validateCard(int cardID);
    
    public boolean checkPIN(int pin, Customer customer);
}
