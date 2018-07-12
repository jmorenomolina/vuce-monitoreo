package pe.gob.vuce.monitoreo.component;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.vuce.monitoreo.entity.Transaccion;

@Component
public class JmsConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(JmsConsumer.class);
	private final String TRANSACCION_QUEUE = "cola-transacciones-vuce";		
    private final TransaccionComponent transaccionComponent;
    
    @Autowired
	public JmsConsumer(TransaccionComponent transaccionComponent) {
		super();
		this.transaccionComponent = transaccionComponent;
	}
	
	@JmsListener(destination = TRANSACCION_QUEUE, containerFactory = "myFactory")
	public void receiveMessage(final byte[] message) {
		try {			
		    Transaccion transaccion = new ObjectMapper().readValue(new String(message, "UTF8"), Transaccion.class);
		    System.out.println("hola " + transaccion.getNombreOperacion());
		  //  System.out.println("Tamaño: " + transaccion.getAdjuntos().size());
			transaccionComponent.registrarTransaccion(transaccion);	
		} catch (RuntimeException | IOException e) {			
			logger.error(e.getMessage());
			throw new RuntimeException();
		}
	}
}