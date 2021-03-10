package com.cg.sports.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.sports.bean.Customer;
import com.cg.sports.bean.Payment;

public class PaymentRepositoryImpl implements IPaymentRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	EntityManager entityManager = factory.createEntityManager();
	
	@Override
	public Payment addPayment(Payment payment) {
		entityManager.getTransaction().begin();
		entityManager.persist(payment);
		entityManager.getTransaction().commit();
		return payment;
	}

	@Override
	public Payment removePayment(long id) {
		entityManager.getTransaction().begin();
		Payment paymentToBeRemoved = getPaymentDetails(id);
		entityManager.remove(paymentToBeRemoved);
		entityManager.getTransaction().commit();
		return paymentToBeRemoved;
	}

	@Override
	public Payment updatePayment(long id, Payment payment) {

		entityManager.getTransaction().begin();
		
		// Retrieve the original payment info
		Payment originalPayment = getPaymentDetails(id);
				
		// Set modified details
		originalPayment.setType(payment.getType());
		originalPayment.setStatus(payment.getStatus());
		originalPayment.setCard(payment.getCard());
	
		entityManager.merge(originalPayment);
		
		entityManager.getTransaction().commit();
		return payment;
	}

	@Override
	public Payment getPaymentDetails(long id) {
		String queryString = "SELECT payment FROM Payment payment WHERE payment.id = :pId";
		TypedQuery<Payment> query = entityManager.createQuery(queryString, Payment.class);
		query.setParameter("pId", id);
		Payment payment = query.getSingleResult();
		return payment == null ? null : payment;
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		String queryString = "SELECT payment FROM Payment payment";
		Query query = entityManager.createQuery(queryString);
		return query.getResultList().isEmpty() ? null : query.getResultList();
	}	
}
