package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.BlocoRegraDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.domain.TipoRemuneracaoDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.exceptions.NaoEncontradoException;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.BlocoRegraRepository;

@Service
public class BlocoRegraServiceImpl extends GenericService<BlocoRegraDomain> {

	@Autowired
	BlocoRegraRepository blocoRegraRepository;
	
	@Autowired
	private CadastroSegmentoRVServiceImpl segmentoService;
	
	@Autowired
	private TipoRemuneracaoServiceImpl tipoRemuneracaoService;
	
	public BlocoRegraServiceImpl(PagingAndSortingRepository<BlocoRegraDomain, Long> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	
	public TipoRemuneracaoDomain buscarTipoRemuneracao(Long id){
		
		try {
			TipoRemuneracaoDomain tipoRemuneracaoDomain = tipoRemuneracaoService.findById(id);
			return tipoRemuneracaoDomain;
		} catch (NaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public CadastroSegmentoRVDomain buscarSegmento(Long id) {
		CadastroSegmentoRVDomain obj;
		try {
			obj = segmentoService.findById(id);
			return obj;
		} catch (NaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
