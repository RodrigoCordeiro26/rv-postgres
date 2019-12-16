package br.com.portoseguro.rbc.remuneracaovariavel.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.IndicadoreProducaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.IndicadorProducaoDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.mappers.IndicadorProducaoMapper;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.IndicadorProducaoServiceImpl;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/indicador")
@Api
public class IndicadorProducaoResource extends GenericResource{

	@Autowired
	IndicadorProducaoServiceImpl indicadorService;
	
	@Autowired
	IndicadorProducaoMapper mapper;
	
	@PostMapping
	public ResponseEntity<IndicadoreProducaoDomain> save(@RequestBody IndicadoreProducaoDomain indicador) {
		return retornarSucesso(indicadorService.save(indicador));
	}
	
	@GetMapping
	public ResponseEntity<List<IndicadorProducaoDTO>> get(){
		return retornarSucesso(mapper.mapear(indicadorService.findAll()));
	}
}
