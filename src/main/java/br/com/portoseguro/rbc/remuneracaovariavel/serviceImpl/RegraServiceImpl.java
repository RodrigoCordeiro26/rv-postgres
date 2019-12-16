package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.RegraDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.RegraRepository;

@Service
public class RegraServiceImpl extends GenericService<RegraDomain>{

	@Autowired
	RegraRepository regraRepository;
	
	
	public RegraServiceImpl(PagingAndSortingRepository<RegraDomain, Long> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	public List<RegraDomain> buscaIdBloco(Long id) {
		return regraRepository.findByIdBloco(id);
	}

	
}
