package com.security.SecurityExample.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.SecurityExample.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
