package br.com.hospital.wesley.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(schema = "hospital")
@Data
public class Paciente {
	@Id
	private String cpf;

	@Column
	private String nome;

	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataNascimento;
}
