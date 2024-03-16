package com.videoplatform.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WatchHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String watchId;
	
	@Column
	private LocalDateTime timestamp;
}
