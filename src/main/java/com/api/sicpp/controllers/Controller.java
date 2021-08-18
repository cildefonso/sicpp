package com.api.sicpp.controllers;

import java.util.List;

import javax.ws.rs.core.Application;

//import org.eclipse.microprofile.jwt.JsonWebToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.api.sicpp.enums.ArquivoEnum;
import com.api.sicpp.enums.RespostaEnum;
import com.api.sicpp.exception.GeneralException;
import com.api.sicpp.retorno.Retorno;
import com.api.sicpp.retorno.RetornoLista;
import com.api.sicpp.retorno.RetornoPaginado;
import com.api.sicpp.retorno.RetornoUnico;

/**
 * 
 * @author Spread
 *
 * @param <E> Entidade de resuisição
 * @param <R> Response
 */
public abstract class Controller<T> extends Application {
	@Value("${paginacao.qtd_por_pagina}")
	protected int qtdPorPagina;
	
	//@Inject
	//protected transient JsonWebToken accessToken;
	
	private static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
	private static final String ACCESS_CONTROL_ALLOW_CREDENTIALS_VALUE = "true";
	
	private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
	private static final String ACCESS_CONTROL_ALLOW_HEADERS_VALUE = "Origin, X-Request-Width, Content-Type, Accept, Authorization, Accept-Encoding, Accept-Language, authCode, Connection, Host, Referer, Sec-Fetch-Dest, Sec-Fetch-Mode, Sec-Fetch-Site, User-Agent";
	
	
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN_VALUE = "*";
	
	private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
	private static final String ACCESS_CONTROL_ALLOW_METHODS_VALUE = "GET, POST, PUT, DELETE, OPTIONS";
	
	private static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
	private static final String ACCESS_CONTROL_MAX_AGE_VALUE = "1209600";
		
	
	private ResponseEntity<?> build(int status, Object obj) {
		return ResponseEntity.status(status)
				.header(ACCESS_CONTROL_ALLOW_ORIGIN, ACCESS_CONTROL_ALLOW_ORIGIN_VALUE)
				.header(ACCESS_CONTROL_ALLOW_CREDENTIALS, ACCESS_CONTROL_ALLOW_CREDENTIALS_VALUE)
				.header(ACCESS_CONTROL_ALLOW_HEADERS, ACCESS_CONTROL_ALLOW_HEADERS_VALUE)
				.header(ACCESS_CONTROL_ALLOW_METHODS, ACCESS_CONTROL_ALLOW_METHODS_VALUE)
				.header(ACCESS_CONTROL_MAX_AGE, ACCESS_CONTROL_MAX_AGE_VALUE)
				.body(obj);			
	}
	
	private ResponseEntity<?> build(HttpStatus status, Object obj) {
		return build(status.value(), obj);
	}
	
	protected ResponseEntity<?> buildOk() {
		return build(HttpStatus.OK, new Retorno(RespostaEnum.SUCESSO_OPERACAO));
	}

	
	protected ResponseEntity<?> buildOk(T data) {
		return build(HttpStatus.OK, new RetornoUnico<T>(RespostaEnum.SUCESSO_OPERACAO, data));
	}

	protected ResponseEntity<?> buildOk(List<T> data) {
		return build(HttpStatus.OK, new RetornoLista<T>(RespostaEnum.SUCESSO_OPERACAO, data));
	}
	
	protected ResponseEntity<?> buildPag(List<T> data, Long total, Integer pagina, Integer qtdPorPagina) {
		return build(HttpStatus.PARTIAL_CONTENT, new RetornoPaginado<T>(RespostaEnum.SUCESSO_OPERACAO, data, total, pagina, qtdPorPagina));
	}
	
	protected ResponseEntity<?> buildDeleted() {
		return build(HttpStatus.NO_CONTENT, RespostaEnum.DADOS_EXCLUIDOS);
	}
	
	protected ResponseEntity<?> buildCreated(T data) {
		return build(HttpStatus.CREATED, new RetornoUnico<T>(RespostaEnum.DADOS_GRAVADOS, data));
	}
	
	protected ResponseEntity<?> buildUpdated(T data) {
		return build(HttpStatus.OK, new RetornoUnico<T>(RespostaEnum.DADOS_ALTERADOS, data));
	}
	
	protected ResponseEntity<?> buildNotFound() {
		return build(HttpStatus.NOT_FOUND, new Retorno(RespostaEnum.ENTIDADE_NAO_ENCONTRADA));
	}
	
	protected ResponseEntity<?> buildEmptyList() {
		return build(HttpStatus.NOT_FOUND, new RetornoLista<T>(RespostaEnum.LISTA_VAZIA));
	}
	
	protected ResponseEntity<?> buildFail(HttpStatus status, RespostaEnum resposta) {
		return build(status, new Retorno(resposta));
	}
	
	protected ResponseEntity<?> buildFail(GeneralException e) {
		return build(e.getCodigoStatus(), new Retorno(e));
	}

	protected ResponseEntity<?> buildFail(Exception e) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, new Retorno(e));
	}
		
	protected ResponseEntity<?> buildFile(Object object, String nomeArquivo, ArquivoEnum arquivoEnum) {
		return ResponseEntity.status(HttpStatus.OK)
				.header(ACCESS_CONTROL_ALLOW_ORIGIN, ACCESS_CONTROL_ALLOW_ORIGIN_VALUE)
				.header(ACCESS_CONTROL_ALLOW_CREDENTIALS, ACCESS_CONTROL_ALLOW_CREDENTIALS_VALUE)
				.header(ACCESS_CONTROL_ALLOW_HEADERS, ACCESS_CONTROL_ALLOW_HEADERS_VALUE)
				.header("Content-Type", arquivoEnum.getMimeType())
				.header("Content-Disposition", "attachment; filename=" + nomeArquivo + arquivoEnum.getExtensao())
				.body(object);
	}

}
