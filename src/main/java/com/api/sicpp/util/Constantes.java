package com.api.sicpp.util;

/**
 * Objetivo é cebtralizar e padronizar todas as constantes da aplicação.
 * @author Carlos Ildefonso
 */
public final class Constantes {

	public static final String ERRO_CODIGO_NAO_AUTORIZADO = "Não autorizado o código de acesso ";
	public static final String INFO_HEALTH = "A funcionalidade está em execução.";
	public static final String INFO_CHAMANDO_METODO_CREATE = "Chamando o metodo: create";
	public static final String INFO_CHAMANDO_METODO_DELETE = "Chamando o metodo: delete ";
	public static final String INFO_CHAMANDO_METODO_READ = "Chamando o metodo: read ";
	public static final String INFO_CHAMANDO_METODO_LIST_ALL = "Chamando o metodo: listAll";
	public static final String INFO_CHAMANDO_METODO_LIST_PAG = "Chamando o metodo: listPag";
	public static final String INFO_CHAMANDO_METODO_UPDATE = "Chamando o metodo: update ";
	public static final String INFO_CHAMANDO_METODO_COUNT = "Chamando o metodo: count";
	
	public static final String INFO_EXCLUSAO_SUCESSO = "Exclusão feita com sucesso.";
	public static final String INFO_INCLUSAO_SUCESSO = "Inclusão feita com sucesso.";
	public static final String INFO_LEITURA_SUCESSO = "Leitura feita com sucesso.";
	public static final String INFO_LEITURA_ID_SUCESSO = "Leitura por \"id\" feita com sucesso.";
	public static final String INFO_UPDATE_SUCESSO = "Atualização feita com sucesso.";
	public static final String INFO_MBEAN_REGISTRADO = "MBean registered: ";
	public static final String INFO_ALREADY_EXISTS = "Já existe registro com os dados informados.";
	public static final String INFO_NOT_ALREADY_EXISTS = "Registro informado não foi encontrado na base de dados..";
	
	public static final Long ZERO_L = 0L;
	public static final Integer ZERO = 0;
	
	private Constantes() {}	
}
