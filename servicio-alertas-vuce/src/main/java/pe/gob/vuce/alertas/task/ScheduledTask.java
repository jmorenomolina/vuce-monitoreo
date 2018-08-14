package pe.gob.vuce.alertas.task;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pe.gob.vuce.alertas.component.InformeIncidentesComponent;

@Component
public class ScheduledTask {

	//private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

	@Autowired
	InformeIncidentesComponent incidenteComponent;

	@Scheduled(fixedRate = 60000)
	public void enviarAlertas() {
		incidenteComponent.enviarInformeIncidentes(true);
	}
}