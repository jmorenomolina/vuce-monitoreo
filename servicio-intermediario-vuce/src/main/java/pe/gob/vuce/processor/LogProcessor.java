package pe.gob.vuce.processor;

import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.vuce.entidad.SolicitudEntidad;
import pe.gob.vuce.entidad.Transaccion;
import pe.gob.vuce.esquemas.TransaccionType;

public class LogProcessor implements Processor {

	public static final String MENSAJE_XML = "mensaje.xml";
	public static final String MENSAJE_EBXML = "formatoEBXML.xml";

	@Override
	public void process(final Exchange exchange) throws Exception {

		SolicitudEntidad solicitud = exchange.getProperty("solicitud", SolicitudEntidad.class);
		Message in = exchange.getIn();
		Map<String, DataHandler> adjuntos = in.getAttachments();

		ZipEntry ze = null;

		ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
		
		for (Map.Entry<String, DataHandler> entry : adjuntos.entrySet()) {

			DataHandler dataHandler = entry.getValue();
			ZipInputStream zis = null;

			Transaccion transaccion = new Transaccion();
		

			// Abrir el archivo zip

			try {

				InputStream is = dataHandler.getInputStream();
				DataHandler dh = new DataHandler(dataHandler.getDataSource());
				zis = new ZipInputStream(dh.getInputStream(), Charset.forName("ISO-8859-1"));

				while ((ze = zis.getNextEntry()) != null) {

					String entryName = ze.getName();

					if (entryName.equals(MENSAJE_XML)) {

						String transaccionXML = extraerXML(zis);
						System.out.println("Transaccion: " + transaccionXML);

						try {

							TransaccionType tx = extraerMensajeXML(transaccionXML);
							transaccion.setIdTransmision(tx.getIdTransmision());
							transaccion.setTipoDocumento(tx.getDocumento().getTipo());
							transaccion.setNumeroDocumento(tx.getDocumento().getNumero());
							transaccion.setTipoMensaje(tx.getTipoMensaje());
							transaccion.setMensajeXML(transaccionXML);

							System.out.println("id transmision: " + tx.getIdTransmision());

						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}

					if (entryName.equals(MENSAJE_EBXML)) {

						String ebXML = extraerXML(zis); // Leer el ebXML
						transaccion.setEbXML(ebXML);

						System.out.println("EBXML: " + ebXML);
					}

					zis.closeEntry();
				}

			} finally {
				// Cerrar zip
				zis.close();
			}

			transacciones.add(transaccion);

		}

		solicitud.setTransacciones(transacciones);		
		ObjectMapper mapper = new ObjectMapper();
	    String jsonSolicitud = mapper.writeValueAsString(solicitud);
	    in.setBody(jsonSolicitud);
		System.out.println("version 1.1");

	}

	private String extraerXML(ZipInputStream zis) throws ProcesadorMensajesVUCEException {
		StringBuilder xmlSB = new StringBuilder();
		try {
			byte[] buffer = new byte[1024];
			int read;
			while ((read = zis.read(buffer, 0, 1024)) >= 0) {
				xmlSB.append(new String(buffer, 0, read, "ISO-8859-1"));
			}
		} catch (Exception e) {
			throw new ProcesadorMensajesVUCEException(e);
		}
		return xmlSB.toString();
	}

	private TransaccionType extraerMensajeXML(String xmlSB) throws ProcesadorMensajesVUCEException {
		TransaccionType transaccion = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TransaccionType.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			transaccion = (TransaccionType) unmarshaller.unmarshal(new StreamSource(new StringReader(xmlSB)));
		} catch (Exception e) {
			throw new ProcesadorMensajesVUCEException(e);
		}
		return transaccion;
	}

}
