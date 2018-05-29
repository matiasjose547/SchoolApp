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
	@Column(name = "numero_cadastro", length = 11)
	private Integer numeroCadastro;

	@Column(name = "nome", length = 200)
	private String nome;

	@Column(name = "cpf", length = 31)
	private String cpf;

	@Column(length = 80, name = "formacao")
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

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + ((formacao == null) ? 0 : formacao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroCadastro == null) ? 0 : numeroCadastro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (formacao == null) {
			if (other.formacao != null)
				return false;
		} else if (!formacao.equals(other.formacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroCadastro == null) {
			if (other.numeroCadastro != null)
				return false;
		} else if (!numeroCadastro.equals(other.numeroCadastro))
			return false;
		return true;
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

	@Override
	public String toString() {
		return "Professor [numeroCadastro=" + numeroCadastro + ", nome=" + nome + 
				", cpf=" + cpf + ", formacao="
				+ formacao + ", disciplinas=" + disciplinas + "]";
	}

	
}
