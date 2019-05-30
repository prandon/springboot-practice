package com.micro.mtthunderapi.controller;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.mtthunderapi.model.Beer;
import com.micro.mtthunderapi.repo.BeerRepository;

@RestController
public class BeerController {
	
	private BeerRepository repository;
	
	public BeerController(BeerRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/goodBeers")
	public Collection<Beer> goodBeers(){
		return repository.findAll().stream().filter(this::isGreat).collect(Collectors.toList());
	}
	
	@GetMapping("/beers")
	public Collection<Beer> getBeers(){
		return repository.findAll();
	}
	
	private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }

}
