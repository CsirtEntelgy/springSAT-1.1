package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Items;
import com.example.demo.models.Producto;
import com.example.demo.service.IArticuloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemsController {
	
	@Autowired  
	@Qualifier("servicioFeign")
	private IArticuloService  articuloService;
	
	//@Value("${configuracion.texto}")
	//private String texto;
	
	@GetMapping("/entra")
	public String rf() {
		return articuloService.desdeFeignStr();
	}
	
	@GetMapping("/listar")
	public List<Items> listar(){
		return articuloService.encuentraTodos();
	}
	
	
	@HystrixCommand(fallbackMethod="metodoCircuito")
	@GetMapping("/avanzada/{id}/cantidad/{cantidad}")
	public Items detalles(@PathVariable Long id, @PathVariable Integer cantidad) {
		return articuloService.encuentraID(id, cantidad);
	}
	
	public Items metodoCircuito(Long id,  Integer cantidad) {
		Items itemCirc= new Items();
		Producto proCirc= new Producto();
		
		itemCirc.setCantidad(cantidad);
		proCirc.setId(id);
		proCirc.setNombre("RCA");
		proCirc.setPrecio(220.0);
		itemCirc.setProductosX(proCirc);
		
		return itemCirc;
	}
	
	@GetMapping("/obtener-config")
	public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String puerto ){
		Map<String,String> json=new HashMap<>();
		//json.put("texto", texto);
		json.put("puerto", puerto);
		return new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);
	}
	
	

}






