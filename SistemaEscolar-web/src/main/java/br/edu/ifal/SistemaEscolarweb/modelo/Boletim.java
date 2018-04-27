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
	
}
