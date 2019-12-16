package br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author rodrigocordeiro 17/10/2019
 * 
 */
@Component
public class OracleAPIGeneric<T> {

	private final String BASE_URL = "http://localhost:8034/api";
	
	public List<T> API(String endpoint, CrudRepository<T,Long> repository) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<List<T>> response = restTemplate.exchange(BASE_URL + endpoint, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<T>>() {
					});

			List<T> responseEntity = response.getBody();

			return responseEntity;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

}
