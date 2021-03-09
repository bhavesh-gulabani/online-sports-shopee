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

import com.cg.sports.bean.Card;
import com.cg.sports.bean.Payment;
import com.cg.sports.dao.PaymentRepositoryImpl;

class PaymentTest {
	static PaymentRepositoryImpl paymentRepo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		paymentRepo = new PaymentRepositoryImpl();
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
	void testAddPaymentNull() {
		Payment payment = null;
		assertEquals(null, paymentRepo.addPayment(payment));
	}
	
	@Disabled
	@Test
	@Order(2)
	void testAddPayment() {
		Card card = new Card("Silver", "123456", LocalDate.of(2030, 05, 12), 12345);
		Payment payment = new Payment("card", "paid", card);

		Payment testResult = paymentRepo.addPayment(payment);
		assertEquals(testResult, payment);
		
	}
	
	@Disabled
	@Test
	@Order(3)
	void testRemovePayment() {
		
		long paymentId = 61;
		Payment paymentToBeRemoved = paymentRepo.getPaymentDetails(paymentId);
		Payment testResult = paymentRepo.removePayment(paymentId);
		assertEquals(testResult, paymentToBeRemoved);
	}
	
	@Disabled
	@Test
	@Order(4)
	void testUpdatePayment() {
		
		long paymentId = 58;
	
		Card card = new Card("Gold", "123456", LocalDate.of(2030, 05, 12), 9876);
		Payment newPaymentDetails = new Payment("card", "paid", card);
		
		Payment testResult = paymentRepo.updatePayment(paymentId, newPaymentDetails);
		assertEquals(testResult, newPaymentDetails);
	}
	
	@Disabled
	@Test
	@Order(5)
	void testgetPayment() {
		long paymentId = 63;
		
		Card card = new Card("Silver", "123456", LocalDate.of(2030, 05, 12), 12345);
		card.setId(64);
		Payment paymentExpected = new Payment("card", "paid", card);
		paymentExpected.setPaymentId(63);
		
		 
		Payment testResult = paymentRepo.getPaymentDetails(paymentId);
		
		// Fails due to reference comparison
		// assertEquals(testResult, customerExpected);
		
		assertAll("Test both payment objects",
			    () -> assertEquals(paymentExpected.getPaymentId(), testResult.getPaymentId()),
			    () -> assertEquals(paymentExpected.getType(), testResult.getType()),
			    () -> assertEquals(paymentExpected.getStatus(), testResult.getStatus()),
			    () -> assertEquals(paymentExpected.getCard().getId(), testResult.getCard().getId()),
			    () -> assertEquals(paymentExpected.getCard().getCardName(), testResult.getCard().getCardName()),
			    () -> assertEquals(paymentExpected.getCard().getCardNumber(), testResult.getCard().getCardNumber()),
			    () -> assertEquals(paymentExpected.getCard().getCardExpiry(), testResult.getCard().getCardExpiry()),
			    () -> assertEquals(paymentExpected.getCard().getCvv(), testResult.getCard().getCvv()));
	}

	@Disabled
	@Test
	@Order(6)
	void testGetAllPaymentDetails() {
		List<Payment> testResult = paymentRepo.getAllPaymentDetails();
		assertNotNull(testResult);
	}

}
