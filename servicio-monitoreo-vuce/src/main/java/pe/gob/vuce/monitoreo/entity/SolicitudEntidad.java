package pe.gob.vuce.monitoreo.entity;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;;

@Entity
@Table(name = "SOLICITUDENTIDAD")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "reenviarTransaccion", procedureName = "REENVIAR_TRANSACCION", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "id_transmision", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje_error", type = String.class) }),
		@NamedStoredProcedureQuery(name = "anularNotificacion", procedureName = "ANULAR_NOTIFICACION", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "vc_id", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje_error", type = String.class) }),
		@NamedStoredProcedureQuery(name = "reprocesarNotificacion", procedureName = "REPROCESAR_NOTIFICACION", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "vc_id", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje_error", type = String.class) }) })
public class SolicitudEntidad {

	@Id
	private String idMensaje;
	private String descripcionFalla;
	private Date fechaHoraRespuesta;
	private Date fechaHoraSolicitud;
	private int hayFalla = 1;
	private String nombreOperacion;
	private String nombreUsuario;
	private String version;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "solicitudEntidad")
	private List<Notificacion> notificaciones;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "solicitudEntidad")
	private List<RecepcionTransaccion> recepcionTransacciones;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "solicitudEntidad")
	private List<Transaccion> transacciones;

	public SolicitudEntidad() {
		super();
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

	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
		for (Iterator<Notificacion> iterator = notificaciones.iterator(); iterator.hasNext();) {
			Notificacion notificacion = (Notificacion) iterator.next();
			notificacion.setSolicitudEntidad(this);
		}
	}

	public List<RecepcionTransaccion> getRecepcionTransacciones() {
		return recepcionTransacciones;
	}

	public void setRecepcionTransacciones(List<RecepcionTransaccion> recepcionTransacciones) {
		this.recepcionTransacciones = recepcionTransacciones;
		for (Iterator<RecepcionTransaccion> iterator = recepcionTransacciones.iterator(); iterator.hasNext();) {
			RecepcionTransaccion recepcionTransaccion = (RecepcionTransaccion) iterator.next();
			recepcionTransaccion.setSolicitudEntidad(this);
		}
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
		for (Iterator<Transaccion> iterator = transacciones.iterator(); iterator.hasNext();) {
			Transaccion transaccion = (Transaccion) iterator.next();
			transaccion.setSolicitudEntidad(this);
		}
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
