package br.edu.ifal.SistemaEscolar.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "boletim")
public class Boletim extends AbstractEntity {

	@OneToMany
	private Set<Disciplina> disciplinas;
	
	@OneToMany
	private Set<Nota> notas;

	@Override
	public String toString() {
		return "Boletim{" +
				"disciplinas=" + disciplinas +
				", notas=" + notas +
				", id=" + id +
				'}';
	}
}
