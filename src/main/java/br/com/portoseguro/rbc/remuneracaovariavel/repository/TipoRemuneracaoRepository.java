package br.com.portoseguro.rbc.remuneracaovariavel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.TipoRemuneracaoDomain;

@Repository
public interface TipoRemuneracaoRepository extends PagingAndSortingRepository<TipoRemuneracaoDomain, Long>{

}
