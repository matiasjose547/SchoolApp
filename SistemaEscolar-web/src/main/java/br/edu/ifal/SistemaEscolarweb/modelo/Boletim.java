package br.edu.ifal.SistemaEscolarweb.modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "boletim")
public class Boletim {
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@OneToMany
	private Set<Disciplina> disciplinas;
	
	@OneToMany
	private Set<Nota> notas;

	public Boletim() {
		super();
	}

	public Boletim(Integer id, Set<Disciplina> disciplinas, Set<Nota> notas) {
		super();
		this.id = id;
		this.disciplinas = disciplinas;
		this.notas = notas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}
	

	
	
}
