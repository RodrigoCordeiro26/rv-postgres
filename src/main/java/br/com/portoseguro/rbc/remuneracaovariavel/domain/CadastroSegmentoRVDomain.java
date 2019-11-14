package br.com.portoseguro.rbc.remuneracaovariavel.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tb_cadastro_segmento_rv")
@Getter @Setter @ToString 
public class CadastroSegmentoRVDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nomeSementoRV")
	private String nmSegmentoRV;
	
	@Column(name="seguro")
	private Boolean tipoProduto;
	
	@Column(name="observacao")
	private String observacao;
	
	@Column(name="assessoria")
	private Boolean assessoria;
	
	@Column(name="equipeComercial")
	private Boolean equipeComercial;
	
	@Column(name="gratificacao")
	private Boolean gratificacao;
	
	@Column(name="campanha")
	private Boolean campanha;
	
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="obsMudancaStatus")
	private String observacaoMudancaStatus;
	
	public CadastroSegmentoRVDomain() {
		setStatus(Boolean.TRUE);
	}

	public CadastroSegmentoRVDomain(Long id, String nmSegmentoRV, Boolean tipoProduto, String observacao,
			Boolean assessoria, Boolean equipeComercial, Boolean gratificacao, Boolean campanha, Boolean status,
			Set<Integer> tipoCalculo, String obsMudancaStatus) {
		super();
		this.id = id;
		this.nmSegmentoRV = nmSegmentoRV;
		this.tipoProduto = tipoProduto;
		this.observacao = observacao;
		this.assessoria = assessoria;
		this.equipeComercial = equipeComercial;
		this.gratificacao = gratificacao;
		this.campanha = campanha;
		this.status = status;
		this.observacaoMudancaStatus = obsMudancaStatus;
	}
	
	
	
}
