package pe.gob.vuce.monitoreo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaccion {
		
	@Id
	@Column(name = "IDMENSAJE")
	private String idMensaje;
	@Column(name = "FECHAHORARESPUESTA")
	private Date fechaHoraRespuesta;
	@Column(name = "FECHAHORASOLICITUD")
	private Date fechaHoraSolicitud;
	@Column(name = "HAYFALLA")
	private int hayFalla;	
	@Column(name = "DESCRIPCIONFALLA")
	private String descripcionFalla;
	@Column(name = "NOMBREOPERACION")
	private String nombreOperacion;
	@Column(name = "NOMBREUSUARIO")
	private String nombreUsuario;
	@Column(name = "VERSION")
	private String version;

	public Transaccion() {
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

	@Override
	public String toString() {
		return "Transaccion [fechaHoraRespuesta=" + fechaHoraRespuesta + ", fechaHoraSolicitud="
				+ fechaHoraSolicitud + ", hayFalla=" + hayFalla + ", descripcionFalla=" + descripcionFalla
				+ ", idMensaje=" + idMensaje + ", nombreOperacion=" + nombreOperacion + ", nombreUsuario="
				+ nombreUsuario + ", version=" + version + "]";
	}
	
}
	
