package br.com.portoseguro.rbc.remuneracaovariavel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;

@Repository
public interface CadastroSegmentoRVRepository extends JpaRepository<CadastroSegmentoRVDomain, Long>{

	public List<CadastroSegmentoRVDomain> findByNmSegmentoRVContainingIgnoreCase(String value);

//	@Query("SELECT obj FROM CadastroSegmentoRVDomain obj WHERE obj.assessoria = :value")
//	public List<CadastroSegmentoRVDomain> findByAssessoria(@Param("value")Boolean value);
//
//	@Query("SELECT obj FROM CadastroSegmentoRVDomain obj WHERE obj.normal = :value")
//	public List<CadastroSegmentoRVDomain> findByNormal(@Param("value")boolean value);
//
//	@Query("SELECT obj FROM CadastroSegmentoRVDomain obj WHERE obj.isSeguro = value ")
//	public List<CadastroSegmentoRVDomain> findByIsSeguro(@Param("value") boolean value);



}
