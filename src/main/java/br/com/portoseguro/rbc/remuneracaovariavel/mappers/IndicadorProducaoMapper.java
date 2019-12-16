package br.com.portoseguro.rbc.remuneracaovariavel.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.IndicadoreProducaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.IndicadorProducaoDTO;

@Component
public class IndicadorProducaoMapper {
	
	
	
	public IndicadorProducaoDTO mapear(IndicadoreProducaoDomain indicador) {
		IndicadorProducaoDTO ind = new IndicadorProducaoDTO();
		ind.setId(indicador.getCodIndicadorProducao());
		ind.setNmIndicador(indicador.getNmIndicadorProd());
		return ind;
	}
	
	public List<IndicadorProducaoDTO> mapear(List<IndicadoreProducaoDomain> lsIndicador){
		List<IndicadorProducaoDTO> lsIndicadorDTO = lsIndicador.stream().map(x->{
			return mapear(x);
		}).collect(Collectors.toList());
		
		return lsIndicadorDTO;
	}
}
