package br.com.portoseguro.rbc.remuneracaovariavel.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PPOKCMCPRDGRP")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class AgrupamentoProdutoComercialDomain implements Serializable{
	private static final long serialVersionUID = -2075961535161057012L;
	
	@Id
	@Column(name = "CMCPRDGRPCOD")
	private Long codAgrupamentoProduto;
	@Column(name = "CMCPRDGRPNOM")
	private String nomAgrupamentoProduto;
	@Column(name = "CMCPRDGRPSITCOD")
	private Integer codSituacaoAgrupProduto;
	@Column(name = "VIGINIDAT")
	private Date dtaInicioVigencia;
	@Column(name = "REGICLDAT")
	private Date dtaInclusao;
	@Column(name = "REGATLDAT")
	private Date dtaAlteracao;
	@Column(name = "ATLUSRTIPCOD")
	private String codTipoAgrupamento;
	@Column(name = "ATLUSREMPCOD")
	private Integer codAtualizacaoUsuAgrup;
	@Column(name = "ATLUSRMATNUM")
	private Integer numMatriculaAgrupamento;
	

}
