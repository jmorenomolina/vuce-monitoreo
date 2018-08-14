package pe.gob.vuce.alertas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the TRANSACCION_INCIDENTE database table.
 * 
 */
@Entity
@Table(name="TRANSACCION_INCIDENTE")
@NamedQuery(name="TransaccionIncidente.findAll", query="SELECT t FROM TransaccionIncidente t")
public class TransaccionIncidente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer antiguedad;

	@Column(name="CANTIDAD_LECTURAS")
	private Integer cantidadLecturas;

	private String entidad;

	@Column(name="FECHA_CONFIRMACION")
	private String fechaConfirmacion;

	@Column(name="FECHA_CREACION")
	private String fechaCreacion;

	@Column(name="FECHA_PRIMERA_LECTURA")
	private String fechaPrimeraLectura;

	@Column(name="ID_ENTIDAD")
	private String idEntidad;

	@Column(name="ID_TRANSMISION")
	@Id
	private Integer idTransmision;

	@Column(name="NUMERO_DOCUMENTO")
	private String numeroDocumento;

	@Column(name="TAMANO_ADJUNTOS")
	private Integer tamanoAdjuntos;

	private Integer tipo;

	@Column(name="TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name="TIPO_MENSAJE")
	private String tipoMensaje;

	public TransaccionIncidente() {
	}

	public Integer getAntiguedad() {
		return this.antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Integer getCantidadLecturas() {
		return this.cantidadLecturas;
	}

	public void setCantidadLecturas(Integer cantidadLecturas) {
		this.cantidadLecturas = cantidadLecturas;
	}


	public String getEntidad() {
		return this.entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getFechaConfirmacion() {
		return this.fechaConfirmacion;
	}

	public void setFechaConfirmacion(String fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}

	public String getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaPrimeraLectura() {
		return this.fechaPrimeraLectura;
	}

	public void setFechaPrimeraLectura(String fechaPrimeraLectura) {
		this.fechaPrimeraLectura = fechaPrimeraLectura;
	}

	public String getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Integer getIdTransmision() {
		return this.idTransmision;
	}

	public void setIdTransmision(Integer idTransmision) {
		this.idTransmision = idTransmision;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Integer getTamanoAdjuntos() {
		return this.tamanoAdjuntos;
	}

	public void setTamanoAdjuntos(Integer tamanoAdjuntos) {
		this.tamanoAdjuntos = tamanoAdjuntos;
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

}