package edu.sabanciuniv.cs310.bank.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sabanciuniv.cs310.bank.model.BankAccount;
import edu.sabanciuniv.cs310.bank.model.Customer;

public class MainClassWithJPA {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs310");
		EntityManager entityManager =emf.createEntityManager();
	

		BankAccount acc1 = new BankAccount(123, 10000, null);
		Customer c1 = new Customer(1, "Yasin", "Aydin", "Tuzla", acc1);
		
		
		BankAccount acc2 = new BankAccount(124, 6000, null);
		Customer c2 = new Customer(2, "Ali", "Desidero", "Ankara", acc2);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(c1);
		entityManager.persist(acc1);
		entityManager.persist(c2);
		entityManager.persist(acc2);

		entityManager.getTransaction().commit();


		//Using the customers in database and creating transfer between them

		Customer sender = entityManager.find(Customer.class, 2);
		Customer receiver = entityManager.find(Customer.class, 1);
		
		sender.makeMoneyTransfer(800, receiver);

		entityManager.getTransaction().begin();
		
		entityManager.merge(sender);
		entityManager.merge(receiver);
		entityManager.merge(sender.getBankAccount());
		entityManager.merge(receiver.getBankAccount());
		
		entityManager.getTransaction().commit();

		System.out.println(sender);
		System.out.println(receiver);

	}
}
