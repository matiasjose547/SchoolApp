package br.edu.ifal.SistemaEscolarweb.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolarweb.modelo.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer>{

}
