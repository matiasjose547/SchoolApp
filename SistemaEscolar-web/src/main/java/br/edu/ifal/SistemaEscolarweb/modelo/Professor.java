package br.edu.ifal.SistemaEscolarweb.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor extends Pessoa{

	@Id
	@Column(length = 11, nullable = false, name = "cpf")
	private Integer numeroCadastro;

	@Column(length = 80, nullable=false, name = "formacao")
	private String formacao;
	@Column(name = "tipo_professor", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoProfessor tipoProfessor;

	public enum TipoProfessor{
		SUBSTITUTO,
		EFETIVO,
	}
	
	public Professor() {
		super();
	}

	
	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		if (formacao != null) {
			this.formacao = formacao;
		}

	}

	public TipoProfessor getTipoProfessor() {
		return tipoProfessor;
	}

	public void setTipoProfessor(TipoProfessor tipoProfessor) {
		this.tipoProfessor = tipoProfessor;
	}


}
