package br.com.hospital.wesley.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema = "hospital")
@Data
public class Medico {
	@Id
	private String crm;

	@Column
	private String nome;
}
