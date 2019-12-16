package br.com.portoseguro.rbc.remuneracaovariavel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.BlocoRegraDomain;

@Repository
public interface BlocoRegraRepository extends PagingAndSortingRepository<BlocoRegraDomain, Long> {

}
