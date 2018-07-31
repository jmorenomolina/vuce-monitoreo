package pe.gob.vuce.alertas.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertasComponent {

	private static final Logger log = LoggerFactory.getLogger(AlertasComponent.class);

	EmailServiceImpl emailServer; 
	
	public AlertasComponent() {

	}

	@Autowired
	public AlertasComponent(
			EmailServiceImpl emailServer) {
		//alertasPlantillas = alertaPlantillaRepository.findAll();
		this.emailServer = emailServer;
	}



	public void generarAlertas() {
		log.info("Iniciando la generación de alertas");
		
		//Leer todas las entidades en un map
		
	//	Map<Integer, String> result1 = list.stream().collect(
      //          Collectors.toMap(Hosting::getId, Hosting::getName));
		
		//Para cada entidad
		//	Leer las transacciones con incidentes
		//	Leer las notificaciones con incidentes
		//  Armar la plantilla con velocity
		//  Enviar el correo
		
		emailServer.sendSimpleMessage("jmorenomolina@gmail.com", "prueba", "contenido");
		/*AlertaPlantilla alertaPlantilla = null;
		for (Iterator<AlertaPlantilla> iterator = alertasPlantillas.iterator(); iterator.hasNext();) {
			alertaPlantilla = iterator.next();
			// BLOQUE PARA PROCESAR UNA PLANTILLA
			try {
				List<Map<String, Object>> alertas = template.queryForList(alertaPlantilla.getQuery());
				for (Iterator<Map<String, Object>> alerta = alertas.iterator(); alerta.hasNext();) {
					Map<String, Object> atributos = alerta.next();
					atributos.forEach((k, v) -> System.out.println((k + ":" + v)));
				}
			} catch (Exception e) {
				log.error("Se produjo un error durante la ejecución de la plantilla "
						+ alertaPlantilla.getIdAlertaConfiguracion(), e);
			}

		}*/
		log.info("Finalizando la generación de notificaciones masivas");

	}
}
