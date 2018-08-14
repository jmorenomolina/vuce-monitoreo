package pe.gob.vuce.alertas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.vuce.alertas.entity.NotificacionIncidente;


public interface NotificacionIncidenteRepository extends JpaRepository<NotificacionIncidente,Long> {
	List<NotificacionIncidente> findByIdEntidad(String idEntidad);
}
