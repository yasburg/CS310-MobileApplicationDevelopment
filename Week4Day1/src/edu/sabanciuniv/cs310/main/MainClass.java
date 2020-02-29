package edu.sabanciuniv.cs310.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sabanciuniv.cs310.domain.Employee;

public class MainClass {

	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs310");
		EntityManager entityManager = emf.createEntityManager();

		Employee e = new Employee(123, "Yasin");
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(e);
		
		entityManager.getTransaction().commit();

	}
}
