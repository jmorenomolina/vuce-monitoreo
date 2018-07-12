package pe.gob.vuce.entidad;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class SolicitudEntidad {

	private static final String USERNAME = "Username";
	private String descripcionFalla = "No hay falla";
	private Date fechaHoraRespuesta;
	private Date fechaHoraSolicitud;
	private int hayFalla = 1;
	private String idMensaje;
	private String nombreOperacion;
	private String nombreUsuario;
	private List<Transaccion> transacciones;

	private String version = "1.0";

	public SolicitudEntidad(String request) {
		super();
		fechaHoraSolicitud = new Date();
		extraerElementos(request);
	}

	private void extraerElementos(String request) throws FactoryConfigurationError {
		try {

			XMLInputFactory factory = XMLInputFactory.newInstance();
			byte[] byteArray;
			byteArray = request.getBytes("UTF-8");

			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
			XMLEventReader eventReader = factory.createXMLEventReader(inputStream);

			String qName = null;
			while (eventReader.hasNext()) {

				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					qName = startElement.getName().getLocalPart();
				}

				if (event.getEventType() == XMLStreamConstants.CHARACTERS) {
					Characters characters = event.asCharacters();
					String data = characters.getData().trim();
					if (data.length() >= 1)
						if (qName.equals(USERNAME)) {
							nombreUsuario = data;
							break;
						}
				}
			}

		} catch (

				UnsupportedEncodingException | XMLStreamException e) {
			e.printStackTrace();

		}
	}

	public String getDescripcionFalla() {
		return descripcionFalla;
	}

	public Date getFechaHoraRespuesta() {
		return fechaHoraRespuesta;
	}

	public Date getFechaHoraSolicitud() {
		return fechaHoraSolicitud;
	}

	public int getHayFalla() {
		return hayFalla;
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public String getNombreOperacion() {
		return nombreOperacion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public String getVersion() {
		return version;
	}

	public void setDescripcionFalla(String descripcionFalla) {
		this.descripcionFalla = descripcionFalla;
	}

	public void setFechaHoraRespuesta(Date fechaHoraRespuesta) {
		this.fechaHoraRespuesta = fechaHoraRespuesta;
	}

	public void setFechaHoraSolicitud(Date fechaHoraSolicitud) {
		this.fechaHoraSolicitud = fechaHoraSolicitud;
	}

	public void setHayFalla(int hayFalla) {
		this.hayFalla = hayFalla;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public void setNombreOperacion(String nombreOperacion) {
		this.nombreOperacion = nombreOperacion;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
}
