package com.tts.security.example.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tts.security.example.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// METHOD NAMING ALGORITHM
	// find by username
	// findByUsername
	public User findByUsername(String username);

}
