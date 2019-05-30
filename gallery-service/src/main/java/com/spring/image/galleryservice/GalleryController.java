package com.spring.image.galleryservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class GalleryController {

	@Autowired
	private Environment env;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String getHome() {
		return "Hello from gallery-service running at port: " + env.getProperty("local.server.port");
	}

	@GetMapping("/{id}")
	public Gallery getGallary(@PathVariable final int id) {
		Gallery gallery = new Gallery();
		gallery.setId(id);

		List<Object> list = restTemplate.getForObject("http://image-service/images/", List.class);
		gallery.setImages(list);

		return gallery;
	}

	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}

}
