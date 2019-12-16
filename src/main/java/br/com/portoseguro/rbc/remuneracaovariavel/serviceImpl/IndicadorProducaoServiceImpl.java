package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.IndicadoreProducaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.IndicadorProducaoRepository;

@Service
public class IndicadorProducaoServiceImpl extends GenericService<IndicadoreProducaoDomain>{

	@Autowired
	IndicadorProducaoRepository indicadorProducaoRepository;
	
	
	public IndicadorProducaoServiceImpl(PagingAndSortingRepository<IndicadoreProducaoDomain, Long> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}


	public IndicadoreProducaoDomain nmIndicadorProd(String indicadorTaxa) {
		// TODO Auto-generated method stub
		IndicadoreProducaoDomain ind = new IndicadoreProducaoDomain();
		ind.setNmIndicadorProd("Indicador 3");
		indicadorProducaoRepository.save(ind);
		return ind;
	}

}
