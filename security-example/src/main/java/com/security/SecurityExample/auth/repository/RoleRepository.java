package com.security.SecurityExample.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.SecurityExample.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
