package pe.gob.vuce.entidad;

public class Transaccion {

	private int idTransmision;
	private String tipoMensaje;
	private String tipoDocumento;
	private String numeroDocumento;
	private String mensajeXML;
	private String ebXML;

	public Transaccion() {
		super();
	}

	public int getIdTransmision() {
		return idTransmision;
	}

	public void setIdTransmision(int idTransmision) {
		this.idTransmision = idTransmision;
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

	public String getMensajeXML() {
		return mensajeXML;
	}

	public void setMensajeXML(String mensajeXML) {
		this.mensajeXML = mensajeXML;
	}

	public String getEbXML() {
		return ebXML;
	}

	public void setEbXML(String ebXML) {
		this.ebXML = ebXML;
	}

}
