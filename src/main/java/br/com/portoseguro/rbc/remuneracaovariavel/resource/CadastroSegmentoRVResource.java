package br.com.portoseguro.rbc.remuneracaovariavel.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.CadastroSegmentoRVDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.exceptions.NaoEncontradoException;
import br.com.portoseguro.rbc.remuneracaovariavel.mappers.CadastroSegmentoRVMapper;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.CadastroSegmentoRVServiceImpl;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/segmentos-rv")
@Api
public class CadastroSegmentoRVResource extends GenericResource{

	@Autowired
	CadastroSegmentoRVServiceImpl service;
	
	@Autowired
	CadastroSegmentoRVMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<CadastroSegmentoRVDTO>> toList(){
		return retornarSucesso(mapper.mapear(service.findAll()));
	}
	
	@PostMapping
	public ResponseEntity<CadastroSegmentoRVDTO> save(@RequestBody CadastroSegmentoRVDTO objDTO){
		return retornarCriado(mapper.mapear(service.save(mapper.mapear(objDTO))));
		
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestParam(value="id") Long id){
		try {
			service.delete(id);
			return retornarSucesso(null);
		} catch (Exception e) {
			e.printStackTrace();
			return retornarErro(null);
		}
	}
	
	@PutMapping
	public ResponseEntity<CadastroSegmentoRVDTO> update(@RequestBody CadastroSegmentoRVDTO objDTO) throws NaoEncontradoException{
		CadastroSegmentoRVDomain obj = service.findById(objDTO.getId());
		if(obj == null)
			return retornarNaoEncontrado();
		return retornarSucesso(mapper.mapear(service.update(mapper.mapear(objDTO))));
		
	}
}
