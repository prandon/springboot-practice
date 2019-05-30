package com.security.SecurityExample.auth.service;

import com.security.SecurityExample.auth.model.User;

public interface UserService {
	public void save(User user);
	
	public User findByUsername(String username);
}
