package com.company.inventory.service;

import java.util.List;

import com.company.inventory.model.Categoria;
import com.company.inventory.model.Respuesta;

public interface ICategoriaService {
	
	public Respuesta<Categoria> searchById(Long id);
	
	public Respuesta<Categoria> saveCategoria(Categoria categoria);
	
	public Respuesta<Categoria> updateCategoria(Categoria categoria,Long id);
	
	public Respuesta<List<Categoria>> buscar();
}
