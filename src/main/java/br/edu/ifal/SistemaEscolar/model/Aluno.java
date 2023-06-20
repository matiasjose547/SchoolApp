package br.edu.ifal.SistemaEscolar.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno extends AbstractEntity {

	private String matricula;
	@Column(length = 100)
	private String nome;

	private String cpf;

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private LocalDate dataNascimento;

	@Column(length = 100, name = "nome_pai")
	private String nomePai;

	@Column(length = 100, name = "nome_mae")
	private String nomeMae;

	@ManyToMany
	private Set<Curso> cursos;

	@ManyToMany
	private Set<Disciplina> disciplinas;

	@OneToOne
	private Boletim boletim;

	public Aluno(String matricula, String nome, String cpf, LocalDate dataNascimento, String nomePai, String nomeMae) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
	}

	@Override
	public String toString() {
		return "Aluno{" +
				"matricula='" + matricula + '\'' +
				", nome='" + nome + '\'' +
				", cpf='" + cpf + '\'' +
				", dataNascimento='" + dataNascimento + '\'' +
				", nomePai='" + nomePai + '\'' +
				", nomeMae='" + nomeMae + '\'' +
				", cursos=" + cursos +
				", disciplinas=" + disciplinas +
				", boletim=" + boletim +
				", id=" + id +
				'}';
	}
}
