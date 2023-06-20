package br.edu.ifal.SistemaEscolar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "disciplina")
public class Disciplina extends AbstractEntity{


	@Column(length = 200, nullable = false)
	private String nome;

	@ManyToMany
	private Set<Professor> professores;

	@ManyToMany
	private List<Aluno> alunos;

	@OneToMany
	private Set<Assunto> assuntos;

	@ManyToMany
	private Set<Curso> cursos;

	public Disciplina(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Disciplina{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", professores=" + professores +
				", alunos=" + alunos +
				", assuntos=" + assuntos +
				", cursos=" + cursos +
				", id=" + id +
				'}';
	}
}
