package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Producto;

public interface IProductoService {
	public List<Producto> findTodo();
	public Producto encuentraPorID(Long id);

}
