package com.example.demo;

import java.util.List;

public interface IPersonaService {
	
	List<Persona>listar();
	Persona listarPorID(int id);
	Persona add(Persona p);
	Persona edit(Persona p);
	Persona delete(Persona p);

}
