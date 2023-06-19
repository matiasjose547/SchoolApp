package br.edu.ifal.SistemaEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolar.model.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Integer>{
	
	

}
