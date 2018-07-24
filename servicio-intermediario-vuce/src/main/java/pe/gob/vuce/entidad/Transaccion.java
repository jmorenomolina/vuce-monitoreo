package pe.gob.vuce.entidad;

public class Transaccion {

	private String ebXML;
	private int idTransmision;
	private String mensajeXML;
	private String numeroDocumento;
	private String tipoDocumento;
	private String tipoMensaje;
	
	public Transaccion() {
		super();
	}
	public String getEbXML() {
		return ebXML;
	}
	
	public int getIdTransmision() {
		return idTransmision;
	}

	public String getMensajeXML() {
		return mensajeXML;
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

	public void setEbXML(String ebXML) {
		this.ebXML = ebXML;
	}

	public void setIdTransmision(int idTransmision) {
		this.idTransmision = idTransmision;
	}

	public void setMensajeXML(String mensajeXML) {
		this.mensajeXML = mensajeXML;
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



}