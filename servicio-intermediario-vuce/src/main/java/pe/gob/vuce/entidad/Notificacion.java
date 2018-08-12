package pe.gob.vuce.entidad;

public class Notificacion {

	private NotificacionPK id;

	private String numeroDocumento;
	private String tipoDocumento;
	private String tipoMensaje;
	private String xml;

	public Notificacion() {
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public NotificacionPK getId() {
		return id;
	}

	public void setId(NotificacionPK id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public String getXml() {
		return xml;
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

	public void setXml(String xml) {
		this.xml = xml;
	}

}
