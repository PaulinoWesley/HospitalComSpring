package br.com.hospital.wesley.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;

public class Paciente {
	@Id
	private String cpf;
	@Column
	private String nome;
	@Column
	private LocalDate dataNascimento;

	public Paciente() {
	}

	public Paciente(String cpf, String nome, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
