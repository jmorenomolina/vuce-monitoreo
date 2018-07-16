package pe.gob.vuce.entidad;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

import pe.gob.vuce.esquema.notificacion.DocumentoReferenciaType;
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
	private List<Notificacion> notificaciones = new ArrayList<Notificacion>();
	private List<RecepcionTransaccion> recepcionTransacciones = new ArrayList<RecepcionTransaccion>();
	private List<Transaccion> transacciones = new ArrayList<Transaccion>();

	private String version = "1.0";

	public SolicitudEntidad(String request) throws pe.gob.vuce.processor.ProcesadorMensajesVUCEException {
		super();
		fechaHoraSolicitud = new Date();
		extraerElementos_(request);
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

	private void extraerElementos_(String request) throws pe.gob.vuce.processor.ProcesadorMensajesVUCEException {
		try {

			XMLInputFactory factory = XMLInputFactory.newInstance();
			byte[] byteArray;
			byteArray = request.getBytes("UTF-8");

			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
			XMLEventReader eventReader = factory.createXMLEventReader(inputStream);

			RecepcionTransaccion recepcionTransaccion = new RecepcionTransaccion();

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
							Notificacion notificacion = new Notificacion();
							notificacion.setNumeroDocumento(notificationType.getDocumento().getNumero());
							notificacion.setTipoDocumento(notificationType.getDocumento().getTipo());
							notificacion.setTipoMensaje(notificationType.getTipoMensaje());
							notificacion.setNumeroNotificacion(notificationType.getNumeroNotificacion());
							notificacion.setEntidad(notificationType.getEntidad());
							DocumentoReferenciaType referencia = notificationType.getDocumentoReferencia();
							if (referencia!=null) {
								notificacion.setNumeroDocumento(referencia.getNumero());
								notificacion.setTipoDocumento(referencia.getTipo());
							}
							notificaciones.add(notificacion);
							break;
						}

					if (data.length() >= 1)
						if (qName.equals(ID_TRANSACCION)) {
							recepcionTransaccion = new RecepcionTransaccion();
							recepcionTransaccion.setIdTransmision(Integer.parseInt(data));
						}

					if (data.length() >= 1)
						if (qName.equals(ERROR)) {
							if (recepcionTransaccion != null)
								recepcionTransaccion.setError(Integer.parseInt(data));
							recepcionTransacciones.add(recepcionTransaccion);
						}
				}
			}

		} catch (

				UnsupportedEncodingException | XMLStreamException e) {
			throw new pe.gob.vuce.processor.ProcesadorMensajesVUCEException(e);

		}
	}

	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public List<RecepcionTransaccion> getRecepcionTransacciones() {
		return recepcionTransacciones;
	}

	public void setRecepcionTransacciones(List<RecepcionTransaccion> recepcionTransacciones) {
		this.recepcionTransacciones = recepcionTransacciones;
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
