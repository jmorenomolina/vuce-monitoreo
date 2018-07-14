package pe.gob.vuce.monitoreo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.vuce.monitoreo.entity.SolicitudEntidad;
import pe.gob.vuce.monitoreo.repository.SolicitudEntidadRepository;

@Component
public class SolicitudEntidadComponent {
	
    private final SolicitudEntidadRepository solicitudEntidadRepository;
    
    @Autowired
    public SolicitudEntidadComponent(SolicitudEntidadRepository solicitudEntidadRepository) {
    	super();  
    	this.solicitudEntidadRepository = solicitudEntidadRepository;
    }
    
    public void registrarSolicitud(SolicitudEntidad solicitudEntidad) {
    	solicitudEntidadRepository.save(solicitudEntidad);
    }

}
