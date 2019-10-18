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
@Table(name="PPOKMDLGRP")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class GrupoProdutoDomain implements Serializable {

	private static final long serialVersionUID = 5852176839447979809L;

	@Id
	@Column(name="MDLGRPNUM")
	private Long numGrupo;
	
	@Column(name="MDLGRPNOM")
	private String nomGrupo;
	

}
