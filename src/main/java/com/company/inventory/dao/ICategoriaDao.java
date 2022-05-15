package com.company.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.inventory.model.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria,Long>{
	
	
}