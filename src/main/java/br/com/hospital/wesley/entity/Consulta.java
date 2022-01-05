package br.com.hospital.wesley.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Entity
@Table(schema = "hospital")
@Data
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="medico")
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="paciente")
	private Paciente paciente;
	
	@Column 
	private String descricaoReceita;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd hh:mm")
	private LocalDateTime horarioConsulta;	
}
