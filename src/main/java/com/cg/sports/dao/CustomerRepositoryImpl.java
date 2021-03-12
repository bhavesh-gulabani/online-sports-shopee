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
		entityManager.getTransaction().begin();
		Customer customerToBeRemoved = getCustomer(custId);		
		entityManager.remove(customerToBeRemoved);
		entityManager.getTransaction().commit();
		return customerToBeRemoved;
	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		
		entityManager.getTransaction().begin();
		
		// Retrieve the original customer
		Customer originalCustomer = getCustomer(custId);
		
		// Set modified details
		originalCustomer.setName(customer.getName());
		originalCustomer.setEmail(customer.getEmail());
		originalCustomer.setDob(customer.getDob());
		originalCustomer.setContactNo(customer.getContactNo());
		originalCustomer.setAddress(customer.getAddress());
	
		entityManager.merge(originalCustomer);
		entityManager.getTransaction().commit();
		
		return customer;
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
