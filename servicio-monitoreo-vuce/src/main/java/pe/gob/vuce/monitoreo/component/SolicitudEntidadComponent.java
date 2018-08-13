package pe.gob.vuce.monitoreo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.vuce.monitoreo.entity.SolicitudEntidad;
import pe.gob.vuce.monitoreo.repository.SolicitudEntidadRepository;

@Component
@Transactional 
public class SolicitudEntidadComponent {

	private final SolicitudEntidadRepository solicitudEntidadRepository;

	@Autowired
	public SolicitudEntidadComponent(SolicitudEntidadRepository solicitudEntidadRepository) {
		super();
		this.solicitudEntidadRepository = solicitudEntidadRepository;
	}

	public void registrarSolicitud(SolicitudEntidad solicitudEntidad) {

		try {
			
			solicitudEntidadRepository.save(solicitudEntidad);
	
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
