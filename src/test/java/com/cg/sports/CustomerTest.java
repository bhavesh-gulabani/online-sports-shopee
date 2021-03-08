package com.cg.sports;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.cg.sports.bean.Address;
import com.cg.sports.bean.Customer;
import com.cg.sports.dao.CustomerRepositoryImpl;

class CustomerTest {
	static CustomerRepositoryImpl custRepo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		custRepo = new CustomerRepositoryImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Disabled
	@Test
	@Order(1)
	void testAddCustomerNull() {
		Customer customer = null;
		assertEquals(null, custRepo.addCustomer(customer));
	}
	
	@Disabled
	@Test
	@Order(2)
	void testAddCustomer() {
		Address address = new Address("103", "First street", "LA", "NY", "NY", 123456);
		Customer customer = new Customer("John", "john@gmail.com", "9876543210", LocalDate.of(1989, 03, 16), address);

		Customer testResult = custRepo.addCustomer(customer);
		assertEquals(testResult, customer);
		
	}
	
	@Disabled
	@Test
	@Order(3)
	void testRemoveCustomer() {
		
		long customerId = 52;
		Customer customerToBeRemoved = custRepo.getCustomer(customerId);
		Customer testResult = custRepo.removeCustomer(customerId);
		assertEquals(testResult, customerToBeRemoved);
	}
	
	@Test
	@Order(4)
	void testUpdateCustomer() {
		
		long customerId = 58;
	
		Address address = new Address("105", "Second street", "LA", "NY", "NY", 123456);
		Customer newCustomerDetails = new Customer("John", "john123@gmail.com", "9876543210", LocalDate.of(1989, 03, 16), address);
		
		Customer testResult = custRepo.updateCustomer(customerId, newCustomerDetails);
		assertEquals(testResult, newCustomerDetails);
	}
	
	@Disabled
	@Test
	@Order(5)
	void testgetCustomer() {
		long customerId = 58;
		
		Address address = new Address("103", "First street", "LA", "NY", "NY", 123456);
		Customer customerExpected = new Customer("John", "john@gmail.com", "9876543210", LocalDate.of(1989, 03, 16), address);
		customerExpected.setUserId(58);
		 
		Customer testResult = custRepo.getCustomer(customerId);
		
		// Fails due to reference comparison
		// assertEquals(testResult, customerExpected);
		
		assertAll("Test both customer objects",
			    () -> assertEquals(customerExpected.getName(), testResult.getName()),
			    () -> assertEquals(customerExpected.getEmail(), testResult.getEmail()),
			    () -> assertEquals(customerExpected.getDob(), testResult.getDob()),
			    () -> assertEquals(customerExpected.getContactNo(), testResult.getContactNo()),
			    () -> assertEquals(customerExpected.getAddress().getArea(), testResult.getAddress().getArea()),
			    () -> assertEquals(customerExpected.getAddress().getCity(), testResult.getAddress().getCity()),
			    () -> assertEquals(customerExpected.getAddress().getDoorNo(), testResult.getAddress().getDoorNo()),
			    () -> assertEquals(customerExpected.getAddress().getPincode(), testResult.getAddress().getPincode()),
			    () -> assertEquals(customerExpected.getAddress().getState(), testResult.getAddress().getState()),
			    () -> assertEquals(customerExpected.getAddress().getStreet(), testResult.getAddress().getStreet()));
	}

	@Disabled
	@Test
	@Order(6)
	void getAllCustomers() {
		List<Customer> testResult = custRepo.getAllCustomers();
		assertNotNull(testResult);
	}
}