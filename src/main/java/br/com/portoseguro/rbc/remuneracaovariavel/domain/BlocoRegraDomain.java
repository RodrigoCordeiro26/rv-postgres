package br.com.portoseguro.rbc.remuneracaovariavel.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tb_bloco_regra")
@Getter @Setter @ToString @NoArgsConstructor
public class BlocoRegraDomain implements Serializable{
	private static final long serialVersionUID = 7658524703970822760L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="agravo_taxa")
	private String agravoTaxa;
	
//	@ManyToOne()
//	@JoinColumn(name = "id_Indicador")
//	private IndicadoreProducaoDomain indicadorTaxa;
//	
	private String indicadorTaxa;
	
	@Column(name = "vl_taxa")
	private BigDecimal valorTaxa;
	
	@Column(name = "dt_inclusao")
	private Date dtInclusao;
	
	@Column(name = "dt_alteracao")
	private Date dtAlteracao;
	
	@Column(name = "usuario_alteracao")
	private String usuarioAlteracao;
	
	@Column(name = "obrigatorio")
	private Boolean obrigatorio;
	
	@Column(name = "proporcional")
	private Boolean proporcional;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "Segmento_Regra", 
        joinColumns = { @JoinColumn(name = "id_bloco_regra") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_segmento") }
    )
	private Set<CadastroSegmentoRVDomain> lsSegmento = new HashSet<>();
	
	
	@ManyToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
        name = "Tipo_Remuneracao_Regra", 
        joinColumns = { @JoinColumn(name = "id_bloco_regra") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_tipo_remuneracao") }
    )
	private Set<TipoRemuneracaoDomain> lsTipoRemuneracao = new HashSet<>();
	
}
