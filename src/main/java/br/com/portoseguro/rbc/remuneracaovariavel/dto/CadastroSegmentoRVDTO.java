package br.com.portoseguro.rbc.remuneracaovariavel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class CadastroSegmentoRVDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nmSegmentoRv;
	private Boolean isSeguro;
	private String observacao;
	private Boolean assessoria;
	private Boolean normal;
	
	
	

}
