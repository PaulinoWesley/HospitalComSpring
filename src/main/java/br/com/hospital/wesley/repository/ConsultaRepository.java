package br.com.hospital.wesley.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.hospital.wesley.dto.ConsultaFilterDto;
import br.com.hospital.wesley.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

	@Query(value = "SELECT c from Consulta c "
			+ "WHERE "
			+ "	(:#{#filtro.paciente} IS NULL OR c.paciente LIKE :#{#filtro.paciente} + '%') "
			+ "	AND (:#{#filtro.medico} IS NULL OR c.medico LIKE '%' + :#{#filtro.medico} + '%') "
			+ "	AND (:#{#filtro.horarioConsulta} IS NULL OR c.horarioConsulta = :#{#filtro.horarioConsulta})")
	List<Consulta> findByFilter(@Param("filtro") ConsultaFilterDto filtro);
}
