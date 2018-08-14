package pe.gob.vuce.alertas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.vuce.alertas.entity.TransaccionIncidente;

public interface TransaccionIncidenteRepository extends JpaRepository<TransaccionIncidente,Long> {
	List<TransaccionIncidente> findByIdEntidad(String idEntidad);
}
