package br.com.portoseguro.rbc.remuneracaovariavel.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.Segmento.CadastroSegmentoRVDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.Segmento.SegmentoDTO;

@Component
public class CadastroSegmentoRVMapper {
	private static final String SEGURO = "SEGURO";
	private static final String NAO_SEGURO = "NÃO SEGURO";
	
	private static final String SIM ="SIM";
	private static final String NAO ="NÃO";
	
	private static final String ATIVO = "ATIVO";
	private static final String INATIVO = "INATIVO";
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	

	public CadastroSegmentoRVDTO mapear(CadastroSegmentoRVDomain obj){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		sdf.setTimeZone (TimeZone.getTimeZone("GMT-03:00"));
		
		if(obj == null)
			return null;
		CadastroSegmentoRVDTO objDTO = new CadastroSegmentoRVDTO();
		objDTO.setId(obj.getId());
		
		objDTO.setTipoProduto(obj.getTipoProduto() ? SEGURO : NAO_SEGURO);
		objDTO.setEquipeComercial(obj.getEquipeComercial() ? SIM : NAO);
		objDTO.setAssessoria(obj.getAssessoria() ? SIM : NAO);		
		objDTO.setNmSegmentoRV(obj.getNmSegmentoRV());
		objDTO.setObservacao(obj.getObservacao());
		objDTO.setStatus(obj.getStatus()?ATIVO : INATIVO);
		objDTO.setCampanha(obj.getCampanha()?SIM:NAO);
		objDTO.setGratificacao(obj.getGratificacao()?SIM:NAO);
		objDTO.setObservacaoMudancaStatus(obj.getObservacaoMudancaStatus());
		if(obj.getDataAtualizacao() != null)
			objDTO.setDataAtualizacao(sdf.format(obj.getDataAtualizacao()));
		return objDTO;
	}
	
	public List<CadastroSegmentoRVDTO> mapear(List<CadastroSegmentoRVDomain> lsObj) {
		
		List<CadastroSegmentoRVDTO> lsObjDTO = new ArrayList<CadastroSegmentoRVDTO>();
		
		for (CadastroSegmentoRVDomain item: lsObj) {
			lsObjDTO.add(mapear(item));
		}
		
		return lsObjDTO;
	}
	
	public CadastroSegmentoRVDomain mapear(CadastroSegmentoRVDTO objDTO) throws ParseException {
		String vdd = "true";
		if(objDTO == null)
			return null;
		CadastroSegmentoRVDomain obj = new CadastroSegmentoRVDomain();
		obj.setAssessoria(objDTO.getAssessoria().equalsIgnoreCase(vdd)? true : false);
		obj.setTipoProduto(objDTO.getTipoProduto().equalsIgnoreCase(SEGURO)?true : false);
		obj.setNmSegmentoRV(objDTO.getNmSegmentoRV());
		obj.setEquipeComercial(objDTO.getEquipeComercial().equalsIgnoreCase(vdd)?true : false);
		
		if(objDTO.getObservacao() != null && objDTO.getObservacao() != "")
			obj.setObservacao(objDTO.getObservacao());
		
		if(objDTO.getDataAtualizacao() != null && objDTO.getDataAtualizacao() != "") {
			obj.setDataAtualizacao(sdf.parse(objDTO.getDataAtualizacao()));
		}
		
		obj.setCampanha(objDTO.getCampanha().equalsIgnoreCase(vdd)? true : false);
		obj.setGratificacao(objDTO.getGratificacao().equalsIgnoreCase(vdd)? true : false);
		obj.setStatus(objDTO.getStatus().equalsIgnoreCase(ATIVO)? true : false);
		obj.setObservacaoMudancaStatus(objDTO.getObservacaoMudancaStatus());
		if(objDTO.getId() != null) {
			obj.setId(objDTO.getId());
		}
		

		return obj;
	}
	
	
	public List<SegmentoDTO> mapearMinificado(List<CadastroSegmentoRVDomain> lsSegmento ) {
		return lsSegmento.stream().map(segmento->{
			return new SegmentoDTO(segmento.getId(), segmento.getNmSegmentoRV());
		}).collect(Collectors.toList());
	}
}
