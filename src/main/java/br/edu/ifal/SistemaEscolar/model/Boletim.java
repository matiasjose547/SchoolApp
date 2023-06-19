package br.edu.ifal.SistemaEscolar.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
