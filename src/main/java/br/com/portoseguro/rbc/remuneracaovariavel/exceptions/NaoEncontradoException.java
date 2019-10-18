package br.com.portoseguro.rbc.remuneracaovariavel.exceptions;

import org.springframework.http.HttpStatus;
/**
 * 
 * @author rodrigo
 * 
 * Classe de Exceção para cenários com status HTTP 404.
 * 
 * */
public class NaoEncontradoException extends RemuneracaoVariavelException {
	private static final long serialVersionUID = 1L;


	public NaoEncontradoException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NaoEncontradoException(final String message) {
		super(message);
	}

	public NaoEncontradoException(final Object detalhe) {
		super(HttpStatus.NOT_FOUND.toString(), detalhe);
	}

	public NaoEncontradoException(final Throwable cause) {
		super(HttpStatus.NOT_FOUND.toString(), cause);
	}

	public NaoEncontradoException(final String mensagem, final Object detalhe) {
		super(mensagem, detalhe);
	}

}