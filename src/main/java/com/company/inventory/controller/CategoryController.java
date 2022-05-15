package com.company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.model.Categoria;
import com.company.inventory.response.CategoriaResponseRest;
import com.company.inventory.service.ICategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoryController {
	
	@Autowired
	private ICategoriaService service;
	
	@GetMapping(value = "/listado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaResponseRest> searchCategories(){
		return service.search();
	}
	
	@GetMapping(value="/listadoId/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaResponseRest> searchById(@PathVariable Long id){
		return service.searchById(id);
	}
	
	@PostMapping(value="/guardar",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaResponseRest> saveCategoria(@RequestBody Categoria categoria){
		return service.saveCategoria(categoria);
	}
	
	@PutMapping(value="/actualizar/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaResponseRest> updateCategoria(@RequestBody Categoria categoria,@PathVariable Long id){
		return service.updateCategoria(categoria, id);
	}
	
	

}
