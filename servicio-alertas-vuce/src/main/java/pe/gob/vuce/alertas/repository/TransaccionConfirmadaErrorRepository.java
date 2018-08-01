package pe.gob.vuce.alertas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.vuce.alertas.entity.TransaccionConfirmadaError;
import pe.gob.vuce.alertas.entity.TransaccionSinConfirmar;

public interface TransaccionConfirmadaErrorRepository extends JpaRepository<TransaccionConfirmadaError,Long> {
	List<TransaccionConfirmadaError> findByIdEntidad(long idEntidad);
}
