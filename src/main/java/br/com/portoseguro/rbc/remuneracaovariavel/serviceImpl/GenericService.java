package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.portoseguro.rbc.remuneracaovariavel.exceptions.NaoEncontradoException;

/**
 * @author Rodrigo Cordeiro
 * 
 * Classe de serviço genérica, responsável pro realizar CRUDS básicos
 * do sistema.
 * 
 * */

public class GenericService<T> {
	
	PagingAndSortingRepository<T, Long> repo;

	public GenericService(PagingAndSortingRepository<T, Long> repo) {
		this.repo = repo;
	}

	public List<T> findAll() {
		return (List<T>) repo.findAll();
	}

	public T findById(Long id) throws NaoEncontradoException {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public T save(T entity) {
		return repo.save(entity);
	}
	
	public List<T> saveAll(List<T> entities) {
		return (List<T>) repo.saveAll(entities);
	}

	public T update(T entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	public boolean delete(Long id) throws NaoEncontradoException {
		// TODO Auto-generated method stub
		Optional<T> entity = repo.findById(id);
			T obj = entity.orElseThrow(()-> new NaoEncontradoException("Entidade Não encontrada."));
			
			try {
				repo.delete(obj);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
			
		
	}
	
	public boolean deleteAll(List<T> objOLD) {
		try {
			deleteAll(objOLD);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}