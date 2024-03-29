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

// implement transactions and payments later on

@Entity
@Table(name = "Transaction")
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String transactionId;
	
	@Column
	private int transactionType;
	
	@Column
	private LocalDateTime transactionDate;
	
	@Column
	private float totalAmount;
	
	// true for valid false for invalid
	@Column
	private boolean transactionStatus;
	
}
