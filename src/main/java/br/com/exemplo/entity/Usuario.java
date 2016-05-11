package br.com.exemplo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity<Long> {

	private static final long serialVersionUID = -5456646318097620934L;

	private String nome;

	public Usuario() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}