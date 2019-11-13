package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ProductoDAO;
import com.example.demo.entity.Producto;

@Service
public class IProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoDAO interfazDAOcrud;
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findTodo() {
		return (List<Producto>) interfazDAOcrud.findAll();
	}

	@Override
	@Transactional(readOnly=true) 
	public Producto encuentraPorID(Long id) {
		return interfazDAOcrud.findById(id).orElse(null);
	}

}
