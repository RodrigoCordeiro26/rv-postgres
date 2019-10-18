package br.com.portoseguro.rbc.remuneracaovariavel.exceptions;

import java.io.Serializable;

/**
 * @author rodrigo
 * Classe responsável por representar um determinado erro.
 * 
 * */
public class Error implements Serializable{
	private static final long serialVersionUID = 737697641750503481L;

	private String mensagem;
	private transient Object detalhe;

	public Error() {
		this(null, null);
	}

	public Error(final String mensagem, final Object detalhe) {
		super();
		this.mensagem = mensagem;
		this.detalhe = detalhe;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(final String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(final Object detalhe) {
		this.detalhe = detalhe;
	}

	@Override
	public String toString() {
		return String.format("UltronErro [mensagem=%s, detalhe=%s]", mensagem, detalhe);
	}
}