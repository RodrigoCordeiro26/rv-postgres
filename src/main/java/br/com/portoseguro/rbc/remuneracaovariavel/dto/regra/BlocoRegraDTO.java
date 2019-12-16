package br.com.portoseguro.rbc.remuneracaovariavel.dto.regra;

import java.io.Serializable;
import java.util.List;

import br.com.portoseguro.rbc.remuneracaovariavel.dto.Segmento.SegmentoDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.TipoRemuneracao.TipoRemuneracaoDTOMin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class BlocoRegraDTO  implements Serializable{
	private static final long serialVersionUID = 5963312016361417922L;
	private Long id;
	private String agravoTaxa;
	private String indicadorTaxa;
	private String valorTaxa;
	private Boolean blocoObrigatorio;
	private Boolean indcProporcionalidade;
	private List<TipoRemuneracaoDTOMin> lsTipoRemuneracao;
	private List<SegmentoDTO> lsSegmento;
	private List<RegraDTOGet> lsRegra;
	
	
}
