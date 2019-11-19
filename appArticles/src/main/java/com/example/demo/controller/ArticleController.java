package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
	
	@GetMapping("/entro")
	public String entro() {
		return "entro ex";
	}

}
