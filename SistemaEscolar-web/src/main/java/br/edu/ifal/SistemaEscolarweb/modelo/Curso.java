package br.edu.ifal.SistemaEscolarweb.modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	private Integer codigo;
	
	@Column(length = 50, nullable = false, name = "nome")
	private String nome;
	
	@OneToMany
	private Set<Aluno> aluno;
	
	@OneToMany
	private Set<Disciplina> disciplina;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(Set<Aluno> aluno) {
		this.aluno = aluno;
	}

	public Set<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Set<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
	

	public void addDisciplina(Disciplina disciplina) {
		if (disciplina != null) {
			this.disciplina.add(disciplina);
		}
	}

	public void removeDisciplina(Disciplina disciplina) {
		this.disciplina.remove(disciplina);
	}

}
