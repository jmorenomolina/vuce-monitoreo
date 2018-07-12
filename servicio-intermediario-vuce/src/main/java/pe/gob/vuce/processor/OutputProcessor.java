package pe.gob.vuce.processor;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import pe.gob.vuce.entidad.SolicitudEntidad;

public class OutputProcessor implements Processor {

	

	@Override
	public void process(final Exchange exchange) throws Exception {

		SolicitudEntidad solicitud = exchange.getProperty("solicitud", SolicitudEntidad.class);
		solicitud.setFechaHoraRespuesta(new Date());
		solicitud.setHayFalla(0);
		exchange.setProperty("solicitud", solicitud);
		
	}
}