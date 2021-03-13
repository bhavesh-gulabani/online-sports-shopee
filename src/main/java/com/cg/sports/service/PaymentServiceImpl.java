package com.cg.sports.service;

import java.util.List;

import com.cg.sports.bean.Payment;
import com.cg.sports.dao.PaymentRepositoryImpl;

public class PaymentServiceImpl implements IPaymentService {

	PaymentRepositoryImpl paymentRepo = new PaymentRepositoryImpl();
	
	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepo.addPayment(payment);
	}

	@Override
	public Payment removePayment(long id) {
		return paymentRepo.removePayment(id);
	}

	@Override
	public Payment updatePayment(long id, Payment payment) {
		return paymentRepo.updatePayment(id, payment);
	}

	@Override
	public Payment getPaymentDetails(long id) {
		return paymentRepo.getPaymentDetails(id);
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		return paymentRepo.getAllPaymentDetails();
	}

}
