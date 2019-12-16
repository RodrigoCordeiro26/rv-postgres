package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.PeriodoMetaDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.TipoRemuneracaoDomain;

@Service
public class DbService {

	@Autowired
	private CadastroSegmentoRVServiceImpl segmentoService;
	
	@Autowired 
	private PeriodoMetaServiceImpl periodoService;
	
	@Autowired
	private TipoRemuneracaoServiceImpl tipoRemuneracaoServiceImpl;
	
	
	public void instantiateTestDatabase() {
		
		CadastroSegmentoRVDomain segmento1 = new CadastroSegmentoRVDomain(null, "Segmento 1", true, "segmento 1", false, true, true, true, false, null, new Date());
		CadastroSegmentoRVDomain segmento2 = new CadastroSegmentoRVDomain(null, "Segmento 2", true, "segmento 1", false, true, true, true, false, null, new Date());
		CadastroSegmentoRVDomain segmento3 = new CadastroSegmentoRVDomain(null, "Segmento 3", true, "segmento 1", false, true, true, true, false, null, new Date());

	
		
		PeriodoMetaDomain periodo1 = new PeriodoMetaDomain(null, "Mês Atual", false, false, true, false, false, true);
		PeriodoMetaDomain periodo2 = new PeriodoMetaDomain(null, "Mês Anterior", false, false, false, true, false, true);
		PeriodoMetaDomain periodo3 = new PeriodoMetaDomain(null, "Acumulado do ano", true, false, false, false, false, true);
		PeriodoMetaDomain periodo4 = new PeriodoMetaDomain(null, "Ano anterior", false, true, false, false, false, true);

	
	
		
		
		TipoRemuneracaoDomain tpRemun1 = new TipoRemuneracaoDomain(null, "Campanha", new Date(), null, "rodrigo");
		TipoRemuneracaoDomain tpRemun2 = new TipoRemuneracaoDomain(null, "Gratificação", new Date(), null, "rodrigo");
		TipoRemuneracaoDomain tpRemun3 = new TipoRemuneracaoDomain(null, "Assessoria", new Date(), null, "rodrigo");
		TipoRemuneracaoDomain tpRemun4 = new TipoRemuneracaoDomain(null, "Participação nos Lucros", new Date(), null, "rodrigo");
		TipoRemuneracaoDomain tpRemun5 = new TipoRemuneracaoDomain(null, "Remuneração Variável", new Date(), null, "rodrigo");
	
		
		
		segmentoService.saveAll(Arrays.asList(segmento1, segmento2, segmento3));
		periodoService.saveAll(Arrays.asList(periodo1, periodo2, periodo3, periodo4));
		tipoRemuneracaoServiceImpl.saveAll(Arrays.asList(tpRemun1,tpRemun2,tpRemun3,tpRemun4,tpRemun5));
		
		
		
		
		
		
		
	
	
	}

}
