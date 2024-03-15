package com.videoplatform.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String paymentId;
	
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime dateAdded;
	
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime expirationDate;
	@Column
	private String cardType;
	@Column
	private int cardNumber;
	@Column
	private int cvc;	
	
}
