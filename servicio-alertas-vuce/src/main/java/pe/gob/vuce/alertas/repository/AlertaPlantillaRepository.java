package pe.gob.vuce.alertas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.vuce.alertas.entity.AlertaPlantilla;

public interface AlertaPlantillaRepository extends JpaRepository<AlertaPlantilla, Long>{
}