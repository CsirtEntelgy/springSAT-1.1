package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Producto;
import com.example.demo.service.IProductoService;

@RestController
public class ControllerProducto {

	@Autowired IProductoService interfazProducto;
	
	@GetMapping ("/listar")
	public List<Producto> listar(){
		return interfazProducto.findTodo();
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		return interfazProducto.encuentraPorID(id);
	}
	
}
