package br.com.hospital.wesley.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.wesley.repository.MedicoRepository;
import br.com.hospital.wesley.repository.PacienteRepository;

@Service
public class ServiceRepository {
	@Autowired
	MedicoRepository medicoRepository;
	
}
