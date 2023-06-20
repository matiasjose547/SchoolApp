package br.edu.ifal.SistemaEscolar.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "professor")
public class Professor extends AbstractEntity {

	private String matricula;
	@Column(name = "nome", length = 200)
	private String nome;

	@Column(name = "cpf", length = 11)
	private String cpf;

	@Column(length = 80, name = "formacao")
	private String formacao;

	@ManyToMany
	private Set<Disciplina> disciplinas;

	public Professor(String matricula, String nome, String cpf, String formacao) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.formacao = formacao;
	}

	@Override
	public String toString() {
		return "Professor{" +
				"numeroCadastro=" + matricula +
				", nome='" + nome + '\'' +
				", cpf='" + cpf + '\'' +
				", formacao='" + formacao + '\'' +
				", disciplinas=" + disciplinas +
				", id=" + id +
				'}';
	}
}
