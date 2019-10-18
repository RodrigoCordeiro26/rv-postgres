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
@Setter
@Getter
@NoArgsConstructor
@Table(name="PPOKMDLSGP")
@ToString
public class SubGrupoProdutoDomain implements Serializable{

	private static final long serialVersionUID = 8867848286263256389L;

	@Id
	@Column(name="MDLSGPNUM")
	private Long numSubGrupo;
	
	@Column(name="MDLGRPNUM")
	private Integer numGrupo;
	
	@Column(name="MDLSGPNOM")
	private String nomSubGrupo;
	

}
