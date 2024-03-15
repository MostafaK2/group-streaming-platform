package com.videoplatform.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// storing movie meta data
@Entity
@Table(name = "movie")
public class movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String movieId;
	
	@Column
	private String title;
	@Column
	private String description;
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime releaseDate;
	@Column
	private String genre;
	
	@Column
	private int duration;
	@Column
	private String director;
	
	@Column 
	private byte[] poster_image;
	
	@Column
	private LocalDateTime createdAt;
}
