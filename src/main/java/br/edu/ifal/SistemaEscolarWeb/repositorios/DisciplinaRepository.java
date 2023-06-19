package br.edu.ifal.SistemaEscolarweb.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolarweb.modelo.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

	
}
