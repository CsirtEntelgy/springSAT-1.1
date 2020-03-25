package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ImplRepository;
import com.example.demo.model.Entity;

@RestController
public class Controller {
	
   @Autowired
	private ImplRepository implRepo;
	
	public Controller(ImplRepository implR) {
	 this.implRepo=implR;	
	} 
	
	@GetMapping("/entity")
	public Map<String,Entity> findAll(){
		return implRepo.findAll();
	}
	
	
	@GetMapping("/entity/{id}")
	public Entity findById(@PathVariable String id) {
		return implRepo.findById(id);
	}
   
	@PostMapping("/save2")
	public void CrearEntity(@RequestBody Entity entity) {
		implRepo.save(entity);
	}
	
	@DeleteMapping("{id}")
	public void Delete (@PathVariable String id) {
		implRepo.delete(id);
	}
}
