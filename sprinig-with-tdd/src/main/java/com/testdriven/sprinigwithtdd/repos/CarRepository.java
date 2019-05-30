package com.testdriven.sprinigwithtdd.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.testdriven.sprinigwithtdd.model.Car;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {

}
