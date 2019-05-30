package com.dependent.coder.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dependent.coder.model.Domain;
import com.dependent.coder.repo.DomainRepository;

@RestController
public class DomainController {
	@Autowired
	private DomainRepository domainRepo;
	
	@GetMapping("/domain/list")
	public List<Domain> getAllDomains(){
		return domainRepo.findAll();
	}
	
	@PostMapping("/domain")
	public Domain createDomain(@RequestBody Domain domain) {
		domainRepo.save(domain);
		return domain;
	}
}
