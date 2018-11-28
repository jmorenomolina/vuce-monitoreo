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
@Table(name = "TX_ENTIDAD")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e"),
		@NamedQuery(name = "Entidad.findByIdEntidad", query = "SELECT e FROM Entidad e WHERE e.idEntidad = :idEntidad"),		
		@NamedQuery(name = "Entidad.findByDescripcion", query = "SELECT e FROM Entidad e WHERE e.descripcion = :descripcion"),		
		@NamedQuery(name = "Entidad.findByColor", query = "SELECT e FROM Entidad e WHERE e.color = :color"),		
		@NamedQuery(name = "Entidad.findByEstado", query = "SELECT e FROM Entidad e WHERE e.estado = :estado")
})
public class Entidad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_ENTIDAD")
	private Integer idEntidad;	

	@Basic(optional = false)
	@NotNull()
	@Size(min = 1, max = 50)
	@Column(name = "DESCRIPCION")
	private String descripcion;	
	
	@Basic(optional = false)
	@NotNull()
	@Size(min = 1, max = 100)
	@Column(name = "COLOR")
	private String color;
	
	@Basic(optional = false)
	@NotNull()
	@Size(min = 1, max = 1)
	@Column(name = "ESTADO")
	private String estado;

	public Integer getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
