package com.cg.sports.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cardName;
	private String cardNumber;
    private LocalDate cardExpiry;
    private int cvv;
	
    // Constructors
    public Card() {
    	super();
    }
    
    public Card(String cardName, String cardNumber, LocalDate cardExpiry, int cvv) {
		super();
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
	}

    // Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	// toString
	@Override
	public String toString() {
		return "Card [cardName=" + cardName + ", cardNumber=" + cardNumber + ", cardExpiry=" + cardExpiry + ", cvv="
				+ cvv + "]";
	}
    
}
