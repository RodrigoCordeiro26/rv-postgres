package br.com.portoseguro.rbc.remuneracaovariavel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = {"br.com.portoseguro.rbc.remuneracaovariavel.repository"})
@EntityScan(basePackages = "br.com.portoseguro.rbc.remuneracaovariavel.domain")
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
public class RemuneracaoVariavelPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemuneracaoVariavelPostgresApplication.class, args);
	}

}
