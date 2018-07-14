package pe.gob.vuce.monitoreo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RECEPCIONTRANSACCION")
public class RecepcionTransaccion {
	
	@Id
	private int idTransmision;
	private int error;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_MENSAJE")
	private SolicitudEntidad solicitudEntidad;
	
	public RecepcionTransaccion() {
	}

	public SolicitudEntidad getSolicitudEntidad() {
		return solicitudEntidad;
	}

	public void setSolicitudEntidad(SolicitudEntidad solicitudEntidad) {
		this.solicitudEntidad = solicitudEntidad;
	}

	public int getError() {
		return error;
	}

	public int getIdTransmision() {
		return idTransmision;
	}

	public void setError(int error) {
		this.error = error;
	}

	public void setIdTransmision(int idTransmision) {
		this.idTransmision = idTransmision;
	}


}
