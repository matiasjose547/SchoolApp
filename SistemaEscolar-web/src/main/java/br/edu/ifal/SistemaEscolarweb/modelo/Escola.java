package br.edu.ifal.SistemaEscolarweb.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "escola")
public class Escola {
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	private Integer codigo;
	@Column(length = 200, nullable = false, name = "nome")
	private String nome;
	@OneToMany
	private Set<Curso> cursos;
	@OneToMany
	private Set<Professor> professores;

	public Escola() {
		super();
	}

	public Escola(Integer codigo, String nome, Set<Curso> cursos, Set<Professor> professores) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cursos = cursos;
		this.professores = professores;
	}

	public Escola(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		if (codigo != null) {
			this.codigo = codigo;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		if (cursos != null) {
			this.cursos = cursos;
		}
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Professor> professores) {
		if (professores != null) {
			this.professores = professores;
		}
	}

}
