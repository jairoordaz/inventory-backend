package com.company.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.inventory.dao.ICategoriaDao;
import com.company.inventory.model.Categoria;
import com.company.inventory.response.CategoriaResponseRest;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired 
	private ICategoriaDao dao;

	@Transactional(readOnly = true)
	public ResponseEntity<CategoriaResponseRest> search() {
		CategoriaResponseRest response = new CategoriaResponseRest();
		try {
			List<Categoria> categoria = (List<Categoria>) dao.findAll();
			response.getCategoriaResponse().setCategoria(categoria);
			response.setMetadata("Respuesta Ok", "00", "Respuesta Existosa");
		}catch(Exception e) {
			response.setMetadata("Respuesta Invalida", "-1", "Error al consultar" + e.getMessage());
			return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoriaResponseRest> searchById(Long id) {
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> list = new ArrayList<>();
		try {
			Optional<Categoria> categoria = dao.findById(id);
			if(categoria.isPresent()) {
				list.add(categoria.get());
				response.getCategoriaResponse().setCategoria(list);
				response.setMetadata("Respuesta Ok", "00", "Categoria encontrada");
			}else {
				response.setMetadata("Respuesta Invalida", "-1", "Categoria no encontrada");
				return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			response.setMetadata("Respuesta Invalida", "-1", "Error al consultar por Id" + e.getMessage());
			return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaResponseRest> saveCategoria(Categoria categoria) {
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> list = new ArrayList<>();
		try {
			Categoria categoriaSave = dao.save(categoria);
			if(categoriaSave != null) {
				list.add(categoriaSave);
				response.getCategoriaResponse().setCategoria(list);
				response.setMetadata("Respuesta Ok", "00", "Categoria guardada exitosamente");
			}else {
				response.setMetadata("Respuesta Invalida", "-1", "Categoria no guardada");
				return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.BAD_REQUEST);
			}
			
		}catch(Exception e) {
			response.setMetadata("Respuesta Invalida", "-1", "Error al guardar categoria" + e.getMessage());
			return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaResponseRest> updateCategoria(Categoria categoria,Long id) {
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> list = new ArrayList<>();
		try {
			Optional<Categoria> categoriaSearch = dao.findById(id);
			if(categoriaSearch.isPresent()) {
				categoriaSearch.get().setNombre(categoria.getNombre());
				categoriaSearch.get().setDescripcion(categoria.getDescripcion());
				Categoria categoriaToUpdate = dao.save(categoriaSearch.get());
				if(categoriaToUpdate != null) {
					list.add(categoriaToUpdate);
					response.getCategoriaResponse().setCategoria(list);
					response.setMetadata("Respuesta Ok", "00", "Categoria actualizada exitosamente");
				}else {
					response.setMetadata("Respuesta Invalida", "-1", "Error al actualizar categoria");
					return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.BAD_REQUEST);
				}
			}else {
				response.setMetadata("Respuesta Invalida", "-1", "Categoria no encontrada");
				return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.NOT_FOUND);
			}
			
		}catch(Exception e) {
			response.setMetadata("Respuesta Invalida", "-1", "Error al actualizar categoria" + e.getMessage());
			return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.OK);
	}

}