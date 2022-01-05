package br.com.hospital.wesley.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospital.wesley.dto.ConsultaFilterDto;
import br.com.hospital.wesley.entity.Consulta;
import br.com.hospital.wesley.repository.ConsultaRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	@Autowired
	ConsultaRepository consultaRepository;
	
	@GetMapping
	public List<Consulta> findByFilter(ConsultaFilterDto filtro) {
		return consultaRepository.findByFilter(filtro);
	}
	
	@GetMapping("/{id}")
	public Consulta findByFilter(@PathVariable Integer id) {
		return consultaRepository.findById(id).get();
	}
	
	@PostMapping
	public Consulta salvar(@RequestBody Consulta consulta) {
		consultaRepository.save(consulta);
		return consulta;
	}
	
	@PutMapping
	public Consulta atualizar(@RequestBody Consulta consulta ) {
		consultaRepository.save(consulta);
		return consulta;
	}
	
	@DeleteMapping
	public Consulta deletar(@RequestBody Consulta consulta) {
		consultaRepository.delete(consulta);
		return consulta;
	}

}
