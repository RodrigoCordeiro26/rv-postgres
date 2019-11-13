package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import br.com.portoseguro.rbc.remuneracaovariavel.domain.CadastroSegmentoRVDomain;
import br.com.portoseguro.rbc.remuneracaovariavel.repository.CadastroSegmentoRVRepository;

@Service
public class CadastroSegmentoRVServiceImpl extends GenericService<CadastroSegmentoRVDomain>{
	@Autowired
	CadastroSegmentoRVRepository repo;
	
	public CadastroSegmentoRVServiceImpl(PagingAndSortingRepository<CadastroSegmentoRVDomain, Long> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
//	public List<CadastroSegmentoRVDomain> findByFilter(String filterName, String value) {
//			switch (filterName) {
//			case "Todos":
//				return repo.findAll();
//			case "Segmento":
//				if(value.length() > 1) {
//					return repo.findByNmSegmentoRVContainingIgnoreCase(value);
//				}
//			case "Tipo Produto":
//				return repo.findByNormal(Boolean.parseBoolean(value));
//			case "Assessoria":
//				return repo.findByAssessoria(Boolean.parseBoolean(value));
//			default:
//				return Collections.emptyList();
//			}
//			
//			
//		
//	}
	public CadastroSegmentoRVDomain findByFilter(String filterName, Long value) {
		
			Optional<CadastroSegmentoRVDomain> obj = repo.findById(value);
			return obj.orElse(null);
		
	}
	
}
