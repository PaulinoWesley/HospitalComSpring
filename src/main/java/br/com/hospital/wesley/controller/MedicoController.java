package br.com.hospital.wesley.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospital.wesley.dto.MedicoFilterDto;
import br.com.hospital.wesley.entity.Medico;
import br.com.hospital.wesley.repository.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	@Autowired
	MedicoRepository medicoRespository;
	
	@GetMapping
	public List<Medico> find(MedicoFilterDto filtro) {
		boolean passouNome = filtro.getNome() != null && !filtro.getNome().isEmpty();
		boolean passouCrm = filtro.getCrm() != null && !filtro.getCrm().isEmpty();
		
		if (passouNome && !passouCrm) {
			return medicoRespository.findByNomeContainingIgnoreCase(filtro.getNome());
		}
		if (passouCrm && !passouNome ) {
			return medicoRespository.findByCrmContainingIgnoreCase(filtro.getCrm());
		}
		if (passouNome && passouCrm ) {
			return medicoRespository.findByCrmContainingIgnoreCaseAndNomeContainingIgnoreCase(filtro.getCrm(), filtro.getNome());
		}
		return medicoRespository.findAll();
	}

	@GetMapping("/{crm}")
	public Medico byCrm(@PathVariable String crm) {
		return medicoRespository.findById(crm).get();
	}
}
