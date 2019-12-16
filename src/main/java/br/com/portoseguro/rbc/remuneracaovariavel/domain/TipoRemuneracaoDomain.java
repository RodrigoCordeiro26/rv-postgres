package br.com.portoseguro.rbc.remuneracaovariavel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tb_tipoRemuneracao")
@Getter @Setter @ToString @NoArgsConstructor
public class TipoRemuneracaoDomain implements Serializable {
	private static final long serialVersionUID = -8086739556979833694L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nmTipoRemuneracao")
	private String nmTipoRemuneracao;
	
	@Column(name="dtInclusao")
	private Date dtInclusao;
	
	@Column(name="dtAlteracao")
	private Date dtAlteracao;
	
	@Column(name="usuario")
	private String usuario;
	
	public TipoRemuneracaoDomain(Long id, String nmTipoRemuneracao, Date dtInclusao, Date dtAlteracao, String usuario) {
		super();
		this.id = id;
		this.nmTipoRemuneracao = nmTipoRemuneracao;
		this.dtInclusao = dtInclusao;
		this.dtAlteracao = dtAlteracao;
		this.usuario = usuario;
	}
	
	
}
