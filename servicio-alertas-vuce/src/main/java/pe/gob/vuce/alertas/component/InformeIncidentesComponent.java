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
import pe.gob.vuce.alertas.entity.TransaccionConfirmadaError;
import pe.gob.vuce.alertas.entity.TransaccionSinConfirmar;
import pe.gob.vuce.alertas.repository.EntidadRepository;
import pe.gob.vuce.alertas.repository.TransaccionConfirmadaErrorRepository;
import pe.gob.vuce.alertas.repository.TransaccionSinConfirmarRepository;

@Component
public class InformeIncidentesComponent {

	private static final String INFORME_INCIDENTES_PLANTILLA = "InformeIncidentes.vm";

	private static final Logger log = LoggerFactory.getLogger(InformeIncidentesComponent.class);

	EntidadRepository entidadRepository;
	TransaccionSinConfirmarRepository transaccionSinConfirmarRepository;
	TransaccionConfirmadaErrorRepository transaccionConfirmadaErrorRepository;

	EmailComponent emailServer;

	public InformeIncidentesComponent() {

	}

	@Autowired
	public InformeIncidentesComponent(EmailComponent emailServer, EntidadRepository incidenteRepository,
			TransaccionSinConfirmarRepository transaccionSinConfirmarRepository,
			TransaccionConfirmadaErrorRepository transaccionConfirmadaErrorRepository) {

		this.emailServer = emailServer;
		this.entidadRepository = incidenteRepository;
		this.transaccionConfirmadaErrorRepository = transaccionConfirmadaErrorRepository;
		this.transaccionSinConfirmarRepository = transaccionSinConfirmarRepository;
	}

	// Editor https://html-online.com/editor/
	private String generarInforme(Entidad entidad, Object transaccionesSinConfirmar,
			Object transaccionesConfirmadasError) {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		VelocityContext context = new VelocityContext();
		context.put("nombreEntidad", entidad.getEntidad());
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		context.put("fechaEnvio", hourdateFormat.format(new Date()));
		context.put("transaccionesSinConfirmar", transaccionesSinConfirmar);
		context.put("transaccionesConfirmadasError", transaccionesConfirmadasError);
		Template t = ve.getTemplate(INFORME_INCIDENTES_PLANTILLA);
		StringWriter sw = new StringWriter();
		t.merge(context, sw);
		return sw.toString();
	}

	public void enviarInformeIncidentes() {

		log.info("Iniciando el envío de informes");
		
		List<Entidad> entidades = entidadRepository.findAll();
		
		for (Entidad entidad : entidades) {

			List<TransaccionSinConfirmar> transaccionesSinConfirmar = transaccionSinConfirmarRepository
					.findByIdEntidad(entidad.getIdEntidad());
			
			List<TransaccionConfirmadaError> transaccionesConfirmadaError = transaccionConfirmadaErrorRepository
					.findByIdEntidad(entidad.getIdEntidad());

			if (transaccionesSinConfirmar.size() > 0 || transaccionesConfirmadaError.size() > 0) {
				
				try {
					
					String contenido = generarInforme(entidad, transaccionesSinConfirmar, transaccionesConfirmadaError);
					emailServer.sendHtmlMail(entidad.getCorreoSoporte(), "Informe de incidentes", contenido);
					
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
			
		}
		
		log.info("Finalizando el envío de informes");
	}
}
