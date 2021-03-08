package com.cg.sports.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.sports.bean.Customer;

public class CustomerRepositoryImpl implements ICustomerRepository {
	
	 EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	 EntityManager entityManager = factory.createEntityManager();
	
	@Override
	public Customer addCustomer(Customer customer) {
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();
		return customer;
	}

	@Override
	public Customer removeCustomer(long custId) {
		Customer customerToBeRemoved = getCustomer(custId);
		String queryString = "DELETE Customer customer WHERE customer.userId = :cId";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("cId", custId);
		entityManager.getTransaction().begin();
		int recordsUpdated = query.executeUpdate();
		entityManager.getTransaction().commit();
		return recordsUpdated == -1 ? null : customerToBeRemoved;
		
	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		String queryString = "UPDATE Customer customer SET customer = :c WHERE customer.userId = :cId";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("cId", custId);
		query.setParameter("c", customer);
		
		entityManager.getTransaction().begin();
		int recordsUpdated = query.executeUpdate();
		entityManager.getTransaction().commit();
		
		return recordsUpdated == -1 ? null : getCustomer(custId);
	}

	@Override
	public Customer getCustomer(long custId) {
		String queryString = "SELECT customer FROM Customer customer WHERE customer.userId = :cId";
		TypedQuery<Customer> query = entityManager.createQuery(queryString, Customer.class);
		query.setParameter("cId", custId);
		Customer customer = query.getSingleResult();
		return customer == null ? null : customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		String queryString = "SELECT customer FROM Customer customer";
		Query query = entityManager.createQuery(queryString);
		return query.getResultList().isEmpty() ? null : query.getResultList();
	}
}
