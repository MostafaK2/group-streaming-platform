package com.videoplatform.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// dont keep payments in the db find another solutions.
@Entity
@Table(name = "payment")
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
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
	private int cvcsd;	
	
}
