package br.com.portoseguro.rbc.remuneracaovariavel.dto;

import java.io.Serializable;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class SearchCadastroRVDTO implements Serializable{
	private static final long serialVersionUID = -1791877523978802929L;

	@NotNull
	private String opcaoSelecionada;
	private String segmento;
	private Long codigo;
}
