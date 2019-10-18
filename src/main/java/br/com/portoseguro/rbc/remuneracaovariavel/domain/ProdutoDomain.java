package br.com.portoseguro.rbc.remuneracaovariavel.domain;

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
@Table(name="PPOKPRD")
@ToString
public class ProdutoDomain {
	
	@Id
	@Column(name = "PRDCOD")
	private Long codProduto;
	
	@Column(name = "EMPCOD")
	private Integer codEmpresa;
	
	@Column(name = "PRDNOM")
	private  String produto;
	
	@Column(name = "PRDSGL")
	private String siglaProduto;
	
	@Column(name = "PRDIFXCOD")
	private Integer codInformixProduto;
	
	@Column(name = "INCDAT")
	private Date dtaInclusao;
	
	@Column(name = "ATLDAT")
	private Date dtaAtualizacao;
	
	@Column(name = "ATLUSRTIPCOD")
	private String CodTipoUsuAtualizacao;
	
	@Column(name = "ATLEMPCOD")
	private Integer codEmpresaAtualizacao;
	
	@Column(name = "ATLMATNUM")
	private Integer numMatriculaAtualizacao;

}
