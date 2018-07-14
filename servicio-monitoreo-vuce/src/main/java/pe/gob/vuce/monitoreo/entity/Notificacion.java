package pe.gob.vuce.monitoreo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NOTIFICACION")
public class Notificacion {
	
	@Id
	private int numeroNotificacion;
	private int entidad;
	private String numeroDocumento;
	private String tipoDocumento;
	private String tipoMensaje;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_MENSAJE")
	private SolicitudEntidad solicitudEntidad;
	
	public Notificacion() {
	}
	
	public int getEntidad() {
		return entidad;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public int getNumeroNotificacion() {
		return numeroNotificacion;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setEntidad(int entidad) {
		this.entidad = entidad;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public void setNumeroNotificacion(int numeroNotificacion) {
		this.numeroNotificacion = numeroNotificacion;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public SolicitudEntidad getSolicitudEntidad() {
		return solicitudEntidad;
	}

	public void setSolicitudEntidad(SolicitudEntidad solicitudEntidad) {
		this.solicitudEntidad = solicitudEntidad;
	}

}
