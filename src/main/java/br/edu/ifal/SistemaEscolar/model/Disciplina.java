package br.edu.ifal.SistemaEscolar.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	private Integer id;

	@Column(length = 200, nullable = false)
	private String nome;

	@ManyToMany
	private Set<Professor> professores;

	@ManyToMany
	private Set<Aluno> alunos;

	@OneToMany
	private Set<Assunto> assuntos;

	@ManyToMany
	private Set<Curso> cursos;

	public Disciplina() {
		this.professores = new HashSet<>();
		this.alunos = new HashSet<>();
		this.assuntos = new HashSet<>();
		this.cursos = new HashSet<>();

	}

	

	public Disciplina(String nome) {
		super();
		this.nome = nome;
	}



	public Disciplina(String nome, Set<Professor> professor, Set<Aluno> alunos, Set<Assunto> assunto) {
		this.professores = new HashSet<>();
		this.alunos = new HashSet<>();
		this.assuntos = new HashSet<>();
		this.cursos = new HashSet<>();
		this.nome = nome;
		this.professores = professor;
		this.alunos = alunos;
		this.assuntos = assunto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result + ((assuntos == null) ? 0 : assuntos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((professores == null) ? 0 : professores.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (assuntos == null) {
			if (other.assuntos != null)
				return false;
		} else if (!assuntos.equals(other.assuntos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (professores == null) {
			if (other.professores != null)
				return false;
		} else if (!professores.equals(other.professores))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Assunto> getAssunto() {
		return assuntos;
	}

	public void setAssunto(Set<Assunto> assunto) {
		this.assuntos = assunto;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public void setProfessor(Set<Professor> professor) {
		this.professores = professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Professor> getProfessor() {
		return professores;
	}

	public void professor(Set<Professor> professor) {
		this.professores = professor;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> aluno) {
		this.alunos = aluno;
	}

	public void addAluno(Aluno aluno) {
		if (aluno != null) {
			this.alunos.add(aluno);
		}
	}

	public void removeAluno(Aluno aluno) {
		this.alunos.remove(aluno);
	}

	public void addProfessor(Professor professor) {
		if (professor != null) {
			this.professores.add(professor);
		}
	}

	public void removeProfessor(Professor professor) {
		this.professores.remove(professor);
	}
}
