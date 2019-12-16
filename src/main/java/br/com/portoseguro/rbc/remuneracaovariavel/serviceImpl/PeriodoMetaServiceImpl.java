package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.PeriodoMetaDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.PeriodoMetaRepository;

@Service
public class PeriodoMetaServiceImpl extends GenericService<PeriodoMetaDomain>{

	@Autowired
	PeriodoMetaRepository periodoMetaRepository;
	
	
	public PeriodoMetaServiceImpl(PagingAndSortingRepository<PeriodoMetaDomain, Long> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}


	public PeriodoMetaDomain buscarPorNome(String periodo) {
		return periodoMetaRepository.findByNmPeriodoIgnoreCase(periodo);
		
	}


	public PeriodoMetaDomain findByNmPeriodo(String período) {
		PeriodoMetaDomain periodo = periodoMetaRepository.findByNmPeriodoIgnoreCase(período);
		return periodo;
	}

}
