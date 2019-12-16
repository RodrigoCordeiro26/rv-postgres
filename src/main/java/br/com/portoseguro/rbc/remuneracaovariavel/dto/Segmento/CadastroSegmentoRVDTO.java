package br.com.portoseguro.rbc.remuneracaovariavel.dto.Segmento;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class CadastroSegmentoRVDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nmSegmentoRV;
	private String tipoProduto;
	private String observacao;
	private String assessoria;
	private String equipeComercial;
	private String status;
	private String gratificacao;
	private String campanha;
	private String observacaoMudancaStatus;
	private String dataAtualizacao;

}
