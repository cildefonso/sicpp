package com.api.sicpp.exception;

import org.springframework.http.HttpStatus;

import com.api.sicpp.enums.RespostaEnum;

/**
 * Objetivo da classe é fazer o tratamento dos erros da aplicação
 * @author Carlos Ildefonso
 *
 */
@lombok.Getter
@lombok.Setter
public class GeneralException extends Exception {

	private static final long serialVersionUID = -717552789195978113L;

	public static final GeneralException RESPONSE_CODE_NO_ENTITY_FOUND = new GeneralException(RespostaEnum.ENTIDADE_NAO_ENCONTRADA, HttpStatus.NOT_FOUND);
	public static final GeneralException RESPONSE_CODE_ALREADY_EXISTS = new GeneralException(RespostaEnum.REGISTRO_EXISTENTE, HttpStatus.UNPROCESSABLE_ENTITY);
	public static final GeneralException RESPONSE_CODE_ERROR_ID_FOUND = new GeneralException(RespostaEnum.ID_INFORMADO, HttpStatus.UNPROCESSABLE_ENTITY);
	public static final GeneralException RESPONSE_CODE_ERROR_NAME_NOT_FOUND = new GeneralException(RespostaEnum.NOME_NAO_INFORMADO, HttpStatus.UNPROCESSABLE_ENTITY);
	public static final GeneralException RESPONSE_CODE_ERROR_FAIL = new GeneralException(RespostaEnum.FALHA_GERAL, HttpStatus.INTERNAL_SERVER_ERROR);
	public static final GeneralException RESPONSE_CODE_ERROR_FILEIO_FAIL = new GeneralException(RespostaEnum.FALHA_BD, HttpStatus.INTERNAL_SERVER_ERROR);
	public static final GeneralException RESPONSE_CODE_ERROR_TOKEN_USUARIO = new GeneralException(RespostaEnum.FALHA_TOKEN_USUARIO, HttpStatus.INTERNAL_SERVER_ERROR);

	private final transient String mensagem;
	private final transient int codigoRetorno;
	private final transient int codigoStatus;
	private transient Exception erro;

	/**
	 * 
	 * @param erroEnum
	 * @param status
	 */
	public GeneralException(RespostaEnum resposta, HttpStatus status) {
		super();
		this.codigoRetorno = resposta.getCodigoRetorno();
		this.codigoStatus = status.value();
		this.mensagem = resposta.getMensagem();
	}

	/**
	 * 
	 * @param erroEnum
	 * @param status
	 * @param erro
	 */
	public GeneralException(RespostaEnum resposta, HttpStatus status, Exception erro) {
		super();
		this.codigoRetorno = resposta.getCodigoRetorno();
		this.codigoStatus = status.value();
		this.mensagem = resposta.getMensagem();
		this.erro = erro;
	}

	/**
	 * 
	 * @param general
	 */
	public GeneralException(GeneralException general) {
		super();
		this.codigoRetorno = general.getCodigoRetorno();
		this.codigoStatus = general.getCodigoStatus();
		this.mensagem = general.getMensagem();
	}

	/**
	 * 
	 * @param general
	 * @param erro
	 */
	public GeneralException(GeneralException general, Exception erro) {
		super();
		this.codigoRetorno = general.getCodigoRetorno();
		this.codigoStatus = general.getCodigoStatus();
		this.mensagem = general.getMensagem();
		this.erro = erro;
	}
}