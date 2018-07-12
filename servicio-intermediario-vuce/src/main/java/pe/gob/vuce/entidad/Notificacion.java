package pe.gob.vuce.entidad;

public class Notificacion {
	
	private int numeroNotificacion;
	private String tipoMensaje;
	private String tipoDocumento;
	private String numeroDocumento;
	private int entidad;
	
	public Notificacion() {
	}

	public int getEntidad() {
		return entidad;
	}

	public void setEntidad(int entidad) {
		this.entidad = entidad;
	}

	public int getNumeroNotificacion() {
		return numeroNotificacion;
	}

	public void setNumeroNotificacion(int numeroNotificacion) {
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
