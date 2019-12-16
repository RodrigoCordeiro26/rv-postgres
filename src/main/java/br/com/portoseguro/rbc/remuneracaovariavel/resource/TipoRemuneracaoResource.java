package br.com.portoseguro.rbc.remuneracaovariavel.resource;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.TipoRemuneracaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.TipoRemuneracao.TipoRemuneracaoDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.TipoRemuneracao.TipoRemuneracaoDTOMin;
import br.com.portoseguro.rbc.remuneracaovariavel.exceptions.NaoEncontradoException;
import br.com.portoseguro.rbc.remuneracaovariavel.mappers.TipoRemuneracaoMapper;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.TipoRemuneracaoServiceImpl;

@RestController
@RequestMapping("/tipo-remuneracao")
public class TipoRemuneracaoResource extends GenericResource {

	@Autowired
	private TipoRemuneracaoServiceImpl service;

	@Autowired
	private TipoRemuneracaoMapper mapper;

	@PostMapping()
	public ResponseEntity<TipoRemuneracaoDTO> save(@RequestBody TipoRemuneracaoDTO tipoRemuneracaoDTO)
			throws ParseException, NaoEncontradoException {
		
		TipoRemuneracaoDomain tipoRemuneracao = service.findById(tipoRemuneracaoDTO.getId());
		
		if(tipoRemuneracao != null) {
			return retornarNaoAlterado();
		}
		
		return retornarCriado(mapper.mapear(service.save(mapper.mapearPost(tipoRemuneracaoDTO))));
	}

	@GetMapping()
	public ResponseEntity<List<TipoRemuneracaoDTO>> toList() {
		return retornarSucesso(mapper.mapear(service.findAll()));
	}

	@PutMapping()
	public ResponseEntity<TipoRemuneracaoDTO> update(@RequestBody TipoRemuneracaoDTO tipoRemuneracaoDTO)
			throws NaoEncontradoException {
		TipoRemuneracaoDomain tipoRemuneracaoDomain = service.findById(tipoRemuneracaoDTO.getId());

		if (tipoRemuneracaoDomain != null) {
			try {
				
				TipoRemuneracaoDomain updateEntity = mapper.mapearPut(tipoRemuneracaoDTO);
				
				updateEntity.setDtInclusao(tipoRemuneracaoDomain.getDtInclusao());
				
				return retornarSucesso(mapper.mapear(service.update(updateEntity)));
			} catch (Exception e) {
				return retornarErro(null);
			}
		}
		
		return retornarErro(null);

	}

	@GetMapping("/dto")
	public ResponseEntity<List<TipoRemuneracaoDTOMin>> getTipoRemuneracao(){
		return retornarSucesso(mapper.mapearDTOMinificado(service.findAll()));
	}
}
