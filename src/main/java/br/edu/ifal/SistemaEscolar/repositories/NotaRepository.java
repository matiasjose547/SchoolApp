package br.edu.ifal.SistemaEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolar.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer>{

}
