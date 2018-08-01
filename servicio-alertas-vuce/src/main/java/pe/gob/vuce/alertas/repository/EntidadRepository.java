package pe.gob.vuce.alertas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.vuce.alertas.entity.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad,Long> {
}
