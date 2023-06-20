package br.edu.ifal.SistemaEscolar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nota")
public class Nota extends AbstractEntity{

	@Column(length = 2, scale = 2, nullable = true, name = "valor")
	private double valor;

	@Override
	public String toString() {
		return "Nota{" +
				"valor=" + valor +
				", id=" + id +
				'}';
	}
}
