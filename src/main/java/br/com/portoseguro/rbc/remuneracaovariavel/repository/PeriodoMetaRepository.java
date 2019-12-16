package br.com.portoseguro.rbc.remuneracaovariavel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.PeriodoMetaDomain;

@Repository
public interface PeriodoMetaRepository extends PagingAndSortingRepository<PeriodoMetaDomain, Long> {

	public PeriodoMetaDomain findByNmPeriodoIgnoreCase(String periodo);

}
