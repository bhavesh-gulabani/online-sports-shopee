package com.cg.sports.bean;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

// Extends User so will receive its members automatically including id

@Entity
public class Customer extends User {
	
	private String name;
	private String email;
	private String contactNo;
	private  LocalDate dob;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;
	
	// Constructors
	public Customer() {
		super();
	}
	
	public Customer(String username, String password, String role, String name, String email, String contactNo,
			LocalDate dob, Address address) {
		super(username, password, role);
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", contactNo=" + contactNo + ", dob=" + dob
				+ ", address=" + address + "]";
	}
	
	// toString
//	@Override
//	public String toString() {
//		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
//				+ ", dob=" + dob + ", address=" + address + "]";
//	}
	
	
	
}
