package pe.gob.vuce.processor;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import pe.gob.vuce.entidad.SolicitudEntidad;

public class FaultProcessor implements Processor {

	@Override
	public void process(final Exchange exchange) throws Exception {
		
		SolicitudEntidad transaccion = exchange.getProperty("solicitud", SolicitudEntidad.class);
		transaccion.setFechaHoraRespuesta(new Date());
		transaccion.setHayFalla(1);
		final Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
		transaccion.setDescripcionFalla(cause.getMessage());
		exchange.setProperty("solicitud", transaccion);
		
	}

	

}
