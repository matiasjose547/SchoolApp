package br.edu.ifal.SistemaEscolarweb.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
