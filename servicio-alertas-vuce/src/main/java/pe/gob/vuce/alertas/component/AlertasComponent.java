package pe.gob.vuce.alertas.component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import pe.gob.vuce.alertas.entity.Alerta;
import pe.gob.vuce.alertas.entity.AlertaPlantilla;
import pe.gob.vuce.alertas.repository.AlertaPlantillaRepository;
import pe.gob.vuce.alertas.repository.AlertaRepository;
import pe.gob.vuce.alertas.task.ScheduledTask;

@Component
public class AlertasComponent {

	private static final Logger log = LoggerFactory.getLogger(AlertasComponent.class);

	private AlertaRepository alertaRepository;
	private List<AlertaPlantilla> alertasPlantillas;
	private JdbcTemplate template;

	public AlertasComponent() {

	}

	@Autowired
	public AlertasComponent(AlertaPlantillaRepository alertaPlantillaRepository, AlertaRepository alertaRepository) {
		this.alertaRepository = alertaRepository;
		alertasPlantillas = alertaPlantillaRepository.findAll();
	}

	public List<AlertaPlantilla> getAlertasPlantillas() {
		return alertasPlantillas;
	}

	public void saveAlerta(Alerta alerta) {
		alertaRepository.save(alerta);
	}

	public void generarAlertas() {
		log.info("Iniciando la generación de alertas");
		AlertaPlantilla alertaPlantilla = null;
		for (Iterator<AlertaPlantilla> iterator = alertasPlantillas.iterator(); iterator.hasNext();) {
			alertaPlantilla = (AlertaPlantilla) iterator.next();
			// BLOQUE PARA PROCESAR UNA PLANTILLA
			try {
				List<Map<String, Object>> alertas = template.queryForList(alertaPlantilla.getQuery());
				for (Iterator<Map<String, Object>> alerta = alertas.iterator(); alerta.hasNext();) {
					Map<String, Object> atributos = (Map<String, Object>) alerta.next();
					atributos.forEach((k, v) -> System.out.println((k + ":" + v)));
				}
			} catch (Exception e) {
				log.error("Se produjo un error durante la ejecución de la plantilla "
						+ alertaPlantilla.getIdAlertaConfiguracion(), e);
			}

		}
		log.info("Finalizando la generación de notificaciones masivas");

	}
}
