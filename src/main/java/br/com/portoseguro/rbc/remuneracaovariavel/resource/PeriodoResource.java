package br.com.portoseguro.rbc.remuneracaovariavel.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.PeriodoMetaDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.PeriodoMetaServiceImpl;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/periodo")
@Api
public class PeriodoResource extends GenericResource{

	@Autowired
	PeriodoMetaServiceImpl periodoService;
	
	@PostMapping
	public ResponseEntity<PeriodoMetaDomain> save(@RequestBody PeriodoMetaDomain periodo) {
		return retornarSucesso(periodoService.save(periodo));
	}
	
}
