package com.example.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Items;
import com.example.demo.models.Producto;

@Service
public class ArticuloServiceImpl implements IArticuloService {

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Items> encuentraTodos() {
      List<Producto> losProductos = Arrays.asList( clienteRest.getForObject("http://localhost:8001/listar",  Producto[].class));
		return losProductos.stream().map(p->new Items(p , 1 ) ).collect(Collectors.toList());
	}

	@Override
	public Items encuentraID(Long id, Integer cantidad) {
       Map<String , String> pathVariables = new HashMap<String,String>();
       pathVariables.put("id", id.toString());
       Producto productoClient = clienteRest.getForObject("http://localhost:8001/ver/{id}",Producto.class, pathVariables);
		return new Items(productoClient,cantidad);
	}

}
