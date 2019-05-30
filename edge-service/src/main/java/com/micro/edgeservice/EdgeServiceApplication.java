package com.micro.edgeservice;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.Data;

@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class EdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeServiceApplication.class, args);
	}

}

@Data
class Beer{
	private String name;
}

@FeignClient("beer-catalog-service")
interface BeerClient{
	
	@GetMapping("/beers")
	Collection<Beer> readBeers();
}

@RestController
class GoodBeerApiAdapterController{
	private final BeerClient beerClient;
	
	public GoodBeerApiAdapterController(BeerClient beerClient) {
		this.beerClient = beerClient;
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	@GetMapping("/good-beers")
	public Collection<Beer> getGoodBeer(){
		return beerClient.readBeers();
	}
	
	public Collection<Beer> fallback(){
		return new ArrayList();
	}
	
	private boolean isGreat(Beer beer) {
		return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
	}
}	