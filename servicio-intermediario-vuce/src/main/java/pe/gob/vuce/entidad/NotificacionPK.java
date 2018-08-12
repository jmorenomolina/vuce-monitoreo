package pe.gob.vuce.entidad;


public class NotificacionPK {

	private long veId;
	private long idEntidad;

	public NotificacionPK() {
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
		if (!(other instanceof NotificacionPK)) {
			return false;
		}
		NotificacionPK castOther = (NotificacionPK) other;
		return (this.veId == castOther.veId) && (this.idEntidad == castOther.idEntidad);
	}

}