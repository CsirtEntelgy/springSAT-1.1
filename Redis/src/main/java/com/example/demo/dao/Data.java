package com.example.demo.dao;

import java.util.Map;

import com.example.demo.model.Entity;

public interface Data {
	
	Map<String,Entity> findAll();
	Entity findById(String id);
	void save(Entity entity);
	void delete(String id);
}
