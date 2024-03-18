package com.videoplatform.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videoplatform.backend.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
}
