package pe.gob.vuce.alertas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Entidad")
public class Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ENTIDAD")
	private long idEntidad;

	@Column(name="CORREO_SOPORTE")
	private String correoSoporte;

	private String entidad;

	@Column(name="NOMBRE_ENTIDAD")
	private String nombreEntidad;
	
	public Entidad() {
	}

	public long getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(long idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getCorreoSoporte() {
		return this.correoSoporte;
	}

	public void setCorreoSoporte(String correoSoporte) {
		this.correoSoporte = correoSoporte;
	}

	public String getEntidad() {
		return this.entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getNombreEntidad() {
		return this.nombreEntidad;
	}

	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}

}