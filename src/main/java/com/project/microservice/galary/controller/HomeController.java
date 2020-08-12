package com.project.microservice.galary.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.microservice.galary.entity.Galary;
import com.project.microservice.galary.modal.Image;

@RestController
@RequestMapping(path = { "/" })
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Environment env;

	@GetMapping
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}

	@GetMapping(path = { "/{id}" })
	public Galary getGalary(@PathVariable Integer id) {
		Galary galary = new Galary();
		galary.setId(id);
		URI url = URI.create("http://image-service/images/");
		@SuppressWarnings("unchecked")
		List<Image> images = restTemplate.getForObject(url, List.class);
		galary.setImages(images);

		return galary;
	}

	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
}
