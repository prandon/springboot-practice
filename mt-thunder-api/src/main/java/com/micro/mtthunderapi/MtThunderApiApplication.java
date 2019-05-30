package com.micro.mtthunderapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MtThunderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtThunderApiApplication.class, args);
	}

}
