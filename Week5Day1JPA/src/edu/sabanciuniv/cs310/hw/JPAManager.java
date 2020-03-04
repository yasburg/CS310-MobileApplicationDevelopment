package edu.sabanciuniv.cs310.hw;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAManager {

	public static void insertOneEmployee(Employee2 e1)
	{
		try 
		{
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs310");
			EntityManager entityManager = emf.createEntityManager();
		
			entityManager.getTransaction().begin();
			entityManager.persist(e1);
			entityManager.getTransaction().commit();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
