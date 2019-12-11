package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPersonaServiceImpl  implements IPersonaService{

	@Autowired 
	private DaoPersonas repository;
	
	@Override
	public List<Persona> listar() {
		
		return repository.findAll();
	}

	@Override
	public Persona listarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona add(Persona p) {		
		return repository.save(p);
	}

	@Override
	public Persona edit(Persona p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona delete(Persona p) {
		// TODO Auto-generated method stub
		return null;
	}

}
