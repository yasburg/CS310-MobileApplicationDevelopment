package edu.sabanciuniv.cs310.bank.main;

import edu.sabanciuniv.cs310.bank.model.BankAccount;
import edu.sabanciuniv.cs310.bank.model.Customer;

public class MainClassNoJPA {

	public static void main(String[] args) {
		
		BankAccount acc1 = new BankAccount(123, 1000, null);
		Customer c1 = new Customer(1, "Ahmet", "Demirelli", "Tuzla", acc1);

		BankAccount acc2 = new BankAccount(124, 6000, null);
		Customer c2 = new Customer(2, "Yasin", "Aydin", "Istanbul", acc2);

		System.out.println(c1);
		System.out.println(c2);

		System.out.println("Money will be transfered");
		c1.makeMoneyTransfer(500, c2);
		
		System.out.println(c1);
		System.out.println(c2);

		//So at the end we do not store these information in the database in order to do that we use JPA in MainClassWithJPA
	}

}
