package com.atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.atm.data.Customer;
import com.atm.impl.AuthenticateImpl;
import com.atm.impl.TransactImpl;

public class ATM {
	private static int cardId;
	private static int pin;
	private static long transactionId;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" Welcome to ATM");
		System.out.println("------------------------------------------");

		// ask user for his card id
		System.out.println("Enter cardID");
		try {
			cardId = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid character in card no");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ask user for pin
		System.out.println("Enter the pin");
		try {
			pin = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid character in pin");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// first validate the card no and then the pin, only after successful
		// validation initiate any transaction
		Customer foundCustomer = new AuthenticateImpl().validateCard(cardId);
		if (foundCustomer != null) {
			boolean matchedCustomer = new AuthenticateImpl().checkPIN(pin, foundCustomer);
			if (matchedCustomer) {
				System.out.println("Validated user");
			} else {
				System.out.println("Wrong credentials");
			}
		}

		// check if the amount requested is less than the balance
		System.out.println("Enter the amount you want to withdraw");
		long withdrawalAmt = Long.parseLong(br.readLine());
		boolean isSufficientBalance = new TransactImpl().checkBalance(foundCustomer, withdrawalAmt);
		if(isSufficientBalance) {
			transactionId = new TransactImpl().generateTransactionId();
			
		}
		else {
			System.out.println("Insufficient balance in your account");
		}
	}
}
