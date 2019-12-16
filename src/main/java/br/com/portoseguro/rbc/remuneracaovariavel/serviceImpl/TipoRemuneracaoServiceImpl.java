package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.TipoRemuneracaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.TipoRemuneracaoRepository;

@Service
public class TipoRemuneracaoServiceImpl extends GenericService<TipoRemuneracaoDomain>{

	@Autowired
	TipoRemuneracaoRepository repo;
	
	
	public TipoRemuneracaoServiceImpl(PagingAndSortingRepository<TipoRemuneracaoDomain, Long> repo) {
		super(repo);
	}

	
	
	
	
}
