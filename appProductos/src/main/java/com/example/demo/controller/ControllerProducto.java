package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Producto;
import com.example.demo.service.IProductoService;

@RestController
public class ControllerProducto {

	@Autowired IProductoService interfazProducto;
	@Autowired private Environment amb;
	
	@GetMapping ("/listar")
	public List<Producto> listar(){
		//El controlador solo incluye hasta findtodo() , el metodo stream es para cargar puerto.
		return  interfazProducto.findTodo().stream().map(productoMap ->{
			productoMap.setPuerto(Integer.parseInt(amb.getProperty("local.server.port"))  );
			return productoMap;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto proId=interfazProducto.encuentraPorID(id);
		proId.setPuerto(Integer.parseInt(amb.getProperty("local.server.port")) );
		return proId;
	}
	
	
	@GetMapping("/entra")
	public String rf() {
		return "entro";
	}
	
}
