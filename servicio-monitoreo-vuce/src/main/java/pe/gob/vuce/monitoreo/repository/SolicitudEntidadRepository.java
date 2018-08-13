package pe.gob.vuce.monitoreo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.vuce.monitoreo.entity.SolicitudEntidad;

@Repository
public interface SolicitudEntidadRepository extends JpaRepository<SolicitudEntidad, Long>{
	@Procedure(name = "reenviarTransaccion")
	String reenviarTransaccion(@Param("id_transmision") String id_transmision);
	@Procedure(name = "anularNotificacion")
	String anularNotificacion(@Param("vc_id") String vc_id);
	@Procedure(name = "reprocesarNotificacion")
	String reprocesarNotificacion(@Param("vc_id") String vc_id);
}