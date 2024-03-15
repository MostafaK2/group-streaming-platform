package com.videoplatform.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WatchHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String watchId;
}
