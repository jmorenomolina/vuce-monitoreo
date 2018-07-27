package pe.gob.vuce.alertas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ALERTA database table.
 * 
 */
@Entity
@NamedQuery(name="Alerta.findAll", query="SELECT a FROM Alerta a")
public class Alerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALERTA_SEQ")
	@SequenceGenerator(name="ALERTA_SEQ", sequenceName = "ALERTA_SEQ")
	@Column(name="ID_ALERTA")
	private long idAlerta;

	private String asunto;

	private BigDecimal enviada;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="NUMERO_DOCUMENTO")
	private String numeroDocumento;

	@Column(name="TIPO_ALERTA")
	private String tipoAlerta;

	@Column(name="TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name="TIPO_MENSAJE")
	private String tipoMensaje;

	public Alerta() {
	}

	public long getIdAlerta() {
		return this.idAlerta;
	}

	public void setIdAlerta(long idAlerta) {
		this.idAlerta = idAlerta;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public BigDecimal getEnviada() {
		return this.enviada;
	}

	public void setEnviada(BigDecimal enviada) {
		this.enviada = enviada;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoAlerta() {
		return this.tipoAlerta;
	}

	public void setTipoAlerta(String tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
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