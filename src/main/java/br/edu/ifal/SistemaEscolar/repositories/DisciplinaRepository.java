package br.edu.ifal.SistemaEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolar.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

	
}
