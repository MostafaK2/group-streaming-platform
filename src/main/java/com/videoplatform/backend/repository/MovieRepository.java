package com.videoplatform.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.videoplatform.backend.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String>{

}
