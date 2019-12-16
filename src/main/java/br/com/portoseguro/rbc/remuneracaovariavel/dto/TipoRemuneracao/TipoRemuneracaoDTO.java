package br.com.portoseguro.rbc.remuneracaovariavel.dto.TipoRemuneracao;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class TipoRemuneracaoDTO implements Serializable {
	private static final long serialVersionUID = -8559420089647290141L;

	
	private Long id;
	
	@NotBlank @NotNull
	private String nmTipoRemuneracao;
	
	@JsonIgnore
	private Date dtInclusao;
	
	@JsonIgnore
	private Date dtAlteracao;
	
	@JsonIgnore
	private String usuario;
	@JsonIgnore

	
	public TipoRemuneracaoDTO(Long id, String nmTipoRemuneracao, Date dtInclusao, Date dtAlteracao, String usuario) {
		super();
		this.id = id;
		this.nmTipoRemuneracao = nmTipoRemuneracao;
		this.dtInclusao = dtInclusao;
		this.dtAlteracao = dtAlteracao;
		this.usuario = usuario;

	}
	
	
	
	
	
}
