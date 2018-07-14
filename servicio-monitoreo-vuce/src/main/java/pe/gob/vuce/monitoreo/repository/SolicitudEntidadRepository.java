package pe.gob.vuce.monitoreo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.vuce.monitoreo.entity.SolicitudEntidad;

public interface SolicitudEntidadRepository extends JpaRepository<SolicitudEntidad, Long>{
}