package br.com.portoseguro.rbc.remuneracaovariavel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tb_cadastro_segmento_rv")
@Getter @Setter @ToString @NoArgsConstructor
public class CadastroSegmentoRVDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NomeSementoRV")
	private String nmSegmentoRv;
	
	@Column(name="Seguro")
	private Boolean isSeguro;
	
	@Column(name="Observacao")
	private String observacao;
	
	@Column(name="assessoria")
	private Boolean assessoria;
	
	@Column(name="normal")
	private Boolean normal;

	public CadastroSegmentoRVDomain(Long id, String nmSegmentoRv, Boolean isSeguro, String observacao) {
		super();
		this.id = id;
		this.nmSegmentoRv = nmSegmentoRv;
		this.isSeguro = isSeguro;
		this.observacao = observacao;
	}
	
	
}
