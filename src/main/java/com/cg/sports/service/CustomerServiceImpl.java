package com.cg.sports.service;

import java.util.List;

import com.cg.sports.bean.Customer;
import com.cg.sports.dao.CustomerRepositoryImpl;

public class CustomerServiceImpl implements ICustomerService {

	CustomerRepositoryImpl custRepo = new CustomerRepositoryImpl();
	@Override
	public Customer addCustomer(Customer customer) {
		return custRepo.addCustomer(customer);
	}

	@Override
	public Customer removeCustomer(long custId) {
		return custRepo.removeCustomer(custId);
	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		return custRepo.updateCustomer(custId, customer);
	}

	@Override
	public Customer getCustomer(long custId) {
		return custRepo.getCustomer(custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return custRepo.getAllCustomers();
	}

}
