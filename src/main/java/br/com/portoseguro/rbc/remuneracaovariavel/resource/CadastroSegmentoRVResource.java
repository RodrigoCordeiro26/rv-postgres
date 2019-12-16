package br.com.portoseguro.rbc.remuneracaovariavel.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.Segmento.CadastroSegmentoRVDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.Segmento.SegmentoDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.exceptions.NaoEncontradoException;
import br.com.portoseguro.rbc.remuneracaovariavel.mappers.CadastroSegmentoRVMapper;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.CadastroSegmentoRVRepository;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.CadastroSegmentoRVServiceImpl;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/segmentos-rv")
@Api
public class CadastroSegmentoRVResource extends GenericResource {

	@Autowired
	CadastroSegmentoRVServiceImpl service;

	@Autowired
	CadastroSegmentoRVMapper mapper;

	@Autowired
	CadastroSegmentoRVRepository repo;
	
	@GetMapping
	public ResponseEntity<List<CadastroSegmentoRVDTO>> toList() {
		List<CadastroSegmentoRVDTO> lsDTO = mapper.mapear(service.findAll());
		return retornarSucesso(lsDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CadastroSegmentoRVDTO> find(@PathVariable(value = "id") Long id)
			throws NaoEncontradoException {
		CadastroSegmentoRVDTO objDTO = mapper.mapear(service.findById(id));
		if (objDTO == null)
			return retornarNaoEncontrado();
		return retornarSucesso(objDTO);
	}

	@PostMapping
	public ResponseEntity<CadastroSegmentoRVDTO> save(@RequestBody CadastroSegmentoRVDTO objDTO) throws ParseException {
		
		
		return retornarCriado(mapper.mapear(service.save(mapper.mapear(objDTO))));

	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestParam(value = "id") Long id) {
		try {
			service.delete(id);
			return retornarSucesso(null);
		} catch (Exception e) {
			e.printStackTrace();
			return retornarErro(null);
		}
	}

	@PutMapping
	public ResponseEntity<CadastroSegmentoRVDTO> update(@RequestBody CadastroSegmentoRVDTO objDTO)
			throws NaoEncontradoException, ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		sdf.setTimeZone (TimeZone.getTimeZone("GMT-03:00"));
		CadastroSegmentoRVDomain obj = service.findById(objDTO.getId());
		if (obj == null) {
			return retornarNaoEncontrado();
		}
		objDTO.setObservacao(obj.getObservacao());
		objDTO.setDataAtualizacao(sdf.format(new Date()));
		
		if(objDTO.getStatus().equalsIgnoreCase("inativo")) {
			obj.setDataAtualizacao(sdf.parse(objDTO.getDataAtualizacao()));
			obj.setObservacaoMudancaStatus(objDTO.getObservacaoMudancaStatus());
			obj.setStatus(false);
			return retornarSucesso(mapper.mapear(repo.save(obj)));
			
		}
		
		return retornarSucesso(mapper.mapear(service.update(mapper.mapear(objDTO))));

	}

	
	@GetMapping("/segmentos")
	public ResponseEntity<List<SegmentoDTO>> buscarSegmentoMinimo() {
		
		List<CadastroSegmentoRVDomain> lsCadastroSegmento = service.findAll();
		
		List<SegmentoDTO> lsSegmento = lsCadastroSegmento.stream().map(segmento->{
			return new SegmentoDTO(segmento.getId(), segmento.getNmSegmentoRV());
		}).collect(Collectors.toList());
		
		return retornarSucesso(lsSegmento);
	}
}