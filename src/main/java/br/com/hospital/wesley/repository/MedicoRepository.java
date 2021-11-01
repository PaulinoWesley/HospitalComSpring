package br.com.hospital.wesley.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hospital.wesley.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, String> {

	List<Medico> findByNomeContainingIgnoreCase(String nome);

	List<Medico> findByCrmContainingIgnoreCase(String crm);

	List<Medico> findByCrmContainingIgnoreCaseAndNomeContainingIgnoreCase(String crm, String nome);

	
}
