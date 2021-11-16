package br.com.hospital.wesley.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "hospital")
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;
	@Column
	private String medico;
	@Column
	private String paciente;
	@Column 
	private String descricaoReceita;
	@Column
	private LocalDateTime horarioConsulta;
	
	public Consulta() { }
	
	public Consulta(String medico, String paciente,
			String descricaoReceita, LocalDateTime horarioConsulta) {
		this.medico = medico;
		this.paciente = paciente;
		this.descricaoReceita = descricaoReceita;
		this.horarioConsulta = horarioConsulta;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}

	public LocalDateTime getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(LocalDateTime horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}
	
}
