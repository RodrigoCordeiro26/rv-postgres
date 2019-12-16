package br.com.portoseguro.rbc.remuneracaovariavel.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.TipoRemuneracaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.TipoRemuneracao.TipoRemuneracaoDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.TipoRemuneracao.TipoRemuneracaoDTOMin;

@Component
public class TipoRemuneracaoMapper {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
	
	
	public TipoRemuneracaoDTO mapear(TipoRemuneracaoDomain tipoRemuneracaoDomain) {
		return new TipoRemuneracaoDTO(tipoRemuneracaoDomain.getId(), tipoRemuneracaoDomain.getNmTipoRemuneracao(), tipoRemuneracaoDomain.getDtInclusao(), tipoRemuneracaoDomain.getDtAlteracao(), tipoRemuneracaoDomain.getUsuario());
	}
	
	public List<TipoRemuneracaoDTO> mapear(List<TipoRemuneracaoDomain> lsTipoRemuneracaoDomain){
		return lsTipoRemuneracaoDomain.stream().map(tipoRemuneracaoDomain->{
			return mapear(tipoRemuneracaoDomain);
		}).collect(Collectors.toList());
	}
	
	
	public List<TipoRemuneracaoDTOMin> mapearDTOMinificado(List<TipoRemuneracaoDomain> lsTipoRemuneracaoDomain){
		
		return  lsTipoRemuneracaoDomain.stream().map(tipoRemuneracaoDomain ->{
			return new TipoRemuneracaoDTOMin(tipoRemuneracaoDomain.getId(), tipoRemuneracaoDomain.getNmTipoRemuneracao());
		}).collect(Collectors.toList());
		
		
	}
	
	public TipoRemuneracaoDomain mapearPost(TipoRemuneracaoDTO tipoRemuneracaoDTO) throws ParseException {
		String usuario = System.getProperty("user.name"); 
		String dataFormatada = sdf.format(new Date());
		TipoRemuneracaoDomain tipoRemuneracaoDomain = new TipoRemuneracaoDomain(null, tipoRemuneracaoDTO.getNmTipoRemuneracao(), sdf.parse(dataFormatada), null, usuario);
	
		return tipoRemuneracaoDomain;
	
	}
	
	public TipoRemuneracaoDomain mapearPut(TipoRemuneracaoDTO tipoRemuneracaoDTO) throws ParseException {
		String usuario = System.getProperty("user.name"); 
		String dataFormatada = sdf.format(new Date());
		TipoRemuneracaoDomain tipoRemuneracaoDomain = new TipoRemuneracaoDomain(tipoRemuneracaoDTO.getId(), tipoRemuneracaoDTO.getNmTipoRemuneracao(), tipoRemuneracaoDTO.getDtInclusao(), sdf.parse(dataFormatada), usuario);
	
		return tipoRemuneracaoDomain;
	}
	
}
