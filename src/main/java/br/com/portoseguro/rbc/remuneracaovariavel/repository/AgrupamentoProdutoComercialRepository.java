package br.com.portoseguro.rbc.remuneracaovariavel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.AgrupamentoProdutoComercialDomain;



@Repository
public interface AgrupamentoProdutoComercialRepository extends JpaRepository<AgrupamentoProdutoComercialDomain, Long>{

}
