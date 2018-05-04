package br.edu.ifal.SistemaEscolarweb.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	private Integer matricula;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(length = 8, nullable = false, name = "data_nascimento")
	private String dataNascimento;

	@Column(length = 200, nullable = true, name = "nome_pai")
	private String nomePai;

	@Column(length = 200, nullable = true, name = "nome_mae")
	private String nomeMae;

	@ManyToMany
	private Set<Curso> cursos;

	@ManyToMany
	private Set<Disciplina> disciplinas;

	@OneToOne
	private Boletim boletim;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
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
		Aluno other = (Aluno) obj;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		return true;
	}

	public Aluno() {
		boletim = new Boletim();
		disciplinas = new HashSet<>();
		cursos = new HashSet<>();
	}

	public Aluno(Integer matricula, String nome, String cpf) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		boletim = new Boletim();
		disciplinas = new HashSet<>();
		cursos = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public Boletim getBoletim() {
		return boletim;
	}

	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}

	public Integer getMatricula() { // retorna a matricula
		return matricula;
	}

	public String getDataNascimento() { // retorna a data de nascimento
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) { // altera a data de nascimento
		if (dataNascimento != null) {
			this.dataNascimento = dataNascimento;
		}
	}

	public String getNomePai() { // retorna o nome do pai
		return nomePai;
	}

	public void setNomePai(String nomePai) { // altera o nome do pai
		if (nomePai != null) {
			this.nomePai = nomePai;
		}
	}

	public String getNomeMae() { // retorna o nome do mae
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) { // altera o nome do mae
		if (nomeMae != null) {
			this.nomeMae = nomeMae;
		}
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void adicionarDisciplina(Disciplina d) {
		if (d != null) {
			this.disciplinas.add(d);
		}
	}

	public void removerDisciplina(Disciplina d) {
		if (d != null) {
			this.disciplinas.remove(d);
		}
	}

}
