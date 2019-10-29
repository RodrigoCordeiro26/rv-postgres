package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.CadastroSegmentoRVRepository;

@Service
public class CadastroSegmentoRVServiceImpl extends GenericService<CadastroSegmentoRVDomain>{
	@Autowired
	CadastroSegmentoRVRepository repo;
	
	public CadastroSegmentoRVServiceImpl(PagingAndSortingRepository<CadastroSegmentoRVDomain, Long> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	
}
