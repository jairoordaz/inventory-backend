package com.company.inventory.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.inventory.dao.ICategoriaDao;
import com.company.inventory.model.Categoria;
import com.company.inventory.model.Respuesta;
import com.company.inventory.util.Constantes;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired 
	private ICategoriaDao dao;
	
	public Respuesta<List<Categoria>> buscar(){
		Respuesta<List<Categoria>> categoria = new Respuesta<>();
		try {
			categoria.setResultset((List<Categoria>) dao.findAll());
			categoria.setStatuscode(Constantes.REQUEST_EXITOSO);
			categoria.setStatus(Constantes.HTTP_STATUS_200);
		}catch(Exception e) {
			log.error(e);
			categoria.setStatuscode(Constantes.REQUEST_FALLIDO);
		}
		return categoria;
	}

	@Override
	@Transactional(readOnly = true)
	public Respuesta<Categoria> searchById(Long id) {
		Respuesta<Categoria> response = new Respuesta<>();
		try {
			Optional<Categoria> categoria = dao.findById(id);
			if(categoria.isPresent()) {
				response.setResultset(categoria.get());
				response.setStatuscode(Constantes.REQUEST_EXITOSO);
				response.setStatus(Constantes.HTTP_STATUS_200);
			}else {
				response.setStatuscode(Constantes.REQUEST_FALLIDO);
			}
		}catch(Exception e) {
			response.setStatuscode(Constantes.REQUEST_FALLIDO);
		}
		return response;
	}

	@Override
	@Transactional
	public Respuesta<Categoria> saveCategoria(Categoria categoria) {
		Respuesta<Categoria> response = new Respuesta<>();
		try {
			Categoria categoriaSave = dao.save(categoria);
			if(categoriaSave != null) {
				response.setResultset(categoria);
				response.setStatuscode(Constantes.REQUEST_EXITOSO);
				response.setStatus(Constantes.HTTP_STATUS_200);
			}else {
				response.setStatuscode(Constantes.REQUEST_EXITOSO);
			}
			
		}catch(Exception e) {
			log.error(e);
			response.setStatuscode(Constantes.REQUEST_EXITOSO);
		}
		
		return response;
	}

	@Override
	@Transactional
	public Respuesta<Categoria> updateCategoria(Categoria categoria,Long id) {
		Respuesta<Categoria> response = new Respuesta<>();
		try {
			Optional<Categoria> categoriaSearch = dao.findById(id);
			if(categoriaSearch.isPresent()) {
				categoriaSearch.get().setNombre(categoria.getNombre());
				categoriaSearch.get().setDescripcion(categoria.getDescripcion());
				Categoria categoriaToUpdate = dao.save(categoriaSearch.get());
				if(categoriaToUpdate != null) {
					response.setResultset(categoriaToUpdate);
					response.setStatuscode(Constantes.REQUEST_EXITOSO);
					response.setStatus(Constantes.HTTP_STATUS_200);
				}else {
					response.setStatuscode(Constantes.REQUEST_FALLIDO);
				}
			}else {
				response.setStatuscode(Constantes.REQUEST_FALLIDO);
			}
			
		}catch(Exception e) {
			log.error(e);
			response.setStatuscode(Constantes.REQUEST_FALLIDO);
		}
		return response;
	}
	
	

}