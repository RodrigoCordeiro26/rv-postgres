package br.com.portoseguro.rbc.remuneracaovariavel.dto.TipoRemuneracao;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class TipoRemuneracaoDTOMin implements Serializable {
	private static final long serialVersionUID = 3488970930607775359L;

	private Long id;
	private String nmTipoRemuneracao;
	
	public TipoRemuneracaoDTOMin(Long id, String nmTipoRemuneracao) {
		super();
		this.id = id;
		this.nmTipoRemuneracao = nmTipoRemuneracao;
	}
	
	
	
}
