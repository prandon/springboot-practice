package com.dependent.coder.hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dependent.coder.model.Greeting;

@RestController
public class GreetingsController {
	private final static String template = "Hello %s!!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting getGreetings(@RequestParam(value="name", defaultValue="World")String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
