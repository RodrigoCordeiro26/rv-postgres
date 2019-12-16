package br.com.portoseguro.rbc.remuneracaovariavel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

import br.com.portoseguro.rbc.remuneracaovariavel.serviceImpl.DbService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	DbService dbService;
	
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
	
	
	
}
