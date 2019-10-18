package br.com.portoseguro.rbc.remuneracaovariavel.exceptions;

/**
 * @author rodrigo
 * 
 * Classe básica das exceções capturadas no sistema.
 * 
 * */
public class RemuneracaoVariavelException extends Exception{
	private static final long serialVersionUID = 1L;

	private final Error erro;
	
	public RemuneracaoVariavelException(final String mensagem, final Throwable causa) {
		super(mensagem, causa);
		erro = new Error(mensagem, causa.getStackTrace());
	}

	public RemuneracaoVariavelException(final String mensagem) {
		this(mensagem, mensagem);
	}

	public RemuneracaoVariavelException(final String mensagem, final Object detalhe) {
		super(mensagem);
		erro = new Error(mensagem, detalhe);
	}

	public Error getErro() {
		return erro;
	}

	@Override
	public String toString() {
		return String.format("UltronException [erro=%s]", erro);
	}
}