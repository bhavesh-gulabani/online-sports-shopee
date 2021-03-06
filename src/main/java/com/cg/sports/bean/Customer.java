package com.cg.sports.bean;

import java.time.LocalDate;

public class Customer {
	
	private String userId;
	private String name;
	private String email;
	private String contactNo;
	private  LocalDate dob;
	private Address address;
	
	// Constructors
	public Customer() {
		super();
	}
	
	public Customer(String userId, String name, String email, String contactNo, LocalDate dob, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}
}
