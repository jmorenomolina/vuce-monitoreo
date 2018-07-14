package pe.gob.vuce.monitoreo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACCION")
public class Transaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAN_SEQ")
    @SequenceGenerator(sequenceName = "transaccion_seq", allocationSize = 1, name = "TRAN_SEQ")
	private int idTransaccion;
	private int idTransmision;
	private String numeroDocumento;
	private String tipoDocumento;
	private String tipoMensaje;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_MENSAJE")
	private SolicitudEntidad solicitudEntidad;

	public SolicitudEntidad getSolicitudEntidad() {
		return solicitudEntidad;
	}

	public void setSolicitudEntidad(SolicitudEntidad solicitudEntidad) {
		this.solicitudEntidad = solicitudEntidad;
	}

	public Transaccion() {
		super();
	}
	
	public int getIdTransmision() {
		return idTransmision;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setIdTransmision(int idTransmision) {
		this.idTransmision = idTransmision;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

		public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

}
