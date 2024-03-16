package com.videoplatform.backend.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String messageId;
	
	@Column
	private String FromUser;
	
	@Column
	private String messageText;
	
	@Column
	private LocalDateTime sentDateTime;
	
	@ManyToOne
	@JoinColumn(name = "party_id")
	@JsonIgnore
	private Party party;
}
