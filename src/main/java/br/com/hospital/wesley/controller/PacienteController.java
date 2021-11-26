package br.com.hospital.wesley.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospital.wesley.dto.PacienteFilterDto;
import br.com.hospital.wesley.entity.Paciente;
import br.com.hospital.wesley.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	PacienteRepository pacienteRepository;

	@GetMapping
	public List<Paciente> findByFilter(PacienteFilterDto filtro) {
		return pacienteRepository.findByFilter(filtro);
	}
	
	@GetMapping("/{cpf}")
	public Paciente findByCpf(@PathVariable String cpf) {
		return pacienteRepository.findByCpf(cpf);
	}
	
	@PostMapping
	public Paciente salvar(@RequestBody Paciente paciente) {
		pacienteRepository.save(paciente); 
		return paciente;
	}
	
	@PutMapping
	public Paciente atualizar(@RequestBody Paciente paciente) {
		pacienteRepository.save(paciente);
		return paciente;
	}
	
	@DeleteMapping
	public Paciente deletar(@RequestBody Paciente paciente) {
		pacienteRepository.delete(paciente);
		return paciente;
	}
		
}
