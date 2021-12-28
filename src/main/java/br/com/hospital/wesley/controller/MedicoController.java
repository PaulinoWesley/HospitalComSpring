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

import br.com.hospital.wesley.dto.MedicoFilterDto;
import br.com.hospital.wesley.entity.Medico;
import br.com.hospital.wesley.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	@Autowired
	MedicoRepository medicoRepository;
	
	@GetMapping
	public List<Medico> find(MedicoFilterDto filtro) {
		boolean passouNome = filtro.getNome() != null && !filtro.getNome().isEmpty();
		boolean passouCrm = filtro.getCrm() != null && !filtro.getCrm().isEmpty();
		
		if (passouNome && !passouCrm) {
			return medicoRepository.findByNomeContainingIgnoreCase(filtro.getNome());
		}
		if (passouCrm && !passouNome ) {
			return medicoRepository.findByCrmContainingIgnoreCase(filtro.getCrm());
		}
		if (passouNome && passouCrm ) {
			return medicoRepository.findByCrmContainingIgnoreCaseAndNomeContainingIgnoreCase(filtro.getCrm(), filtro.getNome());
		}
		return medicoRepository.findAll();
	}

	@GetMapping("/{crm}")
	public Medico byCrm(@PathVariable String crm) {
		return medicoRepository.findById(crm).get();
	}
	
	@PostMapping
	public Medico salvar(@RequestBody Medico medico) {
		medicoRepository.save(medico);
		return medico;
	}
	
	@PutMapping
	public Medico atualizar(@RequestBody Medico medico) {
		medicoRepository.save(medico);
		return medico;
	}
	
	@DeleteMapping("/{crm}")
	public Medico deletar(@PathVariable String crm) {
		Medico medico = medicoRepository.findByCrmContainingIgnoreCase(crm).get(0);
		medicoRepository.delete(medico);
		return medico;
	}
	
}
