package edu.sabanciuniv.cs310.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	private int customerID;

	private String name;
	private String lastname;
	private String address;

	//Convention
	@OneToOne
	private BankAccount bankAccount;

	public Customer() {
		super();
	}

	public Customer(int customerID, String name, String lastname, String address, BankAccount bankAccount) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.bankAccount = bankAccount;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}


	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", lastname=" + lastname + ", address="
				+ address + ", bankAccount=" + bankAccount + "]";
	}

	public boolean makeMoneyTransfer(double amount,Customer recevier)
	{
		this.bankAccount.setBalance(this.bankAccount.getBalance() - amount);
		recevier.getBankAccount().setBalance(recevier.getBankAccount().getBalance()+amount);
		return true;
	}
	
}
