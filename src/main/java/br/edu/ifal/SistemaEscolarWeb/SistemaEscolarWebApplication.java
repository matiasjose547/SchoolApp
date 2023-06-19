package br.edu.ifal.SistemaEscolarweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"br.edu.ifal.SistemaEscolarWeb.Controller", "br.edu.ifal.SistemaEscolarweb.rest", "br.edu.ifal.SistemaEscolarweb.*"})
public class SistemaEscolarWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaEscolarWebApplication.class, args);
	}
}
