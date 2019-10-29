package br.com.portoseguro.rbc.remuneracaovariavel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;

@Repository
public interface CadastroSegmentoRVRepository extends PagingAndSortingRepository<CadastroSegmentoRVDomain, Long>{

}
