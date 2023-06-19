package br.edu.ifal.SistemaEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolar.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
