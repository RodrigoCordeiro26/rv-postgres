package br.com.portoseguro.rbc.remuneracaovariavel.mappers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.BlocoRegraDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.IndicadoreProducaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.PeriodoMetaDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.RegraDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.TipoRemuneracaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.enums.TipoAgravo;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.regra.BlocoRegraDTO;
import br.com.portoseguro.rbc.remuneracaovariavel.dto.regra.RegraDTOGet;
import br.com.portoseguro.rbc.remuneracaovariavel.exceptions.NaoEncontradoException;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.IndicadorProducaoServiceImpl;
import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.PeriodoMetaServiceImpl;

@Component
public class RegraMapper {

	@Autowired
	IndicadorProducaoServiceImpl indicadorService;

	@Autowired
	PeriodoMetaServiceImpl periodoService;
	
	@Autowired
	CadastroSegmentoRVMapper segmentoMapper;
	
	@Autowired
	TipoRemuneracaoMapper tipoRemuneracaoMapper;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
	private String usuarioSistema = System.getProperty("user.name");

	public RegraDomain mapear(RegraDTOGet x, IndicadoreProducaoDomain indicador, BlocoRegraDomain bloco,
			PeriodoMetaDomain periodo) {
		RegraDomain obj = new RegraDomain();

		obj.setBlocoRegra(bloco);
		obj.setIndicadorProducao(indicador != null ? indicador : null);
		obj.setPeriodo(periodo);
		obj.setTpAgravo(x.getAgravo());
		obj.setValorMaximo(converterValor(x.getValorMaximo(), x.getAgravo()));
		obj.setValorMinimo(converterValor(x.getValorMinimo(), x.getAgravo()));
		obj.setPesoRegra(converterValor(x.getPesoRegra(), x.getAgravo()));

		return obj;
	}

	public RegraDTOGet mapear(RegraDomain regra) {
		RegraDTOGet objDTO = new RegraDTOGet();

		objDTO.setId(regra.getId());
		objDTO.setAgravo(regra.getTpAgravo());
		objDTO.setIndicadorRegra(regra.getIndicadorProducao().getNmIndicadorProd());
		objDTO.setPeriodo(regra.getPeriodo().getNmPeriodo());
		objDTO.setValorMaximo(regra.getValorMaximo().toString());
		objDTO.setValorMinimo(regra.getValorMinimo().toString());
		objDTO.setPesoRegra(regra.getPesoRegra().toString());

		return objDTO;
	}

	public BlocoRegraDTO mapear(BlocoRegraDomain blocoRegra, List<RegraDomain> lsRegraDomain) {
		BlocoRegraDTO objDTO = new BlocoRegraDTO();

		objDTO.setAgravoTaxa(blocoRegra.getAgravoTaxa());
		objDTO.setId(blocoRegra.getId());
		objDTO.setIndicadorTaxa(blocoRegra.getIndicadorTaxa());
		objDTO.setLsRegra(mapear(lsRegraDomain));
		objDTO.setValorTaxa(blocoRegra.getValorTaxa().toString());
		objDTO.setBlocoObrigatorio(blocoRegra.getObrigatorio());
		objDTO.setIndcProporcionalidade(blocoRegra.getProporcional());
		objDTO.setLsSegmento(segmentoMapper.mapearMinificado(new  ArrayList<>(blocoRegra.getLsSegmento())));
		objDTO.setLsTipoRemuneracao(tipoRemuneracaoMapper.mapearDTOMinificado(new ArrayList<>(blocoRegra.getLsTipoRemuneracao())));
		return objDTO;

	}

	public BlocoRegraDomain mapear(BlocoRegraDTO blocoRegraDTO, String indicadorTaxa, Long idBloco) throws ParseException {
		BlocoRegraDomain bloco = new BlocoRegraDomain();
		String dataAtual = sdf.format(new Date());
		bloco.setId(idBloco);
		bloco.setAgravoTaxa(blocoRegraDTO.getAgravoTaxa());
		bloco.setDtAlteracao(sdf.parse(dataAtual));
		bloco.setIndicadorTaxa(indicadorTaxa);
		bloco.setUsuarioAlteracao(usuarioSistema);
		bloco.setValorTaxa(converterValorTaxa(blocoRegraDTO.getValorTaxa(), blocoRegraDTO.getAgravoTaxa()));
		bloco.setObrigatorio(blocoRegraDTO.getBlocoObrigatorio());
		bloco.setProporcional(blocoRegraDTO.getIndcProporcionalidade());

		return bloco;
	}

	public List<RegraDTOGet> mapear(List<RegraDomain> lsRegras) {
		List<RegraDTOGet> lsRegrasDTO = lsRegras.stream().map(x -> {
			return mapear(x);
		}).collect(Collectors.toList());

		return lsRegrasDTO;
	}

	public List<RegraDomain> mapearRegra(List<RegraDTOGet> list, BlocoRegraDomain bloco) throws NaoEncontradoException {
		List<RegraDomain> lsRegras = list.stream().map(x -> {
			IndicadoreProducaoDomain indicadorRegra = null;
			PeriodoMetaDomain periodo = null;
			indicadorRegra = indicadorService.nmIndicadorProd(x.getIndicadorRegra());
			periodo = periodoService.findByNmPeriodo(x.getPeriodo());

			return mapear(x, indicadorRegra, bloco, periodo);
		}).collect(Collectors.toList());

		return lsRegras;
	}

	private BigDecimal converterValor(String valor, String agravo) {
		
		if (valor != null) {
			
			if(TipoAgravo.toEnum(agravo).equals(TipoAgravo.PORCENTAGEM)) {
				
				if(valor.contains(".") || valor.length() == 1) {
					return new BigDecimal(valor);
				}
				StringBuilder stringBuilder = new StringBuilder(valor);
				
				stringBuilder.insert(valor.length() - 2, ".");
				return new BigDecimal(stringBuilder.toString());
			}else {
				return new BigDecimal(valor);
			}
		}

		return BigDecimal.ZERO;
	}

	private BigDecimal converterValorTaxa(String valorTaxa, String agravoTaxa) {
		
		if (valorTaxa != null) {
			if(valorTaxa.contains(".")) {
				return new BigDecimal(valorTaxa);
			}
			if(TipoAgravo.toEnum(agravoTaxa).equals(TipoAgravo.PORCENTAGEM)) {
				StringBuilder stringBuilder = new StringBuilder(valorTaxa);
				stringBuilder.insert(valorTaxa.length() - 3, ".");
				return new BigDecimal(stringBuilder.toString());
			}else {
				return new BigDecimal(valorTaxa);
			}
		}

		return BigDecimal.ZERO;
	}

}
