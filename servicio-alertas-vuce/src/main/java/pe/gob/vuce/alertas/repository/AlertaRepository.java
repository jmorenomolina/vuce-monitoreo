package pe.gob.vuce.alertas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.vuce.alertas.entity.Alerta;

public interface AlertaRepository extends JpaRepository<Alerta, Long>{
}