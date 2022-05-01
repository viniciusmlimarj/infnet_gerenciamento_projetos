package br.com.vinicius.infnet.trabalho.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Perfil")
public class Perfil {

	@Id
	private Integer id;
	private String nome;
	
	public Perfil() {}
	
	public Perfil(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public boolean isAdministrador() {
		return id != null && id.equals(1);
	}
	
	public boolean isGerente() {
		return id != null && id.equals(2);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}