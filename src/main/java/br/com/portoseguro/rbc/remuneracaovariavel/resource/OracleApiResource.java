package br.com.portoseguro.rbc.remuneracaovariavel.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.AgrupamentoProdutoComercialDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.ComposicaoProdutoComercialDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.EmpresaDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.GrupoProdutoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.ModalidadeDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.ProdutoComercialDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.ProdutoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.RamoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.SubGrupoProdutoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.OracleAPIService;




/**
 * @author rodrigocordeiro
 * 17/10/2019
 * 
 * */
@RestController
@RequestMapping(value = "/consumoApi/")

public class OracleApiResource extends GenericResource{

	@Autowired
	OracleAPIService service;
	
	@GetMapping(value = "ramo")
	public ResponseEntity<List<RamoDomain>> ApiRamo(){
		return retornarSucesso(service.retornarRamo());
	}
	
	@GetMapping(value = "empresa")
	public ResponseEntity<List<EmpresaDomain>> ApiEmpresa(){
		return retornarSucesso(service.retornarEmpresa());
	}
	
	@GetMapping(value = "modalidade")
	public ResponseEntity<List<ModalidadeDomain>> ApiModalidade(){
		return retornarSucesso(service.retornarModalidade());
	}
	
	@GetMapping(value = "agrupamentoProdutoComercial")
	public ResponseEntity<List<AgrupamentoProdutoComercialDomain>> ApiAgrupamentoProdutoComercial(){
		return retornarSucesso(service.retornarAgrupamentoProdutoComercial());
	}
	
	@GetMapping(value = "composicaoProdutoComercial")
	public ResponseEntity<List<ComposicaoProdutoComercialDomain>> ApiComposicaoProdutoComercial(){
		return retornarSucesso(service.retornarComposicaoProdutoComercialDomain());
	}
	
	@GetMapping(value = "produto")
	public ResponseEntity<List<ProdutoDomain>> ApiProduto(){
		return retornarSucesso(service.retornarProduto());
	}
	
	@GetMapping(value = "produtoComercial")
	public ResponseEntity<List<ProdutoComercialDomain>> ApiProdutoComercial(){
		return retornarSucesso(service.retornarProdutoComercial());
	}
	
	@GetMapping(value = "GrupoProduto")
	public ResponseEntity<List<GrupoProdutoDomain>> ApiGrupoProduto(){
		return retornarSucesso(service.retornarGrupoProduto());
	}
	
	@GetMapping(value = "subGrupoProduto")
	public ResponseEntity<List<SubGrupoProdutoDomain>> ApiSubGrupoProduto(){
		return retornarSucesso(service.retornarSubGrupoProduto());
	}
}
