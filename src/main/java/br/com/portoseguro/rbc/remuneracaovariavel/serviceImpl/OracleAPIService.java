package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.AgrupamentoProdutoComercialDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.ComposicaoProdutoComercialDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.EmpresaDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.GrupoProdutoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.ModalidadeDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.ProdutoComercialDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.ProdutoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.RamoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.SubGrupoProdutoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.AgrupamentoProdutoComercialRepository;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.ComposicaoProdutoComercialRepository;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.EmpresaRepository;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.GrupoProdutoRepository;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.ModalidadeRepository;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.ProdutoComercialRepository;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.ProdutoRepository;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.RamoRepository;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.SubGrupoProdutoRepository;

/**
 * @author rodrigocordeiro
 * 17/10/2019
 * 
 * */
@Service
public class OracleAPIService {
	
	/*
	 * 
	 * INICIO INSTANCIAÇÃO DOS REPOSITORIES;
	 * 
	 * */
	
	@Autowired
	private AgrupamentoProdutoComercialRepository agrupamentoProdutoComercialRepository;
	
	@Autowired
	private ComposicaoProdutoComercialRepository composicaoProdutoComercialRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private GrupoProdutoRepository grupoProdutoRepository;
	
	@Autowired
	private ModalidadeRepository modalidadeRepository;
	
	@Autowired
	private ProdutoComercialRepository produtoComercialRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private RamoRepository ramoRepository;
	
	@Autowired
	private SubGrupoProdutoRepository subGrupoProdutoRepository;

	/*
	 * 
	 * FIM INSTANCIAÇÃO DOS REPOSITORIES;
	 * 
	 * */
	
	/*
	 * INICIO INSTANCIACAO DAS APIS
	 * 
	 * */
//	@Autowired
//	OracleAPIGeneric<RamoDomain> apiRamo;
//	
	@Autowired
	OracleAPIGeneric<EmpresaDomain> apiEmpresa;
	
	@Autowired
	OracleAPIGeneric<GrupoProdutoDomain> apiGrupoProduto;
	
	@Autowired
	public OracleAPIGeneric<AgrupamentoProdutoComercialDomain> apiAgrupamentoProdutoComercial;
	
	@Autowired
	public OracleAPIGeneric<ComposicaoProdutoComercialDomain> apiComposicaoProdutoComercial;
	
	@Autowired
	public OracleAPIGeneric<ModalidadeDomain> apiModalidade;
	
	@Autowired
	public OracleAPIGeneric<ProdutoComercialDomain> apiProdutoComercial;
	
	@Autowired
	public OracleAPIGeneric<SubGrupoProdutoDomain> apiSubGrupoProduto;
	
	@Autowired
	public OracleAPIGeneric<ProdutoDomain> apiProduto;
	
	@Autowired
	public OracleAPIGeneric<RamoDomain> apiRamo;

	/*
	 * FIM INSTANCIACAO DAS APIS
	 * 
	 * */
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public List<RamoDomain> retornarRamo(){
		
		List<RamoDomain> response = apiRamo.API("/ramo", ramoRepository);
		RamoDomain[] map = objectMapper.convertValue(response, RamoDomain[].class);
		
		for (RamoDomain ramoDomain : map) {
			ramoRepository.save(ramoDomain);
		}
		
		
		return response;
	}
	
	

	public List<EmpresaDomain> retornarEmpresa(){
		List<EmpresaDomain> response = apiEmpresa.API("/empresa", empresaRepository);
		
		EmpresaDomain[] map = objectMapper.convertValue(response, EmpresaDomain[].class);
		
		for (EmpresaDomain empresa : map) {
			empresaRepository.save(empresa);
		}
		
		return response;
	}
	
	public List<GrupoProdutoDomain> retornarGrupoProduto(){
		List<GrupoProdutoDomain> response = apiGrupoProduto.API("/grupoProduto", grupoProdutoRepository);
	
		GrupoProdutoDomain[] map = objectMapper.convertValue(response, GrupoProdutoDomain[].class);
		
		for (GrupoProdutoDomain grupo : map) {
			grupoProdutoRepository.save(grupo);
		}
		return response;
	}
	
	public List<AgrupamentoProdutoComercialDomain> retornarAgrupamentoProdutoComercial(){
		List<AgrupamentoProdutoComercialDomain> response = apiAgrupamentoProdutoComercial.API("/agrupamentoProdutoComercial", agrupamentoProdutoComercialRepository);
	
		AgrupamentoProdutoComercialDomain[] map = objectMapper.convertValue(response, AgrupamentoProdutoComercialDomain[].class);

		for (AgrupamentoProdutoComercialDomain agrup : map) {
			agrupamentoProdutoComercialRepository.save(agrup);
		}
		
		return response;
	}
	
	public List<ComposicaoProdutoComercialDomain> retornarComposicaoProdutoComercialDomain(){
		List<ComposicaoProdutoComercialDomain> response = apiComposicaoProdutoComercial.API("/composicaoProdutoComercial", composicaoProdutoComercialRepository);
		
		ComposicaoProdutoComercialDomain[] map = objectMapper.convertValue(response, ComposicaoProdutoComercialDomain[].class);

		for (ComposicaoProdutoComercialDomain compos : map) {
			composicaoProdutoComercialRepository.save(compos);
		}
		
		
		
		return response;
	} 
	
	public List<ModalidadeDomain> retornarModalidade(){
		List<ModalidadeDomain> response = apiModalidade.API("/modalidade", modalidadeRepository);
		
		ModalidadeDomain[] map = objectMapper.convertValue(response, ModalidadeDomain[].class);

		for (ModalidadeDomain modalidade : map) {
			modalidadeRepository.save(modalidade);
		}
		
		return response;
	}
	
	public List<ProdutoComercialDomain> retornarProdutoComercial(){
		List<ProdutoComercialDomain> response = apiProdutoComercial.API("/produtoComercial", produtoComercialRepository);

		ProdutoComercialDomain[] map = objectMapper.convertValue(response, ProdutoComercialDomain[].class);

		for (ProdutoComercialDomain prod : map) {
			produtoComercialRepository.save(prod);
		}
		
		return response;
	}
	
	public List<SubGrupoProdutoDomain> retornarSubGrupoProduto(){
		List<SubGrupoProdutoDomain> response = apiSubGrupoProduto.API("/subGrupoProduto", subGrupoProdutoRepository);
		
		SubGrupoProdutoDomain[] map = objectMapper.convertValue(response, SubGrupoProdutoDomain[].class);
		
		for (SubGrupoProdutoDomain subprod : map) {
			subGrupoProdutoRepository.save(subprod);
		}
		
		return response;
	}
	
	public List<ProdutoDomain> retornarProduto(){
		List<ProdutoDomain> response= apiProduto.API("/produto", produtoRepository);
	
		ProdutoDomain[] map = objectMapper.convertValue(response, ProdutoDomain[].class);


		for (ProdutoDomain prod : map) {
			produtoRepository.save(prod);
		}
		return response;
	}

}
