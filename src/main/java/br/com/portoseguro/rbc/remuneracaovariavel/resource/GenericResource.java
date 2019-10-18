package br.com.portoseguro.rbc.remuneracaovariavel.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author rodrigo
 * Classe de Resource genérica para padronizar os retornos dos métodos.
 * 
 * */
public class GenericResource{
	
	
	public <T> ResponseEntity<T> retornarSucesso(T entity){
		return new ResponseEntity<T>(entity, HttpStatus.OK);
	}
	
	public <T> ResponseEntity<T> retornarNaoEncontrado(){
		return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
		
	}
	
	public <T> ResponseEntity<T> retornarNaoAlterado(){
		return new ResponseEntity<T>(HttpStatus.NOT_MODIFIED);
	}
	
	public <T> ResponseEntity<T> retornarCriado(T entity){
		return new ResponseEntity<T>(entity, HttpStatus.CREATED);
	}
	
	public <T> ResponseEntity<T> retornarErro(T entity){
		return new ResponseEntity<T> (entity, HttpStatus.BAD_REQUEST);
	}
}