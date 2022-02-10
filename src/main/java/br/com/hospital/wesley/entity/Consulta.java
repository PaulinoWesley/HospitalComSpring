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

import br.com.hospital.wesley.dto.ConsultaParaCriarDto;
import lombok.Data;


@Entity
@Table(schema = "hospital")
@Data
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne //(cascade=CascadeType.ALL)
	@JoinColumn(name="medico")
	private Medico medico;
	
	@ManyToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="paciente")
	private Paciente paciente;
	
	@Column 
	private String descricaoReceita;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private LocalDateTime horarioConsulta;	
	
	public static Consulta of(ConsultaParaCriarDto dto) {
		var consulta = new Consulta();
		var medico = new Medico();
		medico.setCrm(dto.getCrm());
		var paciente = new Paciente();
		paciente.setCpf(dto.getCpf());
		
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setHorarioConsulta(dto.getHorarioConsulta());
		
		return consulta;
	}
}
