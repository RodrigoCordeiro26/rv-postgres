package br.com.portoseguro.rbc.remuneracaovariavel.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class IndicadorProducaoDTO implements Serializable{
	private static final long serialVersionUID = -2281255391005542782L;

	private Long id;
	private String nmIndicador;
	
	
}
