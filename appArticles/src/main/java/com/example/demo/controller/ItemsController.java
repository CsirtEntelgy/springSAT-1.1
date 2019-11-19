package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Items;
import com.example.demo.service.IArticuloService;

@RestController
public class ItemsController {
	
	@Autowired  
	@Qualifier("servicioFeign")
	private IArticuloService  articuloService;
	
	@GetMapping("/entra")
	public String rf() {
		return articuloService.desdeFeignStr();
	}
	
	@GetMapping("/listar")
	public List<Items> listar(){
		return articuloService.encuentraTodos();
	}
	
	
	@GetMapping("/avanzada/{id}/cantidad/{cantidad}")
	public Items detalles(@PathVariable Long id, @PathVariable Integer cantidad) {
		return articuloService.encuentraID(id, cantidad);
	}
	
	

}
