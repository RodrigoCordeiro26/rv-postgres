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
@Setter
@Getter
@NoArgsConstructor
@Table(name = "PPOKCMCPRD")
@ToString
public class ProdutoComercialDomain implements Serializable{
	private static final long serialVersionUID = -6179785654488819268L;
	@Id
	@Column(name = "CMCPRDCOD")
	private Long codProdutoComercial;
	@Column(name = "CMCPRDNOM")
	private String nomProdutoComercial;
	@Column(name = "SGRPRDFLG")
	private String flgSubGrupoProdutoComercial;
	@Column(name = "VIGINIDAT")
	private Date dtaIncioVigencia;
	@Column(name = "REGICLDAT")
	private Date dtaInclusaoRegistro;
	@Column(name = "REGATLDAT")
	private Date dtaAtualizacaoRegistro;
	@Column(name = "ATLUSRTIPCOD")
	private String codTipoAtualizacao;
	@Column(name = "ATLUSREMPCOD")
	private Integer codComposicaoAtualizacao;
	@Column(name = "ATLUSRMATNUM")
	private Integer numMatriculaAtualizacao;
	@Column(name = "CMCPRDCPSSITCOD")
	private Integer codSituacaoComposicao;
	@Column(name = "CMCPRDCPSDES")
	private String descComposicao;
	@Column(name = "CMCPRDPIRFLG")
	private Integer flgProdutoComercial;
	@Column(name = "BNCSGMFLG")
	private Integer siglaProdutoComercial;
	@Column(name = "CLSFLRFLG")
	private Integer ProdutoComercialFlr;

}
