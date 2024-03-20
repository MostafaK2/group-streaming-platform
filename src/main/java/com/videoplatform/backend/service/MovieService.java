package com.videoplatform.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoplatform.backend.model.Movie;
import com.videoplatform.backend.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public void addMovie(Movie movie) {
		movieRepository.save(movie);
		
	}
}
