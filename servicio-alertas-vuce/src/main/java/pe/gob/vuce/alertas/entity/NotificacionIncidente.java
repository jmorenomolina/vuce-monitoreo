package pe.gob.vuce.alertas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the NOTIFICACION_INCIDENTE database table.
 * 
 */
@Entity
@Table(name="NOTIFICACION_INCIDENTE")
@NamedQuery(name="NotificacionIncidente.findAll", query="SELECT n FROM NotificacionIncidente n")
public class NotificacionIncidente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer antiguedad;

	private String entidad;

	@Column(name="FECHA_PROCESAMIENTO")
	private String fechaProcesamiento;

	@Column(name="FECHA_RECEPCION")
	private String fechaRecepcion;

	@Column(name="ID_ENTIDAD")
	private String idEntidad;

	@Column(name="NUMERO_DOCUMENTO")
	private String numeroDocumento;

	private Integer tipo;

	@Column(name="TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name="TIPO_MENSAJE")
	private String tipoMensaje;

	@Column(name="VC_ID")
	private Integer vcId;

	@Column(name="VE_ID")
	@Id
	private Integer veId;

	public NotificacionIncidente() {
	}

	public Integer getAntiguedad() {
		return this.antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getEntidad() {
		return this.entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getFechaProcesamiento() {
		return this.fechaProcesamiento;
	}

	public void setFechaProcesamiento(String fechaProcesamiento) {
		this.fechaProcesamiento = fechaProcesamiento;
	}

	public String getFechaRecepcion() {
		return this.fechaRecepcion;
	}

	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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

	public Integer getVcId() {
		return this.vcId;
	}

	public void setVcId(Integer vcId) {
		this.vcId = vcId;
	}

	public Integer getVeId() {
		return this.veId;
	}

	public void setVeId(Integer veId) {
		this.veId = veId;
	}


}