package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.clients.IProductoClienteRest;
import com.example.demo.models.Items;

@Service("servicioFeign")
public class ItemServiceFeign implements IArticuloService {

	@Autowired
	private IProductoClienteRest clienteFEIGN;
	
	public List<Items> encuentraTodos() {
		return clienteFEIGN.listarFeignClient().stream()
				.map(p -> new Items(p,1)).collect(Collectors.toList()); 
	}

	
	public Items encuentraID(Long id, Integer cantidad) {
		return new Items(clienteFEIGN.porIdFeignClient(id), cantidad);
	}
	
	public String desdeFeignStr() {
		return clienteFEIGN.desdeFeignString().concat("Segunda cadena");
	}


}
