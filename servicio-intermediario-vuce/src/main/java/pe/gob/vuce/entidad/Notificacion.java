package pe.gob.vuce.entidad;

public class Notificacion {
	
	private String numeroNotificacion;
	private String tipoMensaje;
	private String tipoDocumento;
	private String numeroDocumento;
	
	public Notificacion() {
	}

	public String getNumeroNotificacion() {
		return numeroNotificacion;
	}

	public void setNumeroNotificacion(String numeroNotificacion) {
		this.numeroNotificacion = numeroNotificacion;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


}
