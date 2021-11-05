package br.com.hospital.wesley.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.hospital.wesley.dto.PacienteFilterDto;
import br.com.hospital.wesley.entity.Paciente;

public interface PacienteRepository  extends JpaRepository<Paciente, String>{

	@Query(value = "SELECT p from Paciente p "
			+ "WHERE "
			+ "	(:#{#filtro.cpf} IS NULL OR p.cpf like :#{#filtro.cpf} + '%') "
			+ "	AND (:#{#filtro.nome} IS NULL OR p.nome LIKE '%' + :#{#filtro.nome} + '%') "
			+ "	AND (:#{#filtro.dataNascimento} IS NULL OR p.dataNascimento = :#{#filtro.dataNascimento})")
	List<Paciente> findByFilter(@Param("filtro") PacienteFilterDto filtro);
	
	
}
