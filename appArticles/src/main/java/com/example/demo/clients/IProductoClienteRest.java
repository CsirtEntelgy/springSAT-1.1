package com.example.demo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Producto;



@FeignClient(name= "servicio-productos")
public interface IProductoClienteRest {
	
	@GetMapping ("/listar")
	public List<Producto> listarFeignClient();
	
	@GetMapping("/ver/{id}")
	public Producto  porIdFeignClient(@PathVariable Long id);
	
	//ejemplo muestra
	@GetMapping("/entra")
	public String desdeFeignString();

}
