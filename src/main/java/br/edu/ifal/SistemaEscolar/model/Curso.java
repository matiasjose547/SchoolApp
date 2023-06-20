package br.edu.ifal.SistemaEscolar.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "curso")
public class Curso extends AbstractEntity {
	@Column(length = 50, nullable = false, name = "nome")
	private String nome;
	
	@ManyToMany
	private Set<Aluno> aluno;
	
	@ManyToMany
	private Set<Disciplina> disciplina;

	@Override
	public String toString() {
		return "Curso{" +
				"nome='" + nome + '\'' +
				", aluno=" + aluno +
				", disciplina=" + disciplina +
				", id=" + id +
				'}';
	}
}
