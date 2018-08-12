package pe.gob.vuce.entidad;

public class Notificacion {
	
	private int entidad;
	private String numeroDocumento;
	private int numeroNotificacion;
	private String referenciaNumeroDocumento;
	private String referenciaTipoDocumento;
	private String tipoDocumento;
	private String tipoMensaje;
    private String XML;
    
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

	public String getReferenciaNumeroDocumento() {
		return referenciaNumeroDocumento;
	}

	public String getReferenciaTipoDocumento() {
		return referenciaTipoDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public String getXML() {
		return XML;
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

	public void setReferenciaNumeroDocumento(String referenciaNumeroDocumento) {
		this.referenciaNumeroDocumento = referenciaNumeroDocumento;
	}

	public void setReferenciaTipoDocumento(String referenciaTipoDocumento) {
		this.referenciaTipoDocumento = referenciaTipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public void setXML(String xML) {
		XML = xML;
	}



}
