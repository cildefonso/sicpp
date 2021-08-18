package com.api.sicpp.retorno;

import java.util.ArrayList;
import java.util.List;

import com.api.sicpp.enums.RespostaEnum;

/**
 * Objetivo da classe é fazer o retorno das informações através de lista.
 * @author Carlos Ildefonso
 *
 */
public class RetornoLista<T> extends Retorno {

	private static final long serialVersionUID = 3941120681473678167L;

	private List<T> data = new ArrayList<T>();

	/**
	 * 
	 * @param resposta
	 * @param data
	 */
	public RetornoLista(RespostaEnum resposta, List<T> data) {
		super(resposta);		
		this.data = data;
	}

	/**
	 * 
	 * @param resposta
	 */
	public RetornoLista(RespostaEnum resposta) {
		super(resposta);
	}

	/**
	 * 
	 * @return
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(List<T> data) {
		this.data = data;
	}
}