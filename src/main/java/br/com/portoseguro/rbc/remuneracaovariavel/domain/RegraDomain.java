package br.com.portoseguro.rbc.remuneracaovariavel.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tb_regra")
@Getter @Setter @ToString @NoArgsConstructor
public class RegraDomain implements Serializable{
	private static final long serialVersionUID = -1994901413754165183L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tp_agravo")
	private String tpAgravo;
	
	@Column(name="vlMinimo")
	private BigDecimal valorMinimo;
	
	@Column(name="vlMaximo")
	private BigDecimal valorMaximo;
	
	@Column(name="peso_regra")
	private BigDecimal pesoRegra;
	
	@ManyToOne()
	@JoinColumn(name = "id_indicador")
	private IndicadoreProducaoDomain indicadorProducao;
	
	@ManyToOne()
	@JoinColumn(name="id_periodo")
	private PeriodoMetaDomain periodo;
	
	@ManyToOne()
	@JoinColumn(name="id_bloco")
	private BlocoRegraDomain blocoRegra;

}
