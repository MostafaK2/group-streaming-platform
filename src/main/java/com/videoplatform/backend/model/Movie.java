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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// storing movie meta data
@Entity
@Builder
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String movieId;
	// main data title, description release date
	@Column private String title;
	@Column private String description;
	@Column private LocalDateTime releaseDate;
	@Column private int rating;
	
	@Column private String genre;
	@Column private int duration;
	@Column private String director;
	@Column private int imbdRating;
	
	// the relationships between movie and watch history
	// returns the number of watch history per movie overall
	@OneToMany(mappedBy="movie")
	private List<WatchHistory> watchHistory;
}
