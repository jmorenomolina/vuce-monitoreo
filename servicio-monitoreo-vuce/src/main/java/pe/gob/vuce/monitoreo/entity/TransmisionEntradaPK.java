package pe.gob.vuce.monitoreo.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the NOTIFICACION database table.
 * 
 */
@Embeddable
public class TransmisionEntradaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="VE_ID")
	private long veId;

	@Column(name="ID_ENTIDAD")
	private long idEntidad;

	public TransmisionEntradaPK() {
	}
	public long getVeId() {
		return this.veId;
	}
	public void setVeId(long veId) {
		this.veId = veId;
	}
	public long getIdEntidad() {
		return this.idEntidad;
	}
	public void setIdEntidad(long idEntidad) {
		this.idEntidad = idEntidad;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TransmisionEntradaPK)) {
			return false;
		}
		TransmisionEntradaPK castOther = (TransmisionEntradaPK)other;
		return 
			(this.veId == castOther.veId)
			&& (this.idEntidad == castOther.idEntidad);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.veId ^ (this.veId >>> 32)));
		hash = hash * prime + ((int) (this.idEntidad ^ (this.idEntidad >>> 32)));
		
		return hash;
	}
}