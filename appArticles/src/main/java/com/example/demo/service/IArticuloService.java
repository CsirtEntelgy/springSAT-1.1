package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Items;

public interface IArticuloService {
	
	public List<Items> encuentraTodos();
	
	public Items encuentraID(Long id, Integer cantidad); 
	
	public String desdeFeignStr();
	
	

}
