package pe.gob.vuce.monitoreo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NOTIFICACION")
public class Notificacion {

	@EmbeddedId
	private NotificacionPK id;

	@Column(name = "NUMERO_DOCUMENTO")
	private String numeroDocumento;

	@Column(name = "TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name = "TIPO_MENSAJE")
	private String tipoMensaje;

	@Lob
	private String xml;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MENSAJE")
	private SolicitudEntidad solicitudEntidad;

	public Notificacion() {
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public NotificacionPK getId() {
		return id;
	}

	public void setId(NotificacionPK id) {
		this.id = id;
	}

}
