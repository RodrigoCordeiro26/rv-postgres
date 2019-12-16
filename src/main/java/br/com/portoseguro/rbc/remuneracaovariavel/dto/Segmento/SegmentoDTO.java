package br.com.portoseguro.rbc.remuneracaovariavel.dto.Segmento;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class SegmentoDTO implements Serializable {
	private static final long serialVersionUID = -2080522997407578529L;

	
	private Long id;
	private String nome;
	
	public SegmentoDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	
}
