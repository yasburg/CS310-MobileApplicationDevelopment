package edu.sabanciuniv.cs310.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BankAccount {
	
	@Id
	private int iban;
	private double balance;
	private String currency;
	
	@OneToOne
	private Customer customer;

	public BankAccount() {
		super();
	}

	public BankAccount(int iban, double balance, Customer customer) {
		super();
		this.iban = iban;
		this.balance = balance;
		this.customer = customer;
	}

	public int getIban() {
		return iban;
	}

	public void setIban(int iban) {
		this.iban = iban;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BankAccount [iban=" + iban + ", balance=" + balance +"]";
	}
	
	
	

}
