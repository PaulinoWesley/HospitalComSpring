package br.com.hospital.wesley.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ConsultaParaCriarDto {
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime horarioConsulta;
	private String crm;
	private String cpf;
}
