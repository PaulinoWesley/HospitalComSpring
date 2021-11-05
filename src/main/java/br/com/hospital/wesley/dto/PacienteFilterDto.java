package br.com.hospital.wesley.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PacienteFilterDto {
	String cpf;
	String nome;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	LocalDate dataNascimento;
}
