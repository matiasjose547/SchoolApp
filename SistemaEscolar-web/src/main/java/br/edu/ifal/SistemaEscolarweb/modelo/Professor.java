package br.edu.ifal.SistemaEscolarweb.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@Column(name = "numero_cadastro", length = 11, nullable = false)
	private Integer numeroCadastro;

	@Column(name = "nome", length = 200, nullable = false)
	private String nome;

	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;

	@Column(length = 80, nullable = false, name = "formacao")
	private String formacao;

	@ManyToMany
	private Set<Disciplina> disciplinas;

	public Professor() {

	}

	public Professor(String nome, String cpf, Integer numeroCadastro, String formacao) {
		this.numeroCadastro = numeroCadastro;
		this.formacao = formacao;
		this.nome = nome;
		this.cpf = cpf;
		disciplinas = new HashSet<>();
	}

	public Integer getNumeroCadastro() {
		return numeroCadastro;
	}

	public void setNumeroCadastro(Integer numeroCadastro) {
		this.numeroCadastro = numeroCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf != null) {
			this.cpf = cpf;
		}
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		if (disciplinas != null) {
			this.disciplinas = disciplinas;
		}
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		if (formacao != null) {
			this.formacao = formacao;
		}

	}

}
