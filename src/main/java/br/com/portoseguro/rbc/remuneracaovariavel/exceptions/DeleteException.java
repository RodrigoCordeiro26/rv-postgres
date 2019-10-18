package br.com.portoseguro.rbc.remuneracaovariavel.exceptions;


/**
 * 
 * @author rodrigo
 * 
 * Classe de exceção para cenários em que a exclusão não funcione.
 * 
 * */
public class DeleteException extends RemuneracaoVariavelException{
	public DeleteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -3521462897402361711L;

}
