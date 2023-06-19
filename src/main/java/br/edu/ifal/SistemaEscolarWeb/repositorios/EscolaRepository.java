package br.edu.ifal.SistemaEscolarweb.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolarweb.modelo.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Integer>{
	
	

}
