package vuce.gob.pe.app.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cquevedo
 */
@Entity
@Table(name = "FRECUENCIA_LECTURA", schema="MTOBJ")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FrecuenciaLectura.findAll", query = "SELECT e FROM FrecuenciaLectura e")
})
public class FrecuenciaLectura implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_ENTIDAD")
	private Integer idEntidad;	

	@Basic(optional = false)
	@Column(name = "ENTIDAD")
	private String entidad;		
	
	@Basic(optional = false)
	@Column(name = "EN_MANTENIMIENTO")
	private Integer enMantenimiento;
	
	@Basic(optional = false)
	@Column(name = "FRECUENCIA_LECTURA_ESPERADA")
	private Integer frecuenciaLecturaEsperada;
	
	@Basic(optional = false)
	@Column(name = "FRECUENCIA_LECTURA_ACTUAL")
	private Integer frecuenciaLecturaActual;
	
	@Basic(optional = false)
	@Column(name = "CUMPLE_FRECUENCIA_LECTURA")
	private Integer cumpleFrecuenciaLectura;

	public Integer getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public Integer getEnMantenimiento() {
		return enMantenimiento;
	}

	public void setEnMantenimiento(Integer enMantenimiento) {
		this.enMantenimiento = enMantenimiento;
	}

	public Integer getFrecuenciaLecturaEsperada() {
		return frecuenciaLecturaEsperada;
	}

	public void setFrecuenciaLecturaEsperada(Integer frecuenciaLecturaEsperada) {
		this.frecuenciaLecturaEsperada = frecuenciaLecturaEsperada;
	}

	public Integer getFrecuenciaLecturaActual() {
		return frecuenciaLecturaActual;
	}

	public void setFrecuenciaLecturaActual(Integer frecuenciaLecturaActual) {
		this.frecuenciaLecturaActual = frecuenciaLecturaActual;
	}

	public Integer getCumpleFrecuenciaLectura() {
		return cumpleFrecuenciaLectura;
	}

	public void setCumpleFrecuenciaLectura(Integer cumpleFrecuenciaLectura) {
		this.cumpleFrecuenciaLectura = cumpleFrecuenciaLectura;
	}
	
	
	
}
