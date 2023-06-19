package br.edu.ifal.SistemaEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolar.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
