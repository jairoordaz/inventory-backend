package com.company.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.model.Categoria;
import com.company.inventory.model.Respuesta;
import com.company.inventory.service.ICategoriaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/categorias")
public class CategoryController {
	
	@Autowired
	private ICategoriaService service;
	
	@GetMapping(value="/listado",produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta<List<Categoria>> listarCategorias(){
		return service.buscar();
	}
	
	@GetMapping(value="/listadoId/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta<Categoria> searchById(@PathVariable Long id){
		return service.searchById(id);
	}
	
	@PostMapping(value="/guardar",produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta<Categoria> saveCategoria(@RequestBody Categoria categoria){
		return service.saveCategoria(categoria);
	}
	
	@PutMapping(value="/actualizar/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta<Categoria> updateCategoria(@RequestBody Categoria categoria,@PathVariable Long id){
		return service.updateCategoria(categoria, id);
	}
	
	@DeleteMapping(value="/borrar/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta<Categoria> borrar(@PathVariable Long id){
		return service.borrar(id);
	}
	
	

}
