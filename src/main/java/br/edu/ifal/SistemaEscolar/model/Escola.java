package br.edu.ifal.SistemaEscolar.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "escola")
public class Escola extends AbstractEntity{

	@Column(length = 200, nullable = false, name = "nome")
	private String nome;

	@OneToMany
	private Set<Curso> cursos;

	@OneToMany
	private Set<Professor> professores;

	public Escola(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Escola{" +
				"nome='" + nome + '\'' +
				", cursos=" + cursos +
				", professores=" + professores +
				", id=" + id +
				'}';
	}
}
