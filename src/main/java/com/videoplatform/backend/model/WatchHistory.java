package com.videoplatform.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WatchHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String watchId;
	
	@Column
	private LocalDateTime timestamp;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;
}
