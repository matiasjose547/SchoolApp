package br.edu.ifal.SistemaEscolarweb.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolarweb.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
