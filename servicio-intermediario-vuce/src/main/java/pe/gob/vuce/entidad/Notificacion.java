package pe.gob.vuce.entidad;

public class Notificacion {
	
	private int entidad;
	private String numeroDocumento;
	private int numeroNotificacion;
	private String tipoDocumento;
	private String tipoMensaje;
	private String referenciaNumeroDocumento;
	private String referenciaTipoDocumento;

	public Notificacion() {
	}

	public String getReferenciaNumeroDocumento() {
		return referenciaNumeroDocumento;
	}

	public void setReferenciaNumeroDocumento(String referenciaNumeroDocumento) {
		this.referenciaNumeroDocumento = referenciaNumeroDocumento;
	}

	public String getReferenciaTipoDocumento() {
		return referenciaTipoDocumento;
	}

	public void setReferenciaTipoDocumento(String referenciaTipoDocumento) {
		this.referenciaTipoDocumento = referenciaTipoDocumento;
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



}
