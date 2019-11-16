package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Items;
import com.example.demo.service.IArticuloService;

@RestController
public class ItemsController {
	
	@Autowired  IArticuloService  articuloService;
	
	@GetMapping("/entra")
	public String rf() {
		return "entro";
	}
	
	@GetMapping("/listar")
	public List<Items> listar(){
		return articuloService.encuentraTodos();
	}
	
	@GetMapping("/verID/{id}/cantidad/{cantidad} ")
	public Items detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return articuloService.encuentraID(id, cantidad);
	}
	

}
