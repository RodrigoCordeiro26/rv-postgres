package br.com.portoseguro.rbc.remuneracaovariavel.domain;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="PRVKPDCIND")
@Getter @Setter @ToString @NoArgsConstructor
public class IndicadoreProducaoDomain implements Serializable{
	private static final long serialVersionUID = 429919177474837460L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PDCINDCOD")
	private Long codIndicadorProducao;
	
	@Column(name="PDCINDNOM")
	private String nmIndicadorProd;
	
	@Column(name="PDCINDABVNOM")
	private String nmAbreviadoIndicadorProd;
	
	@Column(name="REGSITFLG")
	private Integer situacao;
	
	@Column(name="REGICLDAT")
	private Date dtInclusaoRegistro;

	@Column(name="REGATLDAT")
	private Date dtAlteracaoRegistro;
	
	@Column(name="USRTIPCOD")
	private String tipoUsuarioAtualizacao;
	
	@Column(name="EMPCOD")
	private Long codEmpresa;
	
	@Column(name="FUNMATNUM")
	private Long matriculaUsuario;
	
	/**
	 * Flag que indica se o indicador é seguro ou não seguro
	 * */
	@Column(name="SGRINDFLG")
	private Byte flgIndicadorSeguro;
	
	@Column(name="PDCINDFISNOM")
	private String nmFisicoIndicador;
	
	@Column(name="PDCINDPRVNOM")
	private String nmPrivadoIndicador;

	public IndicadoreProducaoDomain(Long codIndicadorProducao, String nmIndicadorProd, String nmAbreviadoIndicadorProd,
			Integer situacao, Date dtInclusaoRegistro, Date dtAlteracaoRegistro, String tipoUsuarioAtualizacao,
			Long codEmpresa, Long matriculaUsuario, Byte flgIndicadorSeguro, String nmFisicoIndicador,
			String nmPrivadoIndicador) {
		super();
		this.codIndicadorProducao = codIndicadorProducao;
		this.nmIndicadorProd = nmIndicadorProd;
		this.nmAbreviadoIndicadorProd = nmAbreviadoIndicadorProd;
		this.situacao = situacao;
		this.dtInclusaoRegistro = dtInclusaoRegistro;
		this.dtAlteracaoRegistro = dtAlteracaoRegistro;
		this.tipoUsuarioAtualizacao = tipoUsuarioAtualizacao;
		this.codEmpresa = codEmpresa;
		this.matriculaUsuario = matriculaUsuario;
		this.flgIndicadorSeguro = flgIndicadorSeguro;
		this.nmFisicoIndicador = nmFisicoIndicador;
		this.nmPrivadoIndicador = nmPrivadoIndicador;
	}
	
	
}
