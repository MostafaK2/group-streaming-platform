package com.videoplatform.backend.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// storing movie meta data
@Entity
@Table(name = "movie")
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
public class Movie {
	
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
	
	// the relationships between movie and watch history
	// returns the number of watch history per movie overall
	@OneToMany(mappedBy="movie")
	private List<WatchHistory> watchHistory;
}
