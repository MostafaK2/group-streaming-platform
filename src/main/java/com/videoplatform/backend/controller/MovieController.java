package com.videoplatform.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.videoplatform.backend.model.Movie;
import com.videoplatform.backend.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequestMapping("/api/v1/")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	// Get Mapping
	
	// Post Mapping (Only allow business to add movies)
	@PostMapping("/business/movie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
//		movieService.addMovie(movie);
		return ResponseEntity.ok().build();
	}
	
	
	// Put Mapping
	
	// Delete Mapping (Only allow business to delete)
	
	
}
