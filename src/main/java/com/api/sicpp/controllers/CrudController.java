package com.api.sicpp.controllers;

/**
 * Interface para padronização de operações de CRUD.
 * 
 * @author Spread
 *
 * @param <E> Entidade de resuisição
 * @param <R> Response
 */
public interface CrudController<E, R> {

	R listAll();

	R listPag(int pagina);

	R listPag(int pagina, int qtdPorPagina);

	R findById(Long id);

	R create(E request);

	R update(E request);

	R delete(Long id);

}
