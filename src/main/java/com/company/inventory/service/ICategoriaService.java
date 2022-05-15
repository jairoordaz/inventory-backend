package com.company.inventory.service;

import org.springframework.http.ResponseEntity;

import com.company.inventory.model.Categoria;
import com.company.inventory.response.CategoriaResponseRest;

public interface ICategoriaService {
	
	public ResponseEntity<CategoriaResponseRest> search();
	
	public ResponseEntity<CategoriaResponseRest> searchById(Long id);
	
	public ResponseEntity<CategoriaResponseRest> saveCategoria(Categoria categoria);
	
	public ResponseEntity<CategoriaResponseRest> updateCategoria(Categoria categoria,Long id);
}
