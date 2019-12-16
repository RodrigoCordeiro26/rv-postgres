package br.com.portoseguro.rbc.remuneracaovariavel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.IndicadoreProducaoDomain;

@Repository
public interface IndicadorProducaoRepository extends PagingAndSortingRepository<IndicadoreProducaoDomain, Long> {

	IndicadoreProducaoDomain findByNmIndicadorProdIgnoreCase(String indicadorTaxa);

}
