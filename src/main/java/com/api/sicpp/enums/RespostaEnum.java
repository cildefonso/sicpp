package com.api.sicpp.enums;

public enum RespostaEnum {

	SUCESSO_OPERACAO(200, "Operação realizada com sucesso."),
	FALHA_GERAL(300, "Falha geral de processamento."), 
	FALHA_BD(301, "Falha ao ler/gravar dados em disco(IO)."),
	ENTIDADE_NAO_ENCONTRADA(350, "Não foi possível encontrar o registro através do indentificador informado."),
	LISTA_VAZIA(351, "Registros não encontrados."), 
	REGISTRO_EXISTENTE(352, "Já existe registro com os dados informados."),
	ID_INFORMADO(353, "Registro com o id definido de maneira incorreta"),
	NOME_NAO_INFORMADO(354, "Registro com o atributo nome não informado."),
	DADOS_GRAVADOS(355, "Dados gravados com sucesso."),
	DADOS_ALTERADOS(356, "Alteração realizada com sucesso."),
	DADOS_EXCLUIDOS(357, "Exclusão realizada com sucesso."),
	FALHA_TOKEN_USUARIO(358, "Não foi possível extrair as informações do usuário a partir do token informado.");

	private final int codigoRetorno;
	private final String mensagem;

	RespostaEnum(final int codigoRetorno, final String mensagem) {
		this.codigoRetorno = codigoRetorno;
		this.mensagem = mensagem;
	}

	public int getCodigoRetorno() {
		return codigoRetorno;
	}

	public String getMensagem() {
		return mensagem;
	}
}