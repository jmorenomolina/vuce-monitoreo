package pe.gob.vuce.monitoreo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.vuce.monitoreo.entity.SolicitudEntidad;

@Component
public class JmsConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(JmsConsumer.class);
	private final String TRANSACCION_QUEUE = "cola-transacciones-vuce";		
    private final SolicitudEntidadComponent transaccionComponent;
    
    @Autowired
	public JmsConsumer(SolicitudEntidadComponent transaccionComponent) {
		super();
		this.transaccionComponent = transaccionComponent;
	}
	
	@SuppressWarnings("rawtypes")
	@JmsListener(destination = TRANSACCION_QUEUE, containerFactory = "myFactory")
	public void receiveMessage(Message message) {
		try {			
		    SolicitudEntidad solicitudEntidad = new ObjectMapper().readValue((String) message.getPayload(), SolicitudEntidad.class);
		    transaccionComponent.registrarSolicitud(solicitudEntidad);	
		} catch (Exception e) {			
			logger.error(e.getMessage());
			throw new RuntimeException();
		}
	}
}