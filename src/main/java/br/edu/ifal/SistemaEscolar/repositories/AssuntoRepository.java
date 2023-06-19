package br.edu.ifal.SistemaEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolar.model.Assunto;

public interface AssuntoRepository extends JpaRepository<Assunto, Integer> {

}
