package br.com.fiap.primeira_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "API de Livros", version = "0.0.1", description = "Exemplo de API RESTful da turma 2TDSPC"))
public class PrimeiraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiraApiApplication.class, args);
	}

}
