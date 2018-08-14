package pe.gob.vuce.alertas.component;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.vuce.alertas.entity.Entidad;
import pe.gob.vuce.alertas.entity.NotificacionIncidente;
import pe.gob.vuce.alertas.entity.TransaccionIncidente;
import pe.gob.vuce.alertas.repository.EntidadRepository;
import pe.gob.vuce.alertas.repository.NotificacionIncidenteRepository;
import pe.gob.vuce.alertas.repository.TransaccionIncidenteRepository;

@Component
public class InformeIncidentesComponent {

	private static final String INFORME_INCIDENTES_PLANTILLA = "InformeIncidentes.vm";

	private static final Logger log = LoggerFactory.getLogger(InformeIncidentesComponent.class);

	EntidadRepository entidadRepository;
	NotificacionIncidenteRepository notificacionRepository;
	TransaccionIncidenteRepository transaccionRepository;

	EmailComponent emailServer;

	public InformeIncidentesComponent() {

	}

	@Autowired
	public InformeIncidentesComponent(EmailComponent emailServer, EntidadRepository incidenteRepository,
			NotificacionIncidenteRepository transaccionSinConfirmarRepository,
			TransaccionIncidenteRepository transaccionConfirmadaErrorRepository) {

		this.emailServer = emailServer;
		this.entidadRepository = incidenteRepository;
		this.transaccionRepository = transaccionConfirmadaErrorRepository;
		this.notificacionRepository = transaccionSinConfirmarRepository;
	}

	// Editor https://html-online.com/editor/
	private String generarInforme(Entidad entidad, Object transacciones, Object notificaciones) {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		VelocityContext context = new VelocityContext();
		context.put("nombreEntidad", entidad.getEntidad());
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		context.put("fechaEnvio", hourdateFormat.format(new Date()));
		context.put("transacciones", transacciones);
		context.put("notificaciones", notificaciones);
		Template t = ve.getTemplate(INFORME_INCIDENTES_PLANTILLA);
		StringWriter sw = new StringWriter();
		t.merge(context, sw);
		return sw.toString();
	}

	public void enviarInformeIncidentes(boolean enviar) {

		log.info("Iniciando el envío de informes");
		List<Entidad> entidades = entidadRepository.findAll();
	
		for (Entidad entidad : entidades) {

			List<TransaccionIncidente> transacciones = transaccionRepository.findByIdEntidad(entidad.getIdEntidad());
			List<NotificacionIncidente> notificaciones = notificacionRepository.findByIdEntidad(entidad.getIdEntidad());

			if (transacciones.size() > 0 || notificaciones.size() > 0) {
				try {
					String contenido = generarInforme(entidad, transacciones, notificaciones);			
					if (enviar) emailServer.sendHtmlMail(entidad.getCorreoSoporte(), "Informe de incidentes", contenido);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}

		}
		log.info("Finalizando el envío de informes");
	}
}
