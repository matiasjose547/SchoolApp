package br.edu.ifal.SistemaEscolarweb.modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Pessoa {

	@Id
	@Column(length = 11, nullable = false, name = "cpf")
	private Integer numeroCadastro;

	@Column(length = 80, nullable = false, name = "formacao")
	private String formacao;

	@ManyToMany
	private Set<Disciplina> disciplinas;
	// Exclui o método enum e seus atributos

	
	
	public Professor() {
		
	}

	// Adicionado novo construtor
	public Professor(String nome, String cpf, Integer numeroCadastro, String formacao) {
		super(nome, cpf);
		this.numeroCadastro = numeroCadastro;
		this.formacao = formacao;
	}

	// aDicionados getters e setters de disciplinas

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
