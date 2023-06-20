package br.edu.ifal.SistemaEscolar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_assunto")
public class Assunto extends AbstractEntity{

	@Column(length = 80, name = "nome_assunto")
	private String nome;

	@Column(length = 200, name = "descricao")
	private String descricao;

	@Override
	public String toString() {
		return "Assunto{" +
				"nome='" + nome + '\'' +
				", descricao='" + descricao + '\'' +
				", id=" + id +
				'}';
	}
}
