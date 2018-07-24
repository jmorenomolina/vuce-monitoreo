package pe.gob.vuce.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the VIEW_DETALLE_TRANSACCIONES database table.
 * 
 */
@Entity
@Table(name="VIEW_DETALLE_TRANSACCIONES")
@NamedQuery(name="ViewDetalleTransacciones.findAll", query="SELECT v FROM ViewDetalleTransacciones v")
public class ViewDetalleTransacciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CANTIDAD_LECTURAS")
	private Integer cantidadLecturas;

	private Integer entidad;

	@Column(name="ESTADO_CONFIRMACION")
	private Integer estadoConfirmacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_PRIMERA_LECTURA")
	private Date fechaPrimeraLectura;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CONFIRMACION")
	private Date fechaConfirmacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ULTIMA_LECTURA")
	private Date fechaUltimaLectura;

	@Column(name="ID_MENSAJE")
	private String idMensaje;

	@Id
	@Column(name="ID_TRANSMISION")
	private Integer idTransmision;

	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;

	@Column(name="NUMERO_DOCUMENTO")
	private String numeroDocumento;

	@Column(name="SIGLAS_ENTIDAD")
	private String siglasEntidad;

	@Column(name="TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name="TIPO_MENSAJE")
	private String tipoMensaje;

	public ViewDetalleTransacciones() {
	}

	public Integer getCantidadLecturas() {
		return this.cantidadLecturas;
	}

	public void setCantidadLecturas(Integer cantidadLecturas) {
		this.cantidadLecturas = cantidadLecturas;
	}

	public Integer getEntidad() {
		return this.entidad;
	}

	public void setEntidad(Integer entidad) {
		this.entidad = entidad;
	}

	public Integer getEstadoConfirmacion() {
		return this.estadoConfirmacion;
	}

	public void setEstadoConfirmacion(Integer estadoConfirmacion) {
		this.estadoConfirmacion = estadoConfirmacion;
	}

	public Date getFechaPrimeraLectura() {
		return this.fechaPrimeraLectura;
	}

	public void setFechaPrimeraLectura(Date fechaPrimeraLectura) {
		this.fechaPrimeraLectura = fechaPrimeraLectura;
	}

	public Date getFechaConfirmacion() {
		return this.fechaConfirmacion;
	}

	public void setFechaConfirmacion(Date fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}

	public Date getFechaUltimaLectura() {
		return this.fechaUltimaLectura;
	}

	public void setFechaUltimaLectura(Date fechaUltimaLectura) {
		this.fechaUltimaLectura = fechaUltimaLectura;
	}

	public String getIdMensaje() {
		return this.idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public Integer getIdTransmision() {
		return this.idTransmision;
	}

	public void setIdTransmision(Integer idTransmision) {
		this.idTransmision = idTransmision;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getSiglasEntidad() {
		return this.siglasEntidad;
	}

	public void setSiglasEntidad(String siglasEntidad) {
		this.siglasEntidad = siglasEntidad;
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