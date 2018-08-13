package pe.gob.vuce.alertas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.vuce.alertas.entity.TransaccionSinConfirmar;


public interface TransaccionSinConfirmarRepository extends JpaRepository<TransaccionSinConfirmar,Long> {
	List<TransaccionSinConfirmar> findByIdEntidad(long idEntidad);
}
