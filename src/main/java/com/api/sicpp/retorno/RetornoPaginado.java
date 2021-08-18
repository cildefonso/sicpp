package com.api.sicpp.retorno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.api.sicpp.enums.RespostaEnum;

/**
 * Objetivo da classe é fazer o retorno das informações
 * @author Carlos Ildefonso
 *
 */
public class RetornoPaginado<T> extends Retorno implements Serializable {
 
	private static final long serialVersionUID = 8925538460408952358L;

	private Long total;
	
	private Integer pagina;
	
	private Integer qtdPorPagina;
	
	private List<T> data = new ArrayList<T>();
	
	/**
	 * 
	 * @param resposta
	 * @param data
	 * @param total
	 * @param pagina
	 * @param qtdPorPagina
	 */
	public RetornoPaginado(RespostaEnum resposta, List<T> data, Long total, Integer pagina, Integer qtdPorPagina) {
		super(resposta);
		this.data = data;
		this.total = total;
		this.pagina = pagina;
		this.qtdPorPagina = qtdPorPagina;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Integer getQtdPorPagina() {
		return qtdPorPagina;
	}

	public void setQtdPorPagina(Integer qtdPorPagina) {
		this.qtdPorPagina = qtdPorPagina; 
	}	
}