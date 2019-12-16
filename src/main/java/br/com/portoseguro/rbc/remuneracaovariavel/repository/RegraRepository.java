package br.com.portoseguro.rbc.remuneracaovariavel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.RegraDomain;

@Repository
public interface RegraRepository extends PagingAndSortingRepository<RegraDomain, Long> {

	@Query("SELECT regra FROM RegraDomain regra where regra.blocoRegra.id = :id")
	public List<RegraDomain> findByIdBloco(Long id);

}
