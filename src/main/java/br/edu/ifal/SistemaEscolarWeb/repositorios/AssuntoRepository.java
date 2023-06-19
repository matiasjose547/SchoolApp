package br.edu.ifal.SistemaEscolarweb.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolarweb.modelo.Assunto;

public interface AssuntoRepository extends JpaRepository<Assunto, Integer> {

}
