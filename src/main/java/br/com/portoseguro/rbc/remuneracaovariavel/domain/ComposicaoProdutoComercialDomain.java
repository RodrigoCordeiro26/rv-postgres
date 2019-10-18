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
@Table(name = "PPOKCMCPRDCPS")
@ToString
public class ComposicaoProdutoComercialDomain implements Serializable{
	private static final long serialVersionUID = 5016517230805866866L;
	@Id
	@Column(name = "CMCPRDCOD")
	private Long codComposicaoProduto;
	@Column(name = "PRDCOD")
	private Integer codProduto;
	@Column(name = "CMCPRDCPSSEQNUM")
	private Integer numSeqComposicao;
	@Column(name = "RAMCOD")
	private Integer codRamo;
	@Column(name = "MDLCOD")
	private Integer codModalidade;
	@Column(name = "MDLGRPNUM")
	private Integer numGrupoProduto;
	@Column(name = "MDLSGPNUM")
	private Integer numSubGrupoProduto;
	@Column(name = "PRDGRDPTCTIPCOD")
	private String codTipoComposicao;
	@Column(name = "CMCPRDCPSSITCOD")
	private Integer codSituacaoComposicao;
	@Column(name = "CMCPRDCPSDES")
	private String descComposicao;
	@Column(name = "REGICLDAT")
	private Date dtaInclucaoComposicao;
	@Column(name = "REGATLDAT")
	private Date dtaAtualizacaoComposicao;
	@Column(name = "ATLUSRTIPCOD")
	private String codusuAtualizacao;
	@Column(name = "ATLUSREMPCOD")
	private Integer codComposicaoAtualizacao;
	@Column(name = "ATLUSRMATNUM")
	private Integer numMatriculaAtualizacao;

}
