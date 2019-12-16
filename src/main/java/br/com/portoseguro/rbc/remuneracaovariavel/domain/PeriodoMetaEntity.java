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
@Table(name="PRVKMTAPED")
@Getter @Setter @ToString @NoArgsConstructor
public class PeriodoMetaEntity implements Serializable{
	private static final long serialVersionUID = -2076148305848008543L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MTAPEDCOD")	
	private Long codPeriodoMeta;
	
	@Column(name="MTAPEDDES")
	private String nmPeriodoMeta;
	
	@Column(name="MESPEDFLG")
	private Byte flagMesAtual;
	
	@Column(name="")
	private Boolean flgMesAnterior;
	
	@Column(name="DOZMESPEDFLG")
	private Boolean flgUltimoAno;
	
//	private Boolean flg
}
