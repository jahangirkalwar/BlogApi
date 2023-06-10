package com.blogrestapi.blogrestapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CatalogController {
	
	@GetMapping("/catalog")
	public String getCatalog() {
		
//		String courses= new RestTemplate().getForObject("http://localhost:8088/courses",String.class);
//		return "your courses :"+ courses;
////		
//		String courses="";
//		String courseAppURL="http://localhost:8088/courses";
//		RestTemplate restTemplate = new RestTemplate();
//		courses=restTemplate.getForObject(courseAppURL, String.class);
//		return "your courses are : "+courses;
		return "your courses are : ";
	}
	
	@GetMapping("/error")
	public String errorMessage() {
		return "some thing went wrong !";
	}

}
