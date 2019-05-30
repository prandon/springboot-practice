package com.dependent.coder.springwithmongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.dependent.coder.model.Domain;
import com.dependent.coder.repo.DomainRepository;

@SpringBootApplication
@ComponentScan(basePackages="com.dependent.coder")
@EntityScan("com.dependent.coder")
@EnableMongoRepositories("com.dependent.coder.repo")
public class SpringwithmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwithmongoApplication.class, args);
	}
	
//	@Bean
//    CommandLineRunner init(DomainRepository domainRepository) {
//
//        return args -> {
//
////            Domain obj = domainRepository.findOne(7);
////            System.out.println(obj);
//
//            Domain obj2 = domainRepository.findFirstByDomain("mkyong.com");
//            System.out.println(obj2);
//
//            int n = domainRepository.updateDomain("mkyong.com", true);
//            System.out.println("Number of records updated : " + n);
//
//        };
//
//    }


}
