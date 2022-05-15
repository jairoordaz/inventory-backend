package com.company.inventory.response;

import java.util.List;

import com.company.inventory.model.Categoria;

import lombok.Data;


@Data
public class CategoriaResponse {
	
	private List<Categoria> categoria;

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	

	
}
