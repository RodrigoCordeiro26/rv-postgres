package br.com.portoseguro.rbc.remuneracaovariavel.dto.regra;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.enums.TipoAgravo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class RegraDTOGet implements Serializable{
	private static final long serialVersionUID = -8782397168357932725L;

	private Long id;
	
	private String agravo;
	
	private String valorMinimo;
	
	private String valorMaximo;

	private String periodo;
	
	private String indicadorRegra;
	
	private String pesoRegra;
}
