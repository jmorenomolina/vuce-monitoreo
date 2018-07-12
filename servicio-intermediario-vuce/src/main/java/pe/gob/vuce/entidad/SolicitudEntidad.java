package pe.gob.vuce.entidad;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

import pe.gob.vuce.esquema.notificacion.NotificacionType;

public class SolicitudEntidad {

	private static final String ERROR = "error";
	private static final String ID_TRANSACCION = "idTransaccion";
	private static final String USERNAME = "Username";
	private static final String XMLNOTIFICACION = "xmlNotificacion";
	private String descripcionFalla = "No hay falla";
	private Date fechaHoraRespuesta;
	private Date fechaHoraSolicitud;
	private int hayFalla = 1;
	private String idMensaje;
	private String nombreOperacion;
	private String nombreUsuario;
	private List<Transaccion> transacciones;
	private Notificacion notificacion;
	private ConfirmacionRecepcionTransaccion confirmacionRecepcionTransaccion;

	private String version = "1.0";

	public SolicitudEntidad(String request) throws pe.gob.vuce.processor.ProcesadorMensajesVUCEException {
		super();
		fechaHoraSolicitud = new Date();
		extraerElementos_(request);
	}

	public ConfirmacionRecepcionTransaccion getConfirmacionRecepcionTransaccion() {
		return confirmacionRecepcionTransaccion;
	}

	public void setConfirmacionRecepcionTransaccion(ConfirmacionRecepcionTransaccion confirmacionRecepcionTransaccion) {
		this.confirmacionRecepcionTransaccion = confirmacionRecepcionTransaccion;
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

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}

	private void extraerElementos_(String request) throws pe.gob.vuce.processor.ProcesadorMensajesVUCEException {
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
						}
					
					if (data.length() >= 1)
						if (qName.equals(XMLNOTIFICACION)) {
							byte[] decodedBytes = Base64.getDecoder().decode(data);
							NotificacionType notificationType = (NotificacionType) getObjectFromXMLString(
									new String(decodedBytes), pe.gob.vuce.esquema.notificacion.ObjectFactory.class);
							notificacion = new Notificacion();
							notificacion.setNumeroDocumento(notificationType.getDocumento().getNumero());
							notificacion.setTipoDocumento(notificationType.getDocumento().getTipo());
							notificacion.setTipoMensaje(notificationType.getTipoMensaje());
							notificacion.setNumeroNotificacion(notificationType.getNumeroNotificacion());
							notificacion.setEntidad(notificationType.getEntidad());
							break;
						}
					
					if (data.length() >= 1)
						if (qName.equals(ID_TRANSACCION)) {
							confirmacionRecepcionTransaccion = new ConfirmacionRecepcionTransaccion();
							confirmacionRecepcionTransaccion.setIdTransmision(Integer.parseInt(data));
						}
					
					if (data.length() >= 1)
						if (qName.equals(ERROR)) {
							if (confirmacionRecepcionTransaccion != null)
								confirmacionRecepcionTransaccion.setError(Integer.parseInt(data));
						}
				}
			}

		} catch (

				UnsupportedEncodingException | XMLStreamException e) {
			throw new pe.gob.vuce.processor.ProcesadorMensajesVUCEException(e);

		}
	}

	@SuppressWarnings("unchecked")
	public static <T> Object getObjectFromXMLString(String xmlString, Class<?> objectFactory)
			throws pe.gob.vuce.processor.ProcesadorMensajesVUCEException {
		Object object = null;
		try {
			// org.eclipse.persistence.jaxb.JAXBContextFactory x;
			JAXBContext jaxbContext = JAXBContext.newInstance(objectFactory);
			object = ((JAXBElement<T>) jaxbContext.createUnmarshaller()
					.unmarshal(new StreamSource(new StringReader(xmlString)))).getValue();
		} catch (Exception e) {
			throw new pe.gob.vuce.processor.ProcesadorMensajesVUCEException(e);
		}
		return object;
	}
}
