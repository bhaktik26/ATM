package com.atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.atm.data.Customer;
import com.atm.impl.AuthenticateImpl;

public class ATM {
	private static int cardId;
	private static int pin;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" Welcome to ATM");
		System.out.println("------------------------------------------");
		System.out.println("Enter cardID");
		try {
			cardId = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid character in card no");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Enter the pin");
		try {
			pin = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid character in pin");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Customer foundCustomer = new AuthenticateImpl().validateCard(cardId);
		if (foundCustomer != null) {
			boolean matchedCustomer = new AuthenticateImpl().checkPIN(pin, foundCustomer);
			if (matchedCustomer) {
				System.out.println("Validated user");
			} else
				System.out.println("Wrong credentials");
		}
	}
}
