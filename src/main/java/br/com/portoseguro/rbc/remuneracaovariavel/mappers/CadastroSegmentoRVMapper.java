package br.com.portoseguro.rbc.remuneracaovariavel.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.CadastroSegmentoRVDTO;

@Component
public class CadastroSegmentoRVMapper {
	
	public CadastroSegmentoRVDTO mapear(CadastroSegmentoRVDomain obj){
		CadastroSegmentoRVDTO objDTO = new CadastroSegmentoRVDTO();
		objDTO.setId(obj.getId());
		objDTO.setIsSeguro(obj.getIsSeguro());
		objDTO.setNmSegmentoRv(obj.getNmSegmentoRv());
		objDTO.setObservacao(obj.getObservacao());
		return objDTO;
	}
	
	public List<CadastroSegmentoRVDTO> mapear(List<CadastroSegmentoRVDomain> lsObj) {
		
		List<CadastroSegmentoRVDTO> lsObjDTO = new ArrayList<CadastroSegmentoRVDTO>();
		
		lsObj.stream().map(item -> {
			lsObjDTO.add(mapear(item));
			return item;
		});
		
		return lsObjDTO;
	}
	
	public CadastroSegmentoRVDomain mapear(CadastroSegmentoRVDTO objDTO) {
		CadastroSegmentoRVDomain obj = new CadastroSegmentoRVDomain();
		obj.setAssessoria(objDTO.getAssessoria());
		obj.setIsSeguro(objDTO.getIsSeguro());
		obj.setNmSegmentoRv(objDTO.getNmSegmentoRv());
		obj.setNormal(objDTO.getNormal());
		obj.setObservacao(objDTO.getObservacao());
		return obj;
	}
}
