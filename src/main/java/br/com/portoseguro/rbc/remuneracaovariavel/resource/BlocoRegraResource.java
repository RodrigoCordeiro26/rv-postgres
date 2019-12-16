package br.com.portoseguro.rbc.remuneracaovariavel.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.BlocoRegraDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.IndicadoreProducaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.RegraDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.TipoRemuneracaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.regra.BlocoRegraDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.exceptions.NaoEncontradoException;
import br.com.portoseguro.rbc.remuneracaovariavel.mappers.RegraMapper;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.BlocoRegraServiceImpl;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.CadastroSegmentoRVServiceImpl;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.IndicadorProducaoServiceImpl;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.PeriodoMetaServiceImpl;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.RegraServiceImpl;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/regras")
@Api
public class BlocoRegraResource extends GenericResource {

	@Autowired
	private BlocoRegraServiceImpl blocoRegraService;
	@Autowired
	private CadastroSegmentoRVServiceImpl segmentoService;

	@Autowired
	private RegraMapper regraMapper;

	@Autowired
	private RegraServiceImpl regraService;

	@Autowired
	IndicadorProducaoServiceImpl indicadorProducaoService;

	@Autowired
	PeriodoMetaServiceImpl periodoService;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy hh:mm");

	@PostMapping
	private ResponseEntity<BlocoRegraDTO> save(@RequestBody(required = true) BlocoRegraDTO bloco)
			throws NaoEncontradoException {

		IndicadoreProducaoDomain indicadorBloco = indicadorProducaoService.nmIndicadorProd(bloco.getIndicadorTaxa());

		try {
			// Cria um bloco

			List<CadastroSegmentoRVDomain>  lsSegmento = bloco.getLsSegmento().stream().map(segmento ->{
				CadastroSegmentoRVDomain segmentoDomain = blocoRegraService.buscarSegmento(segmento.getId());
				if(segmentoDomain != null)
					return segmentoDomain;
				return null;
				
			}).collect(Collectors.toList());
			
			List<TipoRemuneracaoDomain>  lsTipoRemuneracao = bloco.getLsTipoRemuneracao().stream().map(tipoRemuneracao ->{
				TipoRemuneracaoDomain tpRemuneracao = blocoRegraService.buscarTipoRemuneracao(tipoRemuneracao.getId());
				if(tpRemuneracao != null)
					return tpRemuneracao;
				return null;
			}).collect(Collectors.toList());


			BlocoRegraDomain blocoDomain = regraMapper.mapear(bloco, bloco.getIndicadorTaxa(), null);

			blocoDomain = blocoRegraService.save(blocoDomain);

			blocoDomain.getLsSegmento().addAll(lsSegmento);
			blocoDomain.getLsTipoRemuneracao().addAll(lsTipoRemuneracao);
			blocoRegraService.save(blocoDomain);

			List<RegraDomain> lsRegra = regraMapper.mapearRegra(bloco.getLsRegra(), blocoDomain);
			regraService.saveAll(lsRegra);

			return retornarCriado(regraMapper.mapear(blocoDomain, lsRegra));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return retornarErro(null);
	}

	@GetMapping
	public ResponseEntity<List<BlocoRegraDTO>> findAll() {
		List<BlocoRegraDomain> lsbloco = blocoRegraService.findAll();

		List<BlocoRegraDTO> lsBlocoDTO = lsbloco.stream().map(x -> {
			List<RegraDomain> lsRegras = regraService.buscaIdBloco(x.getId());
			return regraMapper.mapear(x, lsRegras);
		}).collect(Collectors.toList());

		return retornarSucesso(lsBlocoDTO);

	}

//	@PutMapping
//	public ResponseEntity<BlocoRegraDTO> update(@RequestBody(required = true) BlocoRegraDTO blocoDTO) throws NaoEncontradoException, ParseException{
//		Date dataDeAtualizacao = new Date();
//		String dtFormatada = sdf.format(dataDeAtualizacao);
//		BlocoRegraDomain bloco = blocoRegraService.findById(blocoDTO.getId());
//		
//		if(bloco != null) {
//			List<RegraDomain> lsRegrasOLD = regraService.buscaIdBloco(bloco.getId());
//			
//			if(!lsRegrasOLD.isEmpty()) {
//				for (RegraDomain regraDomain : lsRegrasOLD) {
//					regraService.delete(regraDomain.getId());
//				}
//				List<RegraDomain> lsRegra = regraMapper.mapearRegra(blocoDTO.getLsRegra(), bloco);
//				regraService.saveAll(lsRegra);
//				blocoRegraService.update(regraMapper.mapear(blocoDTO, blocoDTO.getIndicadorTaxa(), bloco.getId()));
//				return retornarSucesso(regraMapper.mapear(regraMapper.mapear(blocoDTO, blocoDTO.getIndicadorTaxa(), bloco.getId()),regraService.saveAll(lsRegra)));
//			}
//
//		}
//		return retornarErro(null);
//		 
//	}

	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam(name = "id") Long id) throws NaoEncontradoException {
		BlocoRegraDomain bloco = blocoRegraService.findById(id);
		List<RegraDomain> lsRegrasOLD = regraService.buscaIdBloco(bloco.getId());
		if (!lsRegrasOLD.isEmpty()) {
			for (RegraDomain regraDomain : lsRegrasOLD) {
				regraService.delete(regraDomain.getId());
			}

		}
		blocoRegraService.delete(id);

		return retornarSucesso(true);
	}

}
