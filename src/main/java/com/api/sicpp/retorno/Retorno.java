package com.api.sicpp.retorno;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.api.sicpp.enums.RespostaEnum;
import com.api.sicpp.exception.GeneralException;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objetivo da classe é fazer o retorno das informações
 * @author Carlos Ildefonso
 *
 */
public class Retorno implements Serializable {

	private static final long serialVersionUID = 3941120681473678167L;

	@JsonProperty("mensagem")
	private String mensagem;

	@JsonProperty("codigoRetorno")
	private int codigoRetorno;
	
	/**
	 * 
	 * @param resposta
	 */
	public Retorno(RespostaEnum resposta) {
		super();
		this.mensagem = resposta.getMensagem();
		this.codigoRetorno = resposta.getCodigoRetorno();			
	}
	
	/**
	 * 
	 * @param e
	 */
	public Retorno(GeneralException e) {
		super();
		this.mensagem = e.getMensagem();
		this.codigoRetorno = e.getCodigoRetorno();
	}

	/**
	 * 
	 * @param e
	 */
	public Retorno(Exception e) {
		super();
		this.codigoRetorno = HttpStatus.INTERNAL_SERVER_ERROR.value();
		this.mensagem = e.getMessage();
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(int codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}
}