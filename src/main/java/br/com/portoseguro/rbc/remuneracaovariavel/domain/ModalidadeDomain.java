package br.com.portoseguro.rbc.remuneracaovariavel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PPOKMDL")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class ModalidadeDomain implements Serializable{
	private static final long serialVersionUID = 7294627727975980817L;

	@Id
	@Column(name="MDLCOD")
	private Long codModalidade;
	
	@Column(name = "RAMCOD")
	private Integer codRamo;
	
	@Column(name = "IFXMDLCOD")
	private Integer codModInformix;
	
	@Column(name = "MDLSGPNUM")
	private Integer numSubGrupoModadlidade;
	
	@Column(name = "MDLGRPNUM")
	private Integer numGrupoModalidade;
	
	@Column(name = "SGRCBTTIPNUM")
	private Integer numTipoCoberturaSeguro;
	
	@Column(name = "MDLNOM")
	private String nomModalidade;
	
	@Column(name = "MDLSGL")
	private String siglaModalidade;
	

}
