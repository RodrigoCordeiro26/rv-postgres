package br.com.portoseguro.rbc.remuneracaovariavel.domain;

import java.io.Serializable;

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
@Table(name="periodoMeta")
@Getter @Setter @ToString @NoArgsConstructor
public class PeriodoMetaDomain implements Serializable {
	private static final long serialVersionUID = 5303167647880713406L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nmPeriodo;
	private Boolean flgAnual;
	private Boolean flgUltimosDoze;
	private Boolean flgMesAtual;
	private Boolean flgMesAnterior;
	private Boolean flgReferencia;

	private Boolean situacao;

	public PeriodoMetaDomain(Long id, String nmPeriodo, Boolean flgAnual, Boolean flgUltimosDoze, Boolean flgMesAtual,
			Boolean flgMesAnterior, Boolean flgReferencia, Boolean situacao) {
		super();
		this.id = id;
		this.nmPeriodo = nmPeriodo;
		this.flgAnual = flgAnual;
		this.flgUltimosDoze = flgUltimosDoze;
		this.flgMesAtual = flgMesAtual;
		this.flgMesAnterior = flgMesAnterior;
		this.flgReferencia = flgReferencia;
		this.situacao = situacao;
	}
	
	
	
}
