package com.example.demo;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface DaoPersonas extends Repository<Persona,Integer> {
	
 List<Persona>findAll();
// Persona findOne(int id);
 Persona save(Persona p);
 void delete(Persona p);
 
}
