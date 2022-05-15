package com.company.inventory.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaResponseRest extends ResponseRest{
	
	private CategoriaResponse categoriaResponse = new CategoriaResponse();

	public CategoriaResponse getCategoriaResponse() {
		return categoriaResponse;
	}

	public void setCategoriaResponse(CategoriaResponse categoriaResponse) {
		this.categoriaResponse = categoriaResponse;
	}
}
