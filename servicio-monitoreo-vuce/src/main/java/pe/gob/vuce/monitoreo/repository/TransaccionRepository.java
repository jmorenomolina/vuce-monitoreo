package pe.gob.vuce.monitoreo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.vuce.monitoreo.entity.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
}