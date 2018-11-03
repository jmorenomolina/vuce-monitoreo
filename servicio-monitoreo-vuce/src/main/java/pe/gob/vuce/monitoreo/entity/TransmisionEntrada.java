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
@Table(name = "TRANSMISION_ENTRADA")
public class TransmisionEntrada {

	@EmbeddedId
	private TransmisionEntradaPK id;

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
	private TransmisionSalida solicitudEntidad;

	public TransmisionEntrada() {
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

	public TransmisionSalida getSolicitudEntidad() {
		return solicitudEntidad;
	}

	public void setSolicitudEntidad(TransmisionSalida solicitudEntidad) {
		this.solicitudEntidad = solicitudEntidad;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public TransmisionEntradaPK getId() {
		return id;
	}

	public void setId(TransmisionEntradaPK id) {
		this.id = id;
	}

}
