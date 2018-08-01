package pe.gob.vuce.alertas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TRANSACCION_SIN_CONFIRMAR")
public class TransaccionSinConfirmar implements Serializable {
	private static final long serialVersionUID = 1L;

	private long antiguedad;

	private String entidad;

	@Column(name="FECHA_PRIMERA_LECTURA")
	private String fechaPrimeraLectura;

	@Id
	@Column(name="ID_TRANSMISION")
	private long idTransmision;

	@Column(name="NUMERO_DOCUMENTO")
	private String numeroDocumento;

	@Column(name="TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name="TIPO_MENSAJE")
	private String tipoMensaje;

	@Column(name="ID_ENTIDAD")
	private long idEntidad;

	public TransaccionSinConfirmar() {
	}
	

	public long getIdEntidad() {
		return idEntidad;
	}


	public void setIdEntidad(long idEntidad) {
		this.idEntidad = idEntidad;
	}


	public long getAntiguedad() {
		return this.antiguedad;
	}

	public void setAntiguedad(long antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getEntidad() {
		return this.entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getFechaPrimeraLectura() {
		return this.fechaPrimeraLectura;
	}

	public void setFechaPrimeraLectura(String fechaPrimeraLectura) {
		this.fechaPrimeraLectura = fechaPrimeraLectura;
	}

	public long getIdTransmision() {
		return this.idTransmision;
	}

	public void setIdTransmision(long idTransmision) {
		this.idTransmision = idTransmision;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoMensaje() {
		return this.tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

}