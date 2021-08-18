package com.api.sicpp.retorno;

import com.api.sicpp.enums.RespostaEnum;

/**
 * Objetivo da classe é fazer o retorno das informações
 * @author Carlos Ildefonso
 *
 */
public class RetornoUnico<T> extends Retorno {

	private static final long serialVersionUID = 3941120681473678167L;

	private T data;

	/**
	 * 
	 * @param resposta
	 * @param data
	 */
	public RetornoUnico(RespostaEnum resposta, T data) {
		super(resposta);
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}