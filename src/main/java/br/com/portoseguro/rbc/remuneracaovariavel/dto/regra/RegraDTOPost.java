package br.com.portoseguro.rbc.remuneracaovariavel.dto.regra;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.enums.TipoAgravo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class RegraDTOPost implements Serializable {
	private static final long serialVersionUID = -2185016159607640060L;

	private String id;
	
	@NotNull @NotEmpty
	private TipoAgravo agravo;
	
	@NotNull @NotEmpty
	private BigDecimal valorMinimo;
	
	@NotNull @NotEmpty
	private BigDecimal valorMaximo;

	@NotNull @NotEmpty
	private Long período;
	
	@NotNull @NotEmpty
	private Long indicadorRegra;
	
	private BigDecimal pesoRegra;
	
}
