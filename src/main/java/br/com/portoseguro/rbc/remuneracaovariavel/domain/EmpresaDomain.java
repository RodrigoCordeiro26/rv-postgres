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
@Table(name = "PPOKEMP")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class EmpresaDomain implements Serializable{

	private static final long serialVersionUID = 7724514354179088754L;

	@Id
	@Column(name = "EMPCOD")
	private Long codEmpresa;
	
	@Column(name = "EMPNOM")
	private String nomEmpresa;
	
	@Column(name = "EMPIFXCOD")
	private Integer codInformixEmpresa;
	
	@Column(name = "INCDAT")
	private Date dtaInclusao;
	
	@Column(name = "ATLDAT")
	private Date dtaAtualizacao;
	
	@Column(name = "ATLUSRTIPCOD")
	private String codTipoUsuaAtualizacao;
	
	@Column(name = "ATLEMPCOD")
	private Integer codEmpresaAtualizada;
	
	@Column(name = "ATLMATNUM")
	private Integer numMatriculaAtualizada;
	
	@Column(name = "EMPSGL")
	private String siglaEmpresa;
	
	

}
