package com.micro.mtthunderapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.micro.mtthunderapi.model.Beer;

@RepositoryRestResource
public interface BeerRepository extends JpaRepository<Beer, Long> {

}
