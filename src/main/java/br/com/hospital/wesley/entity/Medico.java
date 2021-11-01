package br.com.hospital.wesley.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "hospital")
public class Medico {
	@Id
	private String crm;

	@Column
	private String nome;

	public Medico() {
	}

	public Medico(String crm, String nome) {
		this.crm = crm;
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
