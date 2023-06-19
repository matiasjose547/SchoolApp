package br.edu.ifal.SistemaEscolar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "nota")
public class Nota {

	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	private Integer id;

	@Column(length = 2, scale = 2, nullable = true, name = "valor")
	private double valor;

	
	public Nota(Integer id, double valor) {
		super();
		this.id = id;
		this.valor = valor;
	}

	public Nota() {
		super();
	}

	public Nota(double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
